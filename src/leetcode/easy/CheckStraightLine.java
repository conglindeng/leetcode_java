package leetcode.easy;

public class CheckStraightLine {
    public static boolean checkStraightLine(int[][] coordinates){
        int length=coordinates.length;
        if(length==0)
            return false;
        if(length<=2)
            return true;
        int k,b;
        if(coordinates[1][0]==coordinates[0][0]){
            k=1;
            b=-coordinates[1][0];
        }else{
             k=(coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
             b=coordinates[1][1]-k*coordinates[1][0];
        }
        for (int i = 2; i < length; i++) {
            int tempk,tempb;
            int x1=coordinates[i-1][0];
            int y1=coordinates[i-1][1];
            int x2=coordinates[i][0];
            int y2=coordinates[i][1];
            if(x1==x2){
                tempk=1;
                tempb=-x1;
            }else{
                tempk=(y1-y2)/(x1-x2);
                tempb=y1-tempk*x1;
            }
            if(tempk!=k || tempb!=b){
                return false;
            }

        }

        return true;
    }


    public static boolean checkStraightLine2(int[][] coordinates) {
        int length=coordinates.length;
        for (int i = 1; i < length-1; i++) {
            boolean oneLine=
                    (coordinates[i][1]-coordinates[0][1])*(coordinates[length-1][0]-coordinates[0][0])
                    !=(coordinates[i][0]-coordinates[0][0])*(coordinates[length-1][1]-coordinates[0][1]);
            if(oneLine)
                return false;
        }
        return true;

    }
        public static void main(String[] args) {
        System.out.println(checkStraightLine2(new int[][]{{1,2},{2,3},{3,4}}));
    }
}
