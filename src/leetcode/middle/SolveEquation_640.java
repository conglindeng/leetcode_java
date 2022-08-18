package leetcode.middle;

public class SolveEquation_640 {

    //分别找到左右的x系数和常数
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] coefficientAndInt1 = getCoefficientAndInt(split[0]);
        int[] coefficientAndInt2 = getCoefficientAndInt(split[1]);
        int num1=coefficientAndInt1[0]-coefficientAndInt2[0];
        int num2=coefficientAndInt2[1]-coefficientAndInt1[1];
        if(num1==0){
            if(num2==0){
                return "Infinite solutions";
            }else{
                return "No solution";
            }
        }
        if(num2%num1!=0){
            return "No solution";
        }
        return "x="+(num2/num1);
    }

    private int[] getCoefficientAndInt(String expression) {
        int coe = 0, num = 0;
        int i = 0;

        boolean isNagative = false;
        while (i < expression.length()) {
            // + - x num
            char c = expression.charAt(i);
            if (c == '-') {
                isNagative = true;
            } else if (c == '+') {
                isNagative = false;
            } else if (c == 'x') {
                coe += isNagative ? -1 : 1;
            } else {
                //数字
                int m = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    m = m * 10 + expression.charAt(i) - '0';
                    i++;
                }
                int flag = isNagative ? -1 : 1;
                if (i < expression.length() && expression.charAt(i) == 'x') {
                    coe += flag * m;
                    ++i;
                } else {
                    num += flag * m;
                }
                continue;
            }
            i++;
        }

        return new int[]{coe, num};
    }


}
