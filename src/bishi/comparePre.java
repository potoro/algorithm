package bishi;


import java.util.Scanner;

public class comparePre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String []preS = new String[m];
        for(int i = 0; i < m; i++){
            preS[i] = sc.nextLine();
        }
        for(int i = 0; i < n; i++){
            int result = -1;
            String toCompare = sc.nextLine();
            result = Compare(preS, toCompare);
            System.out.println(result);
        }
    }
    
    public static int Compare(String[]preS, String toCompare){
        int reslut = -1;
        for(int i = 0; i < preS.length; i++){
            char []c = preS[i].toCharArray();
            char [] toC = toCompare.toCharArray();
            if(c.length>toC.length){
                continue; //
            }
            int j=0;
            boolean exit = true;
            while(j<c.length){
                if(c[j]!=toC[j]){
                    exit = false;
                    break;
                }
                j++;
            }
            if(exit==true){
                return 1;
            }
        }
        return -1;
    }
}