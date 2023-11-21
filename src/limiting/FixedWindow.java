package limiting;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FixedWindow implements RequestLimit {


    private static final Map<String, LimitWindow> requestCount = new HashMap<>();

    private static final Long startTime = new Date().getTime();

    private final Integer limit;

    private final Long windowInterval;


    public FixedWindow(Integer threshold, Long windowInterval, TimeUnit timeUnit) {
        this.limit = threshold;
        switch (timeUnit) {
            case MILLISECONDS:
                this.windowInterval = windowInterval;
                break;
            case SECONDS:
                this.windowInterval = windowInterval * 1000;
                break;
            case MINUTES:
                this.windowInterval = windowInterval * 1000 * 60;
                break;
            default:
                throw new RuntimeException(" unsupported TimeUnit ");
        }
    }

    // guaranteed by synchronized
    @Override
    public synchronized boolean requestLimit(String IP) {
        // how to reduce race ?
        // todo:dcl
        long windowIndex = getWindowIndex();
        LimitWindow curCount = requestCount.getOrDefault(IP, new LimitWindow(getWindowIndex(), 0));
        if (windowIndex < curCount.getWindowIndex()) {
            return false;
        }
        if (windowIndex > curCount.windowIndex) {
            curCount.setWindowIndex(windowIndex);
            curCount.setCount(0);
        }
        System.out.print(
            " IP: " + IP + " , current windowIndex : " + curCount.getWindowIndex() + " ,current count : "
                + curCount.getCount());
        boolean canAccess;
        if (curCount.count >= limit) {
            canAccess = false;
        } else {
            curCount.setCount(curCount.getCount() + 1);
            requestCount.put(IP, curCount);
            canAccess = true;
        }
        System.out.println(" canAccess: " + canAccess);
        return canAccess;
    }

    private long getWindowIndex() {
        // sub & div
        // maybe can do it by other way
        // todo:dcl
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        return currentTimeMillis / windowInterval;
    }

    static class LimitWindow {

        private Long windowIndex;
        private Integer count;

        public LimitWindow(Long windowIndex, Integer count) {
            this.windowIndex = windowIndex;
            this.count = count;
        }

        public Long getWindowIndex() {
            return windowIndex;
        }

        public void setWindowIndex(Long windowIndex) {
            this.windowIndex = windowIndex;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

}
