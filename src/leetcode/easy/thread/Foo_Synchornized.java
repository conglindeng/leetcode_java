package leetcode.easy.thread;

public class Foo_Synchornized {
    private static final Object lock=new Object();
    private volatile int flag=1;

    public Foo_Synchornized() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock){
            while(flag!=1){
                lock.wait();
            }
            flag++;
            printFirst.run();
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock){
            while(flag!=2){
                lock.wait();
            }
            flag++;
            printSecond.run();
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock){
            while(flag!=3){
                lock.wait();
            }
            printThird.run();
            lock.notifyAll();
        }
    }
}
