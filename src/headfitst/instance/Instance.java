package headfitst.instance;

public class Instance {
    private Instance(){
    }

    //region innner static class
    public static Instance getInstance(){
        return innerInstance.instance;
    }

    private static class innerInstance{
        private static final Instance instance=new  Instance();
    }
    //endregion de

    //region DCL
    private static volatile Instance instance;

    public static Instance getLazyLoadInstance(){
        if(instance==null){
            synchronized (Instance.class){
                if(instance==null){
                    instance=new Instance();
                }
            }
        }
        return instance;
    }
    //endregion

    //region Hungry Way
    private static volatile Instance instance2=new Instance();

    public static Instance getInstance2(){
        return instance2;
    }
    //endregion

}
