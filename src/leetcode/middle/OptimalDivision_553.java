package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class OptimalDivision_553 {
    double res = Long.MIN_VALUE;
    String resStr = "";

    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        List<Double> list = new ArrayList<>(nums.length);
        List<String> strs = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add((double) nums[i]);
            strs.add(String.valueOf(nums[i]));
        }
        doDiv(list, strs);
        //删除不必要的括号
        return resStr;
    }

    private void doDiv(List<Double> list, List<String> strs) {
        if (list.size() == 2) {
            double v = list.get(0) * 1.0 / list.get(1);
            if (v > res) {
                resStr = strs.get(0) + "/" + strs.get(1);
                res = v;
                return;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            List<Double> copyList = new ArrayList<>(list);
            List<String> copyStrs = new ArrayList<>(strs);
            double first = copyList.get(i - 1);
            double second = copyList.get(i);
            double v = first / second;
            copyList.set(i - 1, v);
            copyStrs.set(i - 1, hanldeBracket(copyStrs.get(i - 1), copyStrs.get(i)));
            copyList.remove(i);
            copyStrs.remove(i);
            doDiv(copyList, copyStrs);
        }
    }

    private String hanldeBracket(String first, String second) {
        if (first.startsWith("(")) {
            return "(" + first.substring(1, first.length() - 1) + "/" + second + ")";
        } else {
            return "(" + first + "/" + second + ")";
        }
    }

    public String optimalDivision_Optimize(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder res = new StringBuilder();
        res.append(nums[0]);
        res.append('/');
        res.append('(');
        for (int i = 1; i < nums.length; i++) {
            res.append(nums[i]);
            if (i != nums.length - 1) {
                res.append('/');
            }
        }
        res.append(')');
        return res.toString();
    }

}
