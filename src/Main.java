import leetcode.middle.KSmallestPairs_373;
import newcode.NC110_Solve;
import newcode.NC126_MinMoney;
import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Main {


    public static void main(String[] args) throws Exception {

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));

        // todo: begin
        //new NC10_Solve().solve("733064366","459309139");
        new NC126_MinMoney().minMoney(new int[]{2, 3, 5}, 20);
        new NC110_Solve().solve(6, 5, new int[]{1, 2, 3, 4, 5, 6});
        // todo: end

        new KSmallestPairs_373().kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);


        System.out.println();
    }


}
