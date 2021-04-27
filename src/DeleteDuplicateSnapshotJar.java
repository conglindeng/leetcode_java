import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class DeleteDuplicateSnapshotJar {
    static String libPath = "G:\\git\\40_source\\80_数字法院\\np-fy-dwjk\\java\\target\\dwjk\\WEB-INF\\lib";
    // static String libPath = "D:\\workspace\\HYPROJ3\\40_source\\80_数字法院\\np-fy-ajcx\\java\\target\\ajcx\\WEB-INF\\lib";
    // static String libPath = "D:\\workspace\\HYPROJ2\\40_source\\80_数字法院\\np-fy-spxt\\java\\target\\laxt\\WEB-INF\\lib";
//    static String libPath = "D:\\workspace\\HYPROJ2\\40_source\\80_数字法院\\np-fy-xtgl\\java\\target\\xtgl\\WEB-INF\\lib";
    public static void main(String[] args) {
        deleteDuplicateSnapshotJar(libPath);
    }
    public static HashMap<String,Object> deleteDuplicateSnapshotJar(String libPath){
        File libDir = new File(libPath);
        HashMap<String,Object> result = new HashMap<String, Object>();
        if(!libDir.exists()){
            result.put("success",false);
            result.put("errorMsg","lib目录不存在");
            System.out.println("lib目录不存在");
        }
        else{
            File[] jars = libDir.listFiles();
            int deletedNum = 0;
            ArrayList<String> snapshots = new ArrayList<String>();
            for (File jar:jars){
                String fileName = jar.getName();
                if(fileName.endsWith("-SNAPSHOT.jar")){
                    snapshots.add(fileName);
                }
            }
            for (File jar:jars){
                for(String snapshot:snapshots){
                    boolean condition1 = jar.getName().startsWith(snapshot.substring(0,snapshot.length()-12)) && !jar.getName().endsWith(snapshot);
                    boolean condition2 = jar.getName().contains("-3.13-");
                    if(condition1 || condition2){
                        if(!jar.delete()){
                            System.out.println(jar.getName()+"-----失败");
                        }
                        else{
                            System.out.println(jar.getName()+"-----成功");
                        }
                        deletedNum++;
                        break;
                    }
                }
            }
            if(deletedNum == 0){
                System.out.println("没有重复的jar包");
            }
            result.put("deletedNum",deletedNum);
            result.put("success",true);
        }
        return result;
    }
}
