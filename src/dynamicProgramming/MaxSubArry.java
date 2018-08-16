package dynamicProgramming;
import java.util.*;
public class MaxSubArry {//用devide and conquer来解决
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int []t =  findMaxSub(nums, 0, nums.length-1);
           return t[2];
    }
    
    public int[] findMaxSub(int[]nums, int start, int end){
        if(start==end){
            return new int[]{start,end,nums[start]};
        } 
        int mid=(start+end)/2;
        int[] left = findMaxSub(nums,start,mid);
        int[] right = findMaxSub(nums, mid+1,end);
        int[] middle = crossMidMaxArry(nums,start,end,mid);
        if(left[2] >= right[2] && left[2] >= middle[2]) return left;
        else if(right[2] >= left[2] && right[2] >= middle[2]) return right;
        else return middle;
       
        
    }
    
    public int[] crossMidMaxArry(int[]nums, int start,int end,int mid){
        //从中间第一各元素开始
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0;
        for(int i=mid; i >= start; i--){
            sum = sum+nums[i];
            if(sum > left_sum){
                left_sum = sum;
                left = i;
            }
        }
        
        sum = 0;
        int right = 0;
        int right_sum = Integer.MIN_VALUE;
        for(int i = mid+1; i <= end; i++){
            sum = sum + nums[i];
            if(sum > right_sum){
                right_sum = sum;
                right = i;
            }
        }
        return new int[]{left,right,left_sum + right_sum};
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	MaxSubArry test = new MaxSubArry();
    	int[]A = {-1,-1,-2,-2};
    	System.out.println(test.maxSubArray(A));
    	 Random random = new Random();
         int index = random.nextInt(3)+3;
         
    	System.out.println(index);
	}
    
}
