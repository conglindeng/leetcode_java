package limiting;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import limiting.model.Request;

public class SlidingWindow implements RequestLimit {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
    private Long windowSize;

    private Integer limit;

    private Map<String, LinkedList<Instant>> arrivedTimeMap;

    public SlidingWindow(Long windowSize, Integer limit) {
        this.windowSize = -windowSize;
        this.limit = limit;
        this.arrivedTimeMap = new HashMap<>();
    }

    @Override
    public synchronized boolean requestLimit(Request request) {
        String IP = request.getIP();
        Instant arrivedTime = Instant.now();
        clearAncientRequest(IP, arrivedTime);
        //addLast
        LinkedList<Instant> orDefault = arrivedTimeMap.getOrDefault(IP, new LinkedList<>());
        boolean canAccess;
        if (orDefault.size() >= limit) {
            canAccess = false;
        } else {
            orDefault.addLast(arrivedTime);
            arrivedTimeMap.put(IP, orDefault);
            canAccess = true;
        }
        String dateStr = simpleDateFormat.format(Date.from(arrivedTime));
        System.out.println(" arrived time : " + dateStr + " canAccess: " + canAccess);
        return canAccess;
    }

    private void clearAncientRequest(String IP, Instant arrivedTime) {
        LinkedList<Instant> instants = arrivedTimeMap.get(IP);
        if (instants == null || instants.size() == 0) {
            return;
        }
        Instant line = arrivedTime.plusMillis(windowSize);
        while (instants.size() > 0 && line.isAfter(instants.peekFirst())) {
            instants.pollFirst();
        }
    }


}
