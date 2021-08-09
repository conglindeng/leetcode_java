package newcode;

public class NC101_Solve {

    /**
     * 从 0,1,2,...,n 这 n+1 个数中选择 n 个数，选择出的数字依然保持有序，找出这 n 个数中缺失的那个数，要求 O(n) 或 O(log(n)) 并尽可能小。
     *
     * @param a
     * @return
     */
    public int solve(int[] a) {
        // write code here
        int left = 0, right = a.length-1;
        if(a[a.length-1]==a.length-1){
            return a.length;
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (a[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return a[left]-1;

    }
}
