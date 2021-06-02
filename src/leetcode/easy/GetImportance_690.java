package leetcode.easy;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetImportance_690 {
    public static int getImportance(List<Employee> employees,int id){
        Map<Integer, Employee> collect = employees.stream().collect(Collectors.toMap(x -> x.id, Function.identity()));
        Stack<Employee> work=new Stack<>();
        Employee cur=collect.get(id);
        int result=0;
        while(cur!=null||!work.isEmpty()){
            if(cur!=null){
                result+=cur.importance;
                if (cur.subordinates != null)
                    cur.subordinates.stream().forEach(x -> {
                        if (collect.get(x) != null)
                            work.push(collect.get(x));
                });
                cur=null;
            }
            if(!work.isEmpty()){
                cur=work.pop();
            }
        }
        return result;
    }
    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}


