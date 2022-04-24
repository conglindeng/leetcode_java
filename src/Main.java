import leetcode.easy.ReverseBits_190;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {

    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 20, 2, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(3), r -> new Thread(r, "myPool")
    );

    public static void main(String[] args) throws Exception {

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));

        // todo: begin
        //new NC10_Solve().solve("733064366","459309139");
        //new NC126_MinMoney().minMoney(new int[]{2, 3, 5}, 20);
        // new NC110_Solve().solve(6, 5, new int[]{1, 2, 3, 4, 5, 6});
        // todo: end
        new MinimumLengthEncoding_820().minimumLengthEncoding_Optimize(new String[]{"time", "me", "bell"});
        System.out.println();
    }
}
