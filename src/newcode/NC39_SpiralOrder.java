package newcode;

import java.util.ArrayList;
import java.util.List;

public class NC39_SpiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return new ArrayList<>();
        return doSpiralOrder(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    private ArrayList<Integer> doSpiralOrder(int[][] matrix, int left, int top, int right, int buttom) {
        ArrayList<Integer> res = new ArrayList<>();
        if (left > right || buttom < top) {
            return res;
        }
        if (left == right && top == right && top == buttom) {
            res.add(matrix[left][right]);
            return res;
        } else if (left == right) {
            for (int i = top; i <= buttom; i++) {
                res.add(matrix[i][left]);
            }
            return res;
        } else if (buttom == top) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[buttom][i]);
            }
            return res;
        }

        for (int i = left; i <= right; i++) {
            res.add(matrix[top][i]);
        }
        for (int i = top + 1; i <= buttom; i++) {
            res.add(matrix[i][right]);
        }
        for (int i = right - 1; i >= left; i--) {
            res.add(matrix[buttom][i]);
        }
        for (int i = buttom - 1; i > top; i--) {
            res.add(matrix[i][left]);
        }

        res.addAll(doSpiralOrder(matrix, left + 1, top + 1, right - 1, buttom - 1));
        return res;
    }

}
