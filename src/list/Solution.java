package list;
public class Solution {
    public int GetNumberOfK(int []num , int k) {
       int first = GetFirstOfK(num,0,num.length-1,k);
       int last = GetLastOfK(num,0,num.length-1,k);
        if(first!=-1&&last!=-1){
            return last-first+1;
        }
        return 0;
    }
    public int GetFirstOfK(int[]num, int start, int end, int k){
        if(end<=start){//边界条件
            if(num[start]==k)return start;
            else{return -1;} 
        }
        int mid = (start+end)/2;
        if(num[mid]==k){
            if(mid!=start&&num[mid-1]==k)
                end = mid-1;
            else{ return mid;}
           //一种是mid=1的情况，另一种是
        }
        else if(num[mid]>k) end=mid-1;
        else{
            start = mid+1;
        }
        return GetFirstOfK(num,start,end,k);
    }
    public int GetLastOfK(int[]num, int start, int end, int k){
       if(end<=start){//边界条件
            if(num[start]==k)return start;
            else return -1;
        }
       int mid = (start+end)/2;
       if(num[mid]==k){
           if(mid!=end &&num[mid+1]==k)
               start = mid+1;
           else{return mid;}
       }
       else if(num[mid]>k) end = mid-1;
       else{
           start = mid+1;
       }
        return GetLastOfK(num,start,end,k);
    }
}