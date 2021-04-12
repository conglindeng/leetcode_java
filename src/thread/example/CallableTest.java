package thread.example;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor execute = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        Callable<String> callable1= () -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(20000);
            System.out.println("i`m running");
            return "it`s me";
        };

        Future<String> submit = execute.submit(callable1);

        try{
            System.out.println(submit.get(1000l,TimeUnit.MILLISECONDS));
        }catch (Exception e){

        }
        execute.shutdown();
        System.out.println("already shutdown");

    }
}
