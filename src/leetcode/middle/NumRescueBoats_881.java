package leetcode.middle;

import java.util.Arrays;

public class NumRescueBoats_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int result=0;
        while (left < right) {
            result++;
            if(people[left]+people[right]<=limit)
                left++;
            right--;
        }
        return result;
    }
}
