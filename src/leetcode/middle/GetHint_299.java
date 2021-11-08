package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class GetHint_299 {
    /**
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     * <p>
     * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
     * <p>
     * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
     * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
     * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
     * <p>
     * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
     * <p>
     * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
     * "1807"
     * |
     * "7810"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bulls-and-cows
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            return null;
        }
        List<Character> fistList = new ArrayList<>();
        List<Character> secondList = new ArrayList<>();
        int equalNum = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                equalNum++;
            } else {
                fistList.add(secret.charAt(i));
                secondList.add(guess.charAt(i));
            }
        }
        List<Character> intersectionsFromTwoList = getIntersectionsFromTwoList(fistList, secondList);
        return equalNum+"A"+intersectionsFromTwoList.size()+"B";

    }

    private List<Character> getIntersectionsFromTwoList(List<Character> fisrt, List<Character> second) {
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < fisrt.size(); i++) {
            int index = second.indexOf(fisrt.get(i));
            if (index != -1) {
                res.add(fisrt.get(i));
                second.remove(index);
            }
        }
        return res;
    }
}
