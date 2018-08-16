package bishi;
import java.util.Scanner;
import java.io.*;
public class Toutiao {
    public static void main(String[] args) throws IOException {
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//从系统输入中读取数据
        int commentLine = 0;
        String readline;
        boolean comment = false;
        readline = sin.readLine();
        while(readline!=null){
            readline = readline.trim();
            if((readline.startsWith("/*"))&&!readline.endsWith("*/")){
                commentLine++;
				comment = true;
            }else if((readline.startsWith("/*"))&&readline.endsWith("*/")){
                commentLine++;
            }else if(readline.endsWith("*/")){
                commentLine++;
				comment = false;
            }else if(true==comment){
				commentLine++;
            }else if(readline.startsWith("//")){
				commentLine++;
            }
        }
        System.out.println(commentLine);
    }
}