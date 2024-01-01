package competition.day23_12_31;

public class hasTrailingZeros_100166 {
    public boolean hasTrailingZeros(int[] nums) {
        boolean hasEven=false;
        for (int num : nums) {
            if((num&1)==0){
                if(hasEven){
                    return true;
                }
                hasEven=true;
            }
        }
        return false;
    }
}
