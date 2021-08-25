package newcode;

public class NC56_IsPalindrome {
    /**
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome(int x) {
        // write code here
        if(x<0){
            return false;
        }
        int m = x;
        int div = 1;
        while (m / div >= 10) {
            div *= 10;
        }
        m = x;
        while (m != 0) {
            int right = x % 10;
            int left = m / div;
            if (right != left) {
                return false;
            }
            x = x / 10;
            m = m % div;
            div = div / 10;
        }
        return true;
    }
}
