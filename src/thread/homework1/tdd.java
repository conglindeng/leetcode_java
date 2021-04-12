
/*

package com.eleven;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class 线程先后输出 {
    static final Object lock = new Object();
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();
    CountDownLatch latch = new CountDownLatch(1);
    CyclicBarrier barrier = new CyclicBarrier(2);
    Phaser phaser = new Phaser(2);
    BlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(1);
    PipedInputStream in = new PipedInputStream();
    PipedOutputStream out = new PipedOutputStream();
    Exchanger<Integer> exchanger = new Exchanger<>();
    volatile boolean flag = false;
    @Test
    public void test1() throws Exception{
        Thread mainThread = Thread.currentThread();
        new Thread(()->{
            System.out.println("A");
            LockSupport.unpark(mainThread);
        }).start();
        LockSupport.park();
        System.out.println("B");
    }
    @Test
    public void test2() throws Exception{
        new Thread(()->{
            reentrantLock.lock();
            System.out.println("A");
            condition.signal();
            reentrantLock.unlock();
        }).start();
        reentrantLock.lock();
        condition.await();
        System.out.println("B");
        reentrantLock.unlock();
    }
    @Test
    public void test3() throws Exception{
        new Thread(()->{
            System.out.println("A");
            latch.countDown();
        }).start();
        latch.await();
        System.out.println("B");
    }
    @Test
    public void tes4() throws Exception{
        new Thread(()->{
            System.out.println("A");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        barrier.await();
        System.out.println("B");
    }
    @Test
    public void test5() throws Exception{
        new Thread(()->{
            System.out.println("A");
            phaser.arriveAndAwaitAdvance();
        }).start();
        phaser.arriveAndAwaitAdvance();
        System.out.println("B");
    }
    @Test
    public void test6() throws Exception{
        new Thread(()->{
            System.out.println("A");
            blockingDeque.offer(1);
        }).start();
        blockingDeque.take();
        System.out.println("B");
    }
    @Test
    public void test7() throws Exception{
        in.connect(out);
        new Thread(()->{
            System.out.println("A");
            try {
                out.write("A".getBytes());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }).start();
        in.read();
        System.out.println("B");
    }
    @Test
    public void test8() throws Exception{
        new Thread(()->{
            System.out.println("A");
            try {
                exchanger.exchange(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        exchanger.exchange(2);
        System.out.println("B");
    }
    @Test
    public void test9() throws Exception{
        new Thread(()->{
            synchronized (lock){
                System.out.println("A");
                lock.notify();
            }
        }).start();
        synchronized (lock){
            lock.wait();
            System.out.println("B");
        }
    }
    @Test
    public void test10() throws Exception{
        new Thread(()->{
            System.out.println("A");
            flag = true;
        }).start();
        while (!flag){

        }
        System.out.println("B");
    }
}
*/