package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
    private static final BlockingQueue<String> queue=new LinkedBlockingQueue<>(3);


    public static void main(String[] args) {
        try {
            queue.put("1");
            queue.put("2");
            queue.put("3");

            new Thread(()->{
                System.out.println(queue);
                System.out.println(queue.poll());
                System.out.println(queue);
            }).start();


            Thread.sleep(500);
            System.out.println(queue);
            queue.put("4");
            System.out.println(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
