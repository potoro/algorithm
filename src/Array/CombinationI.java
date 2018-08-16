package Array;
import java.util.*;
public class CombinationI{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList= new ArrayList<>();
        if(n<k) return res;
        backTrack(res, tempList, n, k, 1);
        return res;
    }
    public void backTrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int start){
        if(tempList.size()==k){
            res.add(new ArrayList<>(tempList));
            return;
        }
       // if(start>n) return; //Ϊ�˱������start=n+1�����tempList.size()����û�е���Kʱ��tempList�м���i+1��Ԫ��
        for(int i=start; i<=n; i++){
            tempList.add(i);
            backTrack(res, tempList, n, k, i+1);  
            tempList.remove(tempList.size()-1);
        }
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	CombinationI test = new CombinationI();
    	List<List<Integer>> result = test.combine(3, 2);
	}
}