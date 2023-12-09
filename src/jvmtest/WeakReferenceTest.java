package jvmtest;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        // -127~128 ,when use type packaging, the reference always exists, because the cache in java.lang.Integer keep this reference
        WeakReference<Integer> age = new WeakReference<>(128);
        System.out.println(age.get());
        System.gc();
        Thread.sleep(1000L);
        System.out.println(age.get());



        // create Object by use new grammar, then set to weak reference, and next set the Object reference to null,
        // finally there only weak reference pointing to the object,so the gc can reclaim it,
        Integer integer = new Integer(5555);
        WeakReference<Integer> age2 = new WeakReference<>(integer);
        System.out.println(age2.get());
        System.out.println(integer);
        integer = null;
        System.gc();
        Thread.sleep(1000L);
        System.out.println(integer);
        System.out.println(age2.get());

    }
}
