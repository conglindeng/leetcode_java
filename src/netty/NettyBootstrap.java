package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyBootstrap {
    public static void main(String[] args) {
        ServerBootstrap server=new ServerBootstrap();
        NioEventLoopGroup boss=new NioEventLoopGroup(2);
        NioEventLoopGroup work=new NioEventLoopGroup();
        try {
            server.group(boss,work).
                    childOption(ChannelOption.SO_BACKLOG,100)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addFirst(new StringDecoder());
                        }
                    });

            ChannelFuture bind = server.bind(9999).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
