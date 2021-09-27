package newcode;

public class NC29_Find {
    /**
     * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * 给定 target = 7，返回 true。
     * <p>
     * 给定 target = 3，返回 false。
     *
     * @return
     */
    public boolean Find(int target, int[][] array) {
        //从右上角往左下角找
        if (array == null || array.length == 0) {
            return false;
        }
        int right = array[0].length - 1, top = 0;
        while (top != array.length && right != -1) {
            int i = array[top][right];
            if (i == target) {
                return true;
            } else if (i > target) {
                right--;
            } else {
                top++;
            }
        }
        return false;
    }


}
