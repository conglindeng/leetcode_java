package thread;

import java.util.concurrent.*;

public class HandleException {
    private final static ExecutorService executor=new ThreadPoolTest(1,1,0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    public static void main(String[] args) {
        String a1=String.valueOf(1);
        try {
            Future<?> submit = executor.submit(() -> {
                double a = 1 / 0;
            });
            submit.get();
        }catch (Exception e){
            e.printStackTrace();
            executor.shutdown();
            try {
                if(!executor.awaitTermination(100,TimeUnit.MILLISECONDS))
                    executor.shutdownNow();
            } catch (InterruptedException e1) {
                executor.shutdownNow();
            }
        }
    }
}
