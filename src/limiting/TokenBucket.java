package limiting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import limiting.model.Request;

public class TokenBucket implements RequestLimit {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
    private final Integer capacity;

    private final AtomicInteger size;

    private volatile Long rate;

    public TokenBucket(Integer capacity, Long rate) {
        this.capacity = capacity;
        this.size = new AtomicInteger(0);
        this.rate = rate;
        System.out.println(" start time : " + simpleDateFormat.format(new Date()));
        new Thread(this::generateToken, "Generate Token").start();
    }

    @Override
    public boolean requestLimit(Request request) {
        int i = size.get();
        boolean canAccess = false;
        if (i > 0) {
            canAccess = size.compareAndSet(i, i - 1);
        }
        String dateStr = simpleDateFormat.format(new Date());
        System.out.println(" arrived time : " + dateStr + " canAccess: " + canAccess);

        return canAccess;
    }

    private void generateToken() {
        // long start = new Date().getTime();
        // while(new Date().getTime() - start < 1000L){}
        // maybe use the top way to wait a fixed interval
        while (true) {
            int i = size.get();
            if (i < capacity) {
                size.incrementAndGet();
            }
            try {
                Thread.sleep(rate);
            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
        }
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }



    /*
    todo:dcl study it

long timeStamp=getNowTime();
int capacity; // 桶的容量
int rate ;//令牌放入速度
 int tokens;//当前水量

bool control() {
   //先执行添加令牌的操作
   long  now = getNowTime();
   tokens = max(capacity, tokens+ (now - timeStamp)*rate);
   timeStamp = now;   //令牌已用完，拒绝访问

   if(tokens<1){
     return false;
   }else{//还有令牌，领取令牌
     tokens--;
     retun true;
   }
 }
     */
}
