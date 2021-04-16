import leetcode.middle.*;

import java.util.UUID;

public class Main {
    static long[][] arr;
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(XorQueries_1310.xorQueries_optimize(new int[]{1,3,4,8},new int[][]{{0,1},{1,2},{0,3},{3,3}}));
    }
}
