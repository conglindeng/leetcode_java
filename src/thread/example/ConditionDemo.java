package thread.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition addCondition=lock.newCondition();
    private final Condition subCondition=lock.newCondition();

    private volatile int count=0;


    public  void add(){

        lock.lock();
        try {
            if (count >= 10) {
                addCondition.await();
            }
            count++;
            System.out.println(" add op : "+count);
            subCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sub(){
        lock.lock();
        try {
            if (count == 0) {
                subCondition.await();
            }
            count--;
            System.out.println(" sub op : "+count);
            addCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ConditionDemo demo=new ConditionDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                demo.add();
            },"add_"+i).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                demo.sub();
            },"sub_"+i).start();
        }
    }
}
