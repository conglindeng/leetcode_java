package freature;



public class MethodReload {
    abstract class Parent {

    }

    class Child1 extends Parent {

    }

    class Child2 extends Parent {

    }

    private void sayHello(Parent parent){
        System.out.println("hello,parent");
    }

    private void sayHello(Child1 child1){
        System.out.println("hello,Child1");
    }

    private void sayHello(Child2 child2){
        System.out.println("hello,Child2");
    }

    public void test(){
        Parent child1=new Child1();
        Parent child2=new Child2();
        sayHello(child1);
        sayHello(child2);
    }

}
