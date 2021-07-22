import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestUrl {
 
    public static void main(String[] args) {
 
        //testUrl("http://1.3.3.3/test");
        //最好使用下面这个，上面那个超时时间不定，所以可能会导致卡住的情况
        testUrlWithTimeOut("http://172.18.17.130:8031/laxt/", 2000);
    }
    
    public static void testUrl(String urlString){
        
        long lo = System.currentTimeMillis();
        URL url;
        try {  
             url = new URL(urlString);  
             InputStream in = url.openStream();
             System.out.println("连接可用");  
        } catch (Exception e1) {  
             System.out.println("连接打不开!");  
             url = null;  
        }  
        
        System.out.println(System.currentTimeMillis()-lo);
    }
    
    public static void testUrlWithTimeOut(String urlString,int timeOutMillSeconds){
        long lo = System.currentTimeMillis();
        URL url;  
        try {  
             url = new URL(urlString);  
             URLConnection co =  url.openConnection();
             co.setConnectTimeout(timeOutMillSeconds);
             co.connect();
             System.out.println("连接可用");  
        } catch (Exception e1) {  
             System.out.println("连接打不开!");  
             url = null;  
        }  
        System.out.println(System.currentTimeMillis()-lo);
    }
}