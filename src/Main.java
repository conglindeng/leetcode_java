import leetcode.middle.CompareVersion_165;

import java.util.UUID;


public class Main {


    public static void main(String[] args) throws Exception {

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));

        // todo: begin
        //new NC10_Solve().solve("733064366","459309139");
        //new NC126_MinMoney().minMoney(new int[]{2, 3, 5}, 20);
        // new NC110_Solve().solve(6, 5, new int[]{1, 2, 3, 4, 5, 6});
        // todo: end

        new CompareVersion_165().compareVersion("1.001", "1.01.0.1");

        System.out.println();
    }


}
