package leetcode.easy;

public class DuplicateZeros_1089 {

    public void duplicateZeros(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == 0 && index < arr.length - 1) {
                for (int i = arr.length - 1; i > index; --i) {
                    arr[i] = arr[i - 1];
                }
                arr[index++] = 0;
                index++;
            } else {
                ++index;
            }
        }
    }

    public void duplicateZeros_Optimize(int[] arr) {
//前缀0的个数，pre[]，对于index的数，重写后的index为index+pre[index] 如果此值大于length，则推出循环
        int[] pre = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            pre[i + 1] = pre[i] + (arr[i] == 0 ? 1 : 0);
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            int index = pre[j] + j;
            if (index <= arr.length - 1) {
                arr[index] = arr[j];
                if (arr[j] == 0 && index + 1 < arr.length) {
                    arr[index + 1] = 0;
                }
            }
        }
    }

    public void duplicateZeros_OptimizeWithStack(int[] arr) {
        int top = 0, index = 0;
        int l = arr.length;
        while (true) {
            if (arr[index] == 0) {
                top += 2;
            } else {
                top += 1;
            }
            if (top >= l) {
                break;
            }
            ++index;
        }
        //这个减1，看起来有点奇怪
        top -= 1;
        while (index >= 0) {
            if (arr[index] == 0) {
                if (top < l) {
                    arr[top] = 0;
                }
                arr[top - 1] = 0;
                top -= 2;
            } else {
                arr[top] = arr[index];
                top -= 1;
            }
            index--;
        }
        int a = 0;
    }

}
