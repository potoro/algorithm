package dynamicProgramming;

import java.util.Iterator;



public class MaxProductArray {
    public int maxProduct(int[] nums) {
        //可以用一个元素暂时存取nums[i]为最后一个元素的连续数组的乘积的最大值
        int result = nums[0];
        //int min = nums[0];//存储一个连乘的最小元素是为了遇到负数的nums[i]时计算当前的最大乘积
        for(int i=1, max = nums[0], min = nums[0]; i < nums.length; i++){
            if(nums[i] < 0){
            	 int temp = max;
                 max = min;
                 min = temp;
            }
            max = Math.max(nums[i],max*nums[i]);//
            min = Math.min(nums[i],min*nums[i]);
            if(result < max){
                result = max;
            }
        }
        return result;
    }
 
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int arr[] = new int[]{-2,3,-4};
    	MaxProductArray test = new MaxProductArray();
    	//Iterator<Integer> iter = test.GetLeastNumbers_Solution(arr, 4).iterator();
    	System.out.println(test.maxProduct(arr));
    	
   }
}
