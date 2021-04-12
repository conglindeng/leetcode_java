package middle;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> data;
    int index=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        data=foreachData(nestedList);
    }

    @Override
    public Integer next() {
        return data.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < data.size() - 1;
    }


    private List<Integer> foreachData(List<NestedInteger> data) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger inte :
                data) {
            if (inte.isInteger()) {
                result.add(inte.getInteger());
            } else {
                result.addAll(foreachData(inte.getList()));
            }
        }
        return result;
    }
}

interface NestedInteger {

    public boolean isInteger();


    public Integer getInteger();


    public List<NestedInteger> getList();
}