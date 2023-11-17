package essay;

public class Stack_Basic {

    private int[] table;
    private int cursor;

    public Stack_Basic(int capacity) {
        this.cursor = -1;
        this.table = new int[capacity];
    }

    public void push(int val) {
        if (cursor == table.length - 1) {
            //resize
            // if size is 2^n, then can use left shift operation
            int newSize = table.length * 2;
            int[] newTable = new int[newSize];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        }
        cursor++;
        table[cursor] = val;
    }

    public int pop() {
        if (cursor >= 0) {
            return table[cursor--];
        } else {
            return -1;
        }
    }

    public int top() {
        if (cursor >= 0) {
            return table[cursor];
        } else {
            return -1;
        }
    }

    public boolean empty() {
        return cursor == -1;
    }

}
