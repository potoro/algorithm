package sum;
import java.util.*;
public class SumOfSquence {
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList <ArrayList<Integer> > list = new ArrayList<>();
       if(sum < 3){
         /*  ArrayList subList = new ArrayList();
           subList.add(sum);
           list.add(subList);*/
           return list;
       }
       ArrayList subList = new ArrayList();
       int left = 1;
       int right =2;
       int mid = sum/2;
       int total = 3;
       while(left <= mid){
    	   
    	   if(total==sum){
        	   subList = new ArrayList();
               for(int i = left; i <= right; i++){
                  subList.add(i);
               }
               list.add(subList);
               right++;//这一步只在有匹配的后面完成
               total += right;
           }
    	   
    	   while(total!=sum && total > sum){
               total -=left;
               left++;
           }

           while(total!=sum && total < sum){
               right++;
               total += right;
           }

       }
       return list;
    }
    
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ArrayList <ArrayList<Integer> > list = FindContinuousSequence(9);
    	ArrayList <ArrayList<Integer> > list2 = list; 
    	
	}

}
