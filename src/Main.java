import skiplist.SkipList;

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

        SkipList skipList = new SkipList();
        skipList.insert(1, 1);
        skipList.insert(3, 3);
        skipList.insert(7, 7);
        skipList.insert(10, 10);
        skipList.insert(42, 42);
        skipList.printList();
        System.out.println("------------");
        skipList.delete(7);
        skipList.printList();
        System.out.println("------------");
        skipList.delete(10);
        skipList.printList();

        System.out.println("------------");
        skipList.delete(3);
        skipList.printList();

        System.out.println("------------");
        skipList.insert(3, 3);
        skipList.printList();

        System.out.println("------------");
        skipList.insert(7, 7);
        skipList.printList();

        System.out.println();
    }


}
