package Array;

public class SearchMinInRotatedArray {
	public static int search(int[] nums,int target) { 
		if(nums==null||nums.length==1) return -1;
        int start=0; 
        int end=nums.length-1;
        boolean foud = false;
        int mid=0;
        while(start<end){  //start<end
            mid=(start+end)/2;
            if(nums[mid]>=nums[start] && nums[mid]>nums[end]){//���ҵ���С���Ǹ�Ԫ��,//��Ϊ�˱���nums[mid]>nums[end]�����
                start=mid+1;
            }else{
                end=mid;
            }
        }
        int rot = start;
        start = 0; 
        end = nums.length-1;
        if(target>=nums[start]&&target>nums[end]){
            end=rot;
        }else{ //�����rot>start�Ļ��Ͳ�һ��
            start=rot;
        }//ȷ��������һ������ұ���
        if(end==start&&nums[start]==target) return start;
        while(start<=end){ 
            mid=(start+end)/2;
            if(target==nums[mid]) return mid;
            if(target>nums[mid]) start=mid+1;
            else{
                end=mid-1;
            }
        }
        return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = new int[]{0,1,2,4,5,6,7};
		int result = search(nums,1);
		System.out.println(result);
	}

}
