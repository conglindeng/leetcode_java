package singleton;

public class StaticInit {
    private static final StaticInit instance=new StaticInit();
    private StaticInit(){}

    public static StaticInit getInstance(){
        return instance;
    }

}
