package singleton;

public class InnerClass {

    private InnerClass() {

    }

    public static InnerClass getInstance() {
        return InstanceProvider.instance;
    }

    //public or private ???
    private static class InstanceProvider {

        private static final InnerClass instance = new InnerClass();
    }
}
