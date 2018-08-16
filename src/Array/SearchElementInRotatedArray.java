package Array;

public class SearchElementInRotatedArray {//可以分成两步，一步是先找到最小的元素，下一步再分开找given元素
    public int search(int[] nums, int target) { 
        int start=0; 
        int end=nums.length-1;
        boolean foud = false;
        int mid=0;
        while(start<end){
            mid=(start+end)/2;
            if(nums[mid]==target) return mid; //刚好相等
             //不等的话改变查找范围
            if(target>nums[mid]){//大于mid的话，检查一下mid是位于左边还是右边
                if(nums[mid]>=nums[start]){//左边的
                    start = mid+1;
                }  
                else{//位于右边 nums[mid]
                    if(target<nums[start])  start=mid+1;
                    else{
                        end=mid-1;
                    }
                }
            }
            
            else{//小于mid的值，判断一下mid在左半边还是右半边
                if(nums[mid]>=nums[start]){ //mid位于左半边
                    if(target<nums[start]) start=mid+1;
                    else{
                        end=mid-1;
                    }
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
