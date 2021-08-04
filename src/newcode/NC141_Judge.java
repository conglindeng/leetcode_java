package newcode;

public class NC141_Judge {
    public boolean judge(String str) {
        // write code here
        if (str == null) {
            return false;
        }
        int length = str.length();
        int mid=length/2;
        for(int i=mid;i>=0;i--){
            if(str.charAt(i)!=str.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
}
