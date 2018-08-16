package efficiency;
import java.util.*;

/*public class FindLeastK {
	    public int MoreThanHalfNum_Solution(int [] nums) {
	       int start = 0;
	        int end = nums.length-1;
	        int index = partion(nums,start,end);//可以获得时
	        int middle = nums.length/2;
	        while(index != middle){
	            if(index > middle){
	                index = partion(nums,start,index-1);
	            }
	            else{
	                index = partion(nums,index+1,end);
	            }
	        }
	        return nums[index];
	    }
	     
	     public int partion(int[]nums,int start,int end){
	        if(nums == null || nums.length==0 || start < 0|| end > nums.length-1){
	            return 0;
	        }
	        //int index=(int)(Math.random()*(end-start+1)) + start;//
	        Random random = new Random();
	        int index = random.nextInt(end-start+1)+start;
	        swap(nums[index], nums[end]);
	        int low = start-1;
	        for(int high = start; high < end; high++){
	            if(nums[high] < nums[end]){
	                low++;
	                swap(nums[low],nums[high]);
	            }
	        }
	        swap(nums[low+1],nums[end]);
	        return low+1;
	    }
	     
	    public void swap(int a, int b){
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	     
	*/
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []arr = new int[]{1,2,3,2,2,2,5,4,2};
		FindLeastK test = new FindLeastK();
		System.out.println(test.MoreThanHalfNum_Solution(arr));
	}

}*/


import java.util.*;
public class FindLeastK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
        //一种是按照partion的方法排好序，每次找index与k-1相比较
         ArrayList<Integer> list = new ArrayList<>();
        if(nums == null|| nums.length==0||nums.length<k) return list;
        int start = 0;
        int end = nums.length-1;
        int index = partion(nums,start,end);//可以获得时
        //int middle = nums.length/2;
        while(index != k-1){
            if(index > k-1){
                index = partion(nums,start,index-1);
            }
            else{
                index = partion(nums,index+1,end);
            }
        }
        
        for(int i = 0; i < k; i++){
            list.add(nums[i]);
        }
        return list;
    }
    
     
    public int partion(int[]nums,int start,int end){
        if(nums == null || nums.length==0 || start < 0|| end > nums.length-1){
            return 0;
        }
        //int index=(int)(Math.random()*(end-start+1)) + start;//
        Random random = new Random();
        int temp = 0;
        int index = random.nextInt(end-start+1)+start;
        //swap(nums[index], nums[end]);
        temp = nums[index];
        nums[index] = nums[end];
        nums[end] = temp;
        int low = start-1;
        for(int high = start; high < end; high++){
            if(nums[high] < nums[end]){
                low++;
                //swap(nums[low],nums[high]);
                temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }
        //swap(nums[low+1],nums[index]);
        temp = nums[low+1];
        nums[low+1] = nums[end];
        nums[end] = temp;
        return low+1;
    }
     
  /*  public void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }*/
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int arr[] = new int[]{4,5,1,6,2,7,3,8};
    	FindLeastK test = new FindLeastK();
    	Iterator<Integer> iter = test.GetLeastNumbers_Solution(arr, 4).iterator();
    	for(;iter.hasNext();){
    		System.out.println(iter.next());
    	}
    }
    
}
