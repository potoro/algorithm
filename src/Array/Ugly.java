package Array;

public class Ugly {
	 public int GetUglyNumber_Solution(int index) {
	       if(index<1) return 0;
	        int []Ugly = new int[index];
	        Ugly[0]=1;
	        int indexNext = 1;//下一个存储的
	        int currentMaxUgly = 1;
	        int index2 = 0;
	        int index3 = 0;
	        int index5 = 0;
	        while(indexNext < index){//一直重复执行这个过程
	            currentMaxUgly = min(Ugly[index2]*2, Ugly[index3]*3, Ugly[index5]*5);
	            Ugly[indexNext] = currentMaxUgly;
	            System.out.println(currentMaxUgly);
	            indexNext++;
	            while(Ugly[index2]*2 <= currentMaxUgly) index2++;
	            while(Ugly[index3]*3<= currentMaxUgly) index3++;
	            while(Ugly[index5]*5<= currentMaxUgly) index5++;
	        }
	        return Ugly[index-1];
	    }
	    public static int min(int i1, int i2, int i3){
	        if(i1 <= i2 && i1 <= i3) return i1;
	        else if(i2 <= i1 && i2 <= i3) return i2;
	        else return i3;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ugly test = new Ugly();
		test.GetUglyNumber_Solution(15);
		
	}

}
