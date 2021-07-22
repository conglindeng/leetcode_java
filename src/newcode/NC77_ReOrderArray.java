package newcode;


public class NC77_ReOrderArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray(int[] array) {
        // write code here
        if (array == null || array.length < 3) {
            return array;
        }
        int evenIndex = -1;
        for (int i = 0; i < array.length; i++) {
            //第一个偶数
            int cur = array[i];
            if (cur % 2 == 0) {
                if (evenIndex == -1) {
                    evenIndex = i;
                }
            } else {
                evenIndex = remove(evenIndex, array, i);
            }
        }
        return array;
    }

    private int remove(int evenIndex, int[] array, int index) {
        //若还没找到一个偶数，则不用移动
        if (evenIndex == -1) {
            return evenIndex;
        }
        int temp = array[index];
        for (int i = index; i > evenIndex; i--) {
            array[i] = array[i - 1];
        }
        array[evenIndex] = temp;
        return evenIndex + 1;
    }
}
