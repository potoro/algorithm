package Array;
import java.util.*;
class Length{
    public void Main(){
        Scanner sc = new Scanner(System.in); 
        int geshu = sc.nextInt();
        for(int i=0; i < geshu; i++){
            int number = sc.nextInt();
            System.out.println(num(number));
        }
    }
    
    public static int num(int n){
        if(n<=9) return n;
        int count=0;
        int temp=n;
        while(temp>0){
           temp=temp/10;
           count++;
        }
        int last = n-(int)Math.pow(10, count-1)+1;
        int lastNum = last*count;
        int first = 0;
        for(int i=1; i<count;i++){
            first += 9*(int)Math.pow(10, i-1);
        }
        return lastNum+first;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(num(13));
	}
}
