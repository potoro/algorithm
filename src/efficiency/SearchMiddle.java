package efficiency;





import java.util.*;

import dynamicProgramming.MaxProductArray;
public class SearchMiddle {
    public int MoreThanHalfNum_Solution(int [] nums) {
        boolean InvaildInput = false;
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
        int result = nums[index];//返回查询的结果
        int count = 0;
        for(int i =0; i < nums.length; i++){
            if(nums[i]==result) count++;
        }
        
        if(count < nums.length/2){
            InvaildInput = true;
            return 0;
        }
        else return result;
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
            if(nums[high] <= nums[end]){
                low++;
                temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                //swap(nums[low],nums[high]);
            }
        }
        //swap(nums[low+1],nums[end]);
         temp = nums[low+1];
         nums[low+1] = nums[end];
         nums[end] = temp;
        return low+1;
    }
     public static void main(String[] args) {
 		// TODO Auto-generated method stub
     	//int arr[] = new int[]{1,2,3,2,2,2,5,4,2};
    	 int arr[] = new int[]{1,2,3,2,4,2,5,2,3};
     	SearchMiddle test = new SearchMiddle();
     	//Iterator<Integer> iter = test.GetLeastNumbers_Solution(arr, 4).iterator();
     	System.out.println(test.MoreThanHalfNum_Solution(arr));
    } 
}


