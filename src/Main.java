import leetcode.easy.FindRestaurant_599;
import leetcode.middle.CountHighestScoreNodes_2049;

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
        int a = new CountHighestScoreNodes_2049().countHighestScoreNodes(new int[]{-1, 2, 0});


        new FindRestaurant_599().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{
                "KFC", "Shogun", "Burger King"});

        System.out.println();
    }


}
