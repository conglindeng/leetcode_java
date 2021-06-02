package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest extends ThreadPoolExecutor {

    public ThreadPoolTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        if(t!=null){
            System.out.println("回滚操作");
        }
        this.shutdown();
        try {
            if(this.awaitTermination(1000,TimeUnit.MILLISECONDS))
                this.shutdownNow();
        } catch (InterruptedException e) {
            this.shutdownNow();
        }
    }
}
