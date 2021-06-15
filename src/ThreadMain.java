import thread.ProduceQueue;

public class ThreadMain {
    public static void main(String[] args) {
        ProduceQueue work = new ProduceQueue();
        int c = 0;
        int p = 0;
/*        for (; ; ) {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                work.consumer();
            }, "consumer " + (c++)).start();
            new Thread(() -> {
                work.produce();
            }, "producer " + (p++)).start();
        }*/



        Integer a=null;
        Integer b=null;
        System.out.println(a==b);
    }
}
