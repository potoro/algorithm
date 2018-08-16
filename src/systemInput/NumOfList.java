package systemInput;

public class NumOfList {
	public static int NumSong(int length, int aLen, int aNum, int bLen, int bNum){
		int count = 0;
		for(int i=0; i*aLen <= length && i<= aNum; i++){
			if((length- i*aLen)% bLen==0){
				int temp = (length- i*aLen)/bLen;
				if(temp<=bNum) count += ((int)C(aNum,i)*(int)C(bNum,temp));
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(C(10,0));
		int result= NumSong(5, 2, 4,3, 3);
		System.out.println(result);
		
	}
	
	
	 public static int A(int first , int second)  
	    {  
	        int tmp = first;  
	        int result = first;  
	        int count = 0;  
	        while(count < second-1)  
	        {  
	            if(second ==1)  
	            {  
	                return first;  
	            }  
	            else  
	            {  
	                count++;  
	                tmp--;  
	               // System.out.println(result + "*" + tmp);  
	                result = result * tmp;    
	            }  
	        }  
	        return result;  
	    }  
	 
	 public static int factorialA(int number)  
	    {  
	        return A(number,number);  
	    }  
	 
	 public static double C(int n, int r)  
	    {    
		 	if(r==0||n==r)  return 1;
	        return factorialA(n)/(factorialA(n-r)*factorialA(r));  
	    }  

}
