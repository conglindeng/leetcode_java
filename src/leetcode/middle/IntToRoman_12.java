package leetcode.middle;

public class IntToRoman_12 {

    /**
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: num = 3
     * 输出: "III"
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder result=new StringBuilder();
        Roman[] values = Roman.values();
        while(num!=0){
            for (int i = 1; i < values.length; i++) {
                if(values[i].value>num){
                    result.append(values[i-1].label);
                    num-=values[i-1].value;
                    break;
                }
                if(i== values.length-1){
                    result.append(values[i].label);
                    num-=values[i].value;
                    break;
                }
            }
        }
        return result.toString();
    }
    public String intToRoman_optimize(int num) {
        StringBuilder result=new StringBuilder();
        Roman[] romans = Roman.values();
        for(int i=romans.length-1;i>=0;i--){
            Roman roman = romans[i];
            while(num>=roman.value){
                result.append(roman.label);
                num-=roman.value;
            }
            if(num==0){
                break;
            }
        }
        return result.toString();
    }

    private enum Roman {

        /**
         * 字符          数值
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */
        I(1, "I"),
        IV(4, "IV"),
        V(5, "V"),
        IX(9, "IX"),
        X(10, "X"),
        XL(40, "XL"),
        L(50, "L"),
        XC(90, "XC"),
        C(100, "C"),
        CD(400, "CD"),
        D(500, "D"),
        CM(900, "CM"),
        M(1000, "M");


        Roman(int value, String label) {
            this.value = value;
            this.label = label;
        }

        private int value;
        private String label;

        public boolean compare(int value){
            return value-this.value>=0;
        }

    }


}
