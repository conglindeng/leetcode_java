package leetcode.middle;

import java.util.Arrays;

public class ValidSquare_593 {


    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2) || Arrays.equals(p2, p3) || Arrays.equals(p4, p3) || Arrays.equals(p1, p4)) {
            return false;
        }

        //正方形的性质？

        //1。找到四个定点的顺时针或者逆时针顺序
        //2。计算四个向量
        //3。计算向量的向量积是否相等
        //4。计算向量的长度是否相等

        return doJudge(p1, p2, p3, p4) || doJudge(p1, p2, p3, p4) || doJudge(p1, p3, p2, p4) || doJudge(p1, p3, p4,
            p2)
            || doJudge(p1, p4, p2, p3) || doJudge(p1, p4, p3, p2);

    }


    private boolean doJudge(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] vector1 = {p2[0] - p1[0], p2[1] - p1[1]};
        int[] vector2 = {p3[0] - p2[0], p3[1] - p2[1]};
        int[] vector3 = {p4[0] - p3[0], p4[1] - p3[1]};
        int[] vector4 = {p4[0] - p1[0], p4[1] - p1[1]};
        boolean b =
            isVertical(vector1, vector2) && isVertical(vector2, vector3) && isVertical(vector3, vector4) && isVertical(
                vector4, vector1);
        boolean equal =
            getVectorLength(vector1) == getVectorLength(vector2) && getVectorLength(vector3) == getVectorLength(vector2)
                && getVectorLength(vector3) == getVectorLength(vector4) && getVectorLength(vector1) == getVectorLength(
                vector4);
        return b && equal;
    }

    private boolean isVertical(int[] vector1, int[] vector2) {
        return (vector1[0] * vector2[0] + vector1[1] * vector2[1]) == 0;
    }

    private int getVectorLength(int[] vector) {
        return (int) Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);
    }

}
