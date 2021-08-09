package thread;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceQueue {
    private final Random random = new Random();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition enmty=lock.newCondition();
    private final Condition full=lock.newCondition();

    private volatile Queue<Integer> values = new LinkedList<>();
    private volatile int size = 0;
    private volatile int maxSize = 8;

    public void produce() {
        lock.lock();
        try {
            while(size==maxSize) {
                System.out.println(Thread.currentThread().getName()+" producer return ");
                return;
                //enmty.wait();
            }
            System.out.println(Thread.currentThread().getName()+" producer work");
            int value = random.nextInt(100);
            values.offer(value);
            size++;
            System.out.println(Thread.currentThread().getName()+" produce " + value +" and cur size = "+size);
            lock.notifyAll();
            // full.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public int consumer(){
        lock.lock();
        int result=-1;
        try{
            while(size==0){
                System.out.println(Thread.currentThread().getName()+" consumer waiting");
                lock.wait();
            }
            System.out.println(Thread.currentThread().getName()+" consumer work");
            result=values.poll();
            size--;
            System.out.println(Thread.currentThread().getName()+" consumer " + result  +" and cur size = "+size);
            lock.notifyAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return result;
    }
}
