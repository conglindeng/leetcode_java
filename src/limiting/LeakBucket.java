package limiting;

import java.util.concurrent.LinkedBlockingDeque;
import limiting.model.Request;

//漏桶算法
//将请求放到一个固定容量的池子里面，另一个线程再按照恒定速率去取对应任务处理
//感觉实际中很少使用这个吧
//异步了请求的判断和请求的处理，
//当漏水即拿到一个请求进行处理时，请求结果如何和入口关联，又涉及到了线程池的相关设计、任务的等待和任务数据的关联
public class LeakBucket implements RequestLimit {

    private final LinkedBlockingDeque<Request> requests;

    private final Long rate;

    public LeakBucket(Integer capacity, Long rate) {
        this.requests = new LinkedBlockingDeque<>(capacity);
        this.rate = rate;
        new Thread(this::leak, "LeakBucket").start();
    }

    @Override
    public boolean requestLimit(Request request) {
        return requests.offer(request);
    }

    //can use @Scheduled annotation
    private void leak() {
        //一个线程风险太大，多个线程同时漏水  如何处理
        while (true) {

            Request request = requests.pollFirst();
            if (request != null) {
                //handle request
            }
            //exception ???
            //wait rate time
            try {
                Thread.sleep(rate);
            } catch (InterruptedException e) {
                // do something to continue handle request, such as create another thread to keep work
                throw new RuntimeException(e);
            }

        }
    }

/*
todo:dcl study it

long timeStamp = getNowTime();
int capacity = 10000;// 桶的容量
int rate = 1;//水漏出的速度
int water = 100;//当前水量

    public static bool control() {
        //先执行漏水，因为rate是固定的，所以可以认为“时间间隔*rate”即为漏出的水量
        long  now = getNowTime();
        water = Math.max(0, water - (now - timeStamp) * rate);
        timeStamp = now;

        if (water < capacity) { // 水还未满，加水
            water ++;
            return true;
        } else {
            return false;//水满，拒绝加水
        }
    }
*/
}
