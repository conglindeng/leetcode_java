package struct;

public class ArrayStack {
    private String[] elements;
    private int top;
    private int maxsize;

    public ArrayStack(int initsize) {
        elements=new String[initsize];
        maxsize=initsize;
        top=-1;
    }

    public String push(String element){
        if(top<maxsize){
            elements[++top]=element;
            return element;
        }
        return null;
    }

    public String pop(){
        if(top>=0){
            return elements[top--];
        }
        return null;
    }
}
