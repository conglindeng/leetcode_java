package algorithm;

public class ArraySort {
    public static void buddleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int min=i;
            for (int j = i+1; j < length; j++) {
                if(array[j]<array[min])
                    min=j;
            }
            if(min!=i){
                int temp=array[min];
                array[min]=array[i];
                array[i]=temp;
            }
        }
    }


    public static void insertSort(int[] array){
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int cur=array[i];
            int position=i;
            while(position>0&&array[position-1]>cur){
                array[position]=array[position-1];
                position--;
            }
            array[position]=cur;
        }
    }


    // todo：归并排序
    public static void mergeSort(int[] array){

    }



    public static void shellSort(int[] array){
        int n=array.length;
        for( int step=n/2;step>0;step=step/2){
            for(int i=step;i<n;i++){
                //对每一个数进行插入排序
                for(int m=i-step;m>=0;m-=step){
                    if(array[m]>array[m+step]){
                        int temp=array[m];
                        array[m]=array[m+step];
                        array[m+step]=temp;
                    }
                }
            }

        }
    }




}
