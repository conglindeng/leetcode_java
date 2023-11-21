package thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//todo:dcl
public class MyLock extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }


    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }
}
