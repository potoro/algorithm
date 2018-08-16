package bishi;
import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
  
   
public class Alibaba {
	
	 public static void main(String[] args) {  
	        try {  
	            InputStream is = new FileInputStream("file.txt");  
	            BufferedReader reader = new BufferedReader(  
	                    new InputStreamReader(is));  
	            String str = null;  
	            while (true) {  
	                str = reader.readLine();  
	                if(str!=null)  
	                    System.out.println(str);  
	                else  
	                    break;  
	            }  
	              
	            is.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	
}
