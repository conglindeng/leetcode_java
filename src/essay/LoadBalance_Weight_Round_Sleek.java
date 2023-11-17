package essay;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class LoadBalance_Weight_Round_Sleek {

    private static final Object lock = new Object();

    private volatile List<LoadBalanceNode> work;
    private int weightSum;

    public LoadBalance_Weight_Round_Sleek(Pair<String, Integer>[] configs) {
        work = new ArrayList<>();
        weightSum = 0;
        for (Pair<String, Integer> config : configs) {
            work.add(new LoadBalanceNode(config.getKey(), config.getValue(), config.getValue()));
            weightSum += config.getValue();
        }
    }

    public String direct() {
        synchronized (lock) {
            //find maximum weight
            int cusor = 0;
            int m = 1;
            while (m < work.size()) {
                if (work.get(m).getWeight() > work.get(cusor).getWeight()) {
                    cusor = m;
                }
                m++;
            }

            //update weight
            LoadBalanceNode matched = work.get(cusor);

            matched.setWeight(matched.getWeight() + matched.getInitialWeight() - weightSum);
            for (int j = 0; j < work.size(); j++) {
                if (cusor != j) {
                    LoadBalanceNode other = work.get(j);
                    other.setWeight(other.getWeight() + other.getInitialWeight());
                }
            }

            return matched.getIp();
        }
    }

    private static class LoadBalanceNode {

        String ip;
        volatile Integer weight;
        Integer initialWeight;

        public LoadBalanceNode(String ip, Integer weight, Integer initialWeight) {
            this.ip = ip;
            this.weight = weight;
            this.initialWeight = initialWeight;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getInitialWeight() {
            return initialWeight;
        }

        public void setInitialWeight(Integer initialWeight) {
            this.initialWeight = initialWeight;
        }
    }

}
