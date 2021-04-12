package leetcode.easy.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo_AtomicInteger {
    private final  static AtomicInteger process=new AtomicInteger(1);
    public Foo_AtomicInteger() {

    }


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        process.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(process.get()!=2){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        process.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(process.get()!=3){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
