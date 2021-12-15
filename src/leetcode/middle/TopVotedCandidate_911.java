package leetcode.middle;

import java.util.*;

public class TopVotedCandidate_911 {

    List<Integer> tops;
    int[] times;
    Map<Integer, Integer> voteCount;

    public TopVotedCandidate_911(int[] persons, int[] times) {
        tops = new ArrayList<>();
        this.times = times;
        voteCount = new HashMap<>();
        voteCount.put(-1, -1);
        int top = -1;
        for (int i = 0; i < times.length; i++) {
            int person = persons[i];
            voteCount.put(person, voteCount.getOrDefault(person, 0) + 1);
            if (voteCount.get(person) >= voteCount.get(top)) {
                top = person;
            }
            tops.add(top);
        }
    }

    public int q(int t) {
        int left = 0, right = times.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (times[mid] > t) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return tops.get(left);
    }

}