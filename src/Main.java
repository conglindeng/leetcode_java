import leetcode.easy.ContainsNearbyDuplicate_219;
import leetcode.middle.*;
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

        char[][] nums = new char[][]{{'0', '1', '1'}, {'0', '1', '1'}, {'1', '1', '0'}};
        new MaximalSquare_221().maximalSquare(nums);

        System.out.println();
    }


}
