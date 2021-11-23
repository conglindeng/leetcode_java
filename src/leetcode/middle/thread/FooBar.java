package leetcode.middle.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {

    private final Semaphore fooLock=new Semaphore(1);

    private final Semaphore barLock=new Semaphore(0);


    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooLock.acquire(1);
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        	barLock.release(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barLock.acquire(1);
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        	fooLock.release(1);
        }
    }
}