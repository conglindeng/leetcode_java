package leetcode.difficult;

import java.util.Map;

public class Evaluate_736 {

    //作用域
    //对于每一个expr，没到操作的时候，前面的值应保存在容器中，并有对应关系


    public int evaluate(String expression) {
        return 1;
    }


    abstract static class Op {

        String operation;

        abstract int getVal();
    }


    static class BaseOp extends Op {

        Map<String, Integer> values;

        @Override
        int getVal() {
            String[] s = operation.split(" ");
            if ("add".equals(s[0])) {
                return values.get(s[1]) + values.get(s[2]);
            } else {
                return values.get(s[1]) * values.get(s[2]);
            }
        }
    }

    static class ExprOp extends Op {

        Map<String, Op> ops;

        @Override
        int getVal() {
            String[] s = operation.split(" ");
            if ("add".

                equals(s[0])) {
                return ops.get(s[1]).getVal() + ops.get(s[2]).getVal();
            } else {
                return ops.get(s[1]).getVal() * ops.get(s[2]).getVal();
            }
        }
    }

}
