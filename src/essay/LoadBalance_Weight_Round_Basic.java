package essay;

import java.util.LinkedList;
import javafx.util.Pair;

public class LoadBalance_Weight_Round_Basic {

    private static final Object lock = new Object();
    private final Pair<String, Integer>[] initialData;

    private LinkedList<String> work;

    public LoadBalance_Weight_Round_Basic(Pair<String, Integer>[] configs) {
        initialData = configs;
        nextRound();
    }

    private void nextRound() {
        LinkedList<String> nextList = new LinkedList<>();
        for (Pair<String, Integer> config : initialData) {
            String key = config.getKey();
            Integer value = config.getValue();
            for (int i = 0; i < value; i++) {
                nextList.add(key);
            }
        }
        work = nextList;
    }

    public String direct() {
        synchronized (lock) {
            String direction = work.pollFirst();
            if (work.size() == 0) {
                nextRound();
            }
            return direction;
        }
    }
}
