package Array;

public class SearchElementInRotatedArray {//���Էֳ�������һ�������ҵ���С��Ԫ�أ���һ���ٷֿ���givenԪ��
    public int search(int[] nums, int target) { 
        int start=0; 
        int end=nums.length-1;
        boolean foud = false;
        int mid=0;
        while(start<end){
            mid=(start+end)/2;
            if(nums[mid]==target) return mid; //�պ����
             //���ȵĻ��ı���ҷ�Χ
            if(target>nums[mid]){//����mid�Ļ������һ��mid��λ����߻����ұ�
                if(nums[mid]>=nums[start]){//��ߵ�
                    start = mid+1;
                }  
                else{//λ���ұ� nums[mid]
                    if(target<nums[start])  start=mid+1;
                    else{
                        end=mid-1;
                    }
                }
            }
            
            else{//С��mid��ֵ���ж�һ��mid�����߻����Ұ��
                if(nums[mid]>=nums[start]){ //midλ������
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
