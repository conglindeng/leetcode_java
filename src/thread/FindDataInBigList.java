package thread;

import sun.net.www.protocol.file.FileURLConnection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class FindDataInBigList <T>{
    ArrayList<T> datas;

    private static int CoreSize=5;
    private static final ExecutorService executor=new ThreadPoolExecutor(CoreSize,CoreSize,3,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(50));

    public FindDataInBigList(ArrayList<T> datas) {
        this.datas = datas;
    }
    public int findData(T data) throws Exception{
        int length=datas.size();
        int group=length/CoreSize;
        int remainder=length%CoreSize;
        List<FutureTask<Integer>> futureTasks=new ArrayList<>();


        for(int i=1;i<=CoreSize;i++){
            futureTasks.add(doFindData(data,datas,(i-1)*group,i*group-1));
        }
        if(remainder!=0){
            futureTasks.add(doFindData(data,datas,CoreSize*group,length));
        }

        return getIndexFromfuture(futureTasks);
    }

    private int getIndexFromfuture(List<FutureTask<Integer>> futureTasks) throws Exception {
        int index=-1;
        retry:
        for(;;){
            if(futureTasks.size()==0){
                break;
            }
            Iterator<FutureTask<Integer>> iterator = futureTasks.iterator();
            while (iterator.hasNext()) {
                FutureTask<Integer> futureTask = iterator.next();
                if(futureTask.isDone()){
                    if(futureTask.get()!=-1){
                        index=futureTask.get();
                        break retry;
                    }
                    iterator.remove();
                }
            }
        }
        executor.shutdownNow();
        return index;
    }


    private FutureTask<Integer> doFindData(T data, List<T> collection, int begin, int end) {
        return (FutureTask<Integer>) executor.submit(() -> {
            int index = -1;
            for(int i=begin;i<=end;i++){
                if(collection.get(i).equals(data)){
                    index=i;
                    break;
                }
            }
            return index;
        });
    }
}
