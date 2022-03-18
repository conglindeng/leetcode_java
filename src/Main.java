import leetcode.middle.Bank_2043;

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
        Bank_2043 bank = new Bank_2043(new long[]{10, 100, 20, 50, 30});
        bank.withdraw(3, 10);
        bank.transfer(5, 1, 20);

        System.out.println();
    }


}
