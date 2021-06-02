package sort;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LargeQuantitiesSort {

    public static final String FILE = ClassLoader.getSystemResource("").getFile();
    public static final int FILE_NUMS = 30;

    private Map<Integer,FileOutputStream> fileMap = new HashMap<>();


    public void largeQuantitiesSort() throws  Exception {
        // 1.随机生成几千万的数据写入到文件中
        // 2.读取该文件中的每一个数，对每一个数进行取模，根据取模信息写入到对应的子文件夹中
        // 3.排序：
        //     a.遍历每一个子文件夹，将每个子文件夹使用快排、归并的方法进行排序
        //     b.使用堆，将子文件夹中的排好序的数据，写入到最终的文件

        File file=new File( FILE +"work");
//        if(!file.exists())
//            file.createNewFile();
//        createRandomTextFile(file);
        //splitFileByMod(file);
        sortChildrenFile();
    }

    private void sortChildrenFile() throws Exception {
        File file=new File(FILE+"temp");
        for (File item : file.listFiles()) {
            sortNumsInFile(item);
        }
    }

    private void sortNumsInFile(File item) throws  Exception {
        FileInputStream input=new FileInputStream(item);
        byte[] buffer =new byte[1024];
        StringBuilder str=new StringBuilder();
        while(input.read(buffer)!=-1){
            str.append(new String(buffer,Charset.forName("utf-8")));
        }
        String[] s = str.toString().trim().split(" ");
        //int[] ints = Arrays.stream(s).parallel().filter(x-> !x.equals("")).mapToInt(Integer::valueOf).sorted().toArray();
        doSortNnums(s);
    }

    private void doSortNnums(String[] nums) {

    }

    private void splitFileByMod(File file) throws Exception {
        FileInputStream input=new FileInputStream(file);
        byte[] buffer=new byte[1024];
        while(input.read(buffer)!=-1){
            saveNumToChildrenFile(buffer);
        }
        for (Map.Entry<Integer, FileOutputStream> entry : fileMap.entrySet()) {
            entry.getValue().close();
        }
        input.close();
    }

    private void saveNumToChildrenFile(byte[] buffer) throws Exception {
        String s = new String(buffer, Charset.forName("utf-8"));
        String[] nums = s.trim().split(" ");
        for(String num:nums){
            if(num=="")
                continue;
            Integer integer = Integer.valueOf(num);
            int index= integer% FILE_NUMS;
            if(!fileMap.containsKey(index)){
                File file = new File(FILE + "temp/" + index + "_nums");
                if(!file.exists()){
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream output=new FileOutputStream(file);
                fileMap.put(index,output);
            }
            FileOutputStream fileOuputStream = fileMap.get(index);
            fileOuputStream.write((num+" ").getBytes(Charset.forName("utf-8")));
        }
    }

    private void createRandomTextFile(File file) throws Exception {
        FileOutputStream output=new FileOutputStream(file);
        Random random=new Random();
        for (int i = 0; i <100*1000; i++) {
            Integer j = random.nextInt(10000);
            output.write((j+" ").getBytes(Charset.forName("utf-8")));
        }
        output.close();
    }
}
