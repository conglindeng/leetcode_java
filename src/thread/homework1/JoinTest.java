package thread.homework1;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                System.out.println("start run");
                Thread.sleep(1000);
                System.out.println("end run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("main start");
        a.start();
        //
        a.join();

        System.out.println("main end");
    }
}
