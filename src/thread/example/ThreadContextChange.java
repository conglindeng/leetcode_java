package thread.example;

public class ThreadContextChange {
    private static final long count = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        concurrency();
        serial();
    }

    private static void concurrency() throws Exception {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a += 1;
                }
                long time = System.currentTimeMillis() - start;
                System.out.println("thread for ：" + time );
            }
        });
        thread.start();
        //long start = System.currentTimeMillis();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("Concurrency：" + time + "ms, b = " + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 1;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Serial：" + time + "ms, b = " + b + ", a = " + a);
    }
}
