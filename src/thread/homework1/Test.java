package thread.homework1;

public class Test {
    private  static volatile Boolean flag=false;
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("thread end");
        });
        thread.start();

        while (!flag){

        }

        System.out.println("main end");

    }
}
