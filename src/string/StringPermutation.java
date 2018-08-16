package string;
import java.util.*;

/*public class StringPermutation {
	public void swap(char[] arr, int idx1, int idx2){
		char temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	public void permutation(char[] arr, int index, int size){
		if(index == size){//一直到size为止,超过最后一个索引
			for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		else{
			for(int i = index;i < size;i++){
				swap(arr,i,index);
				permutation(arr,index+1,size);
				swap(arr,i,index);//这是为了每次拍完后再回复原来的顺序好进行下面的排序
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation test = new StringPermutation();
		char arr[] = new char[]{'a','b','c'};
		test.permutation(arr,0,arr.length);
//		String s = new String();
//		s = "abcde";
//		System.out.println(s.length());
	}

}
*/

public class StringPermutation {
	
	  //ArrayList <String> list = new ArrayList<>();
	    public void swap(char[]arr, int idx1,int idx2){
	        char temp = arr[idx1];
	        arr[idx1] = arr[idx2];
	        arr[idx2] = temp;
	    }
	    
	    public ArrayList <String> Permutation(String str) {
	       ArrayList <String> result = new ArrayList <>();
	       char []arr = str.toCharArray();
	       ArrayList <String> temp = new ArrayList<>();//
	       Permutation(arr,0,temp);
	       //result.addAll(temp);
	        //return result;
	      return temp;
	    }
	    //为什么要
	    public void Permutation(char[] arr,int index,ArrayList<String>list) {//基于给定的字符串中可能有相同的字母的，故排序后的组合可能有重复，用set就去掉了重复的
	        if(arr==null || arr.length==0 || index<0 || index>arr.length) { return ; }
	        if(index == arr.length){//刚好到到达字符串尾部的时候就打印字符串
	        	//list.clear();       //
	             list.add(String.valueOf(arr));//
	            for(int i=0; i< arr.length; i++){
	               System.out.print(arr[i]);
	              
	            }
	            //list.add(' ');
	            System.out.println();
	           
	        }
	        for(int i=index; i<arr.length; i++){
	            swap(arr,i,index);
	            Permutation(arr,index+1,list);
	            swap(arr,i,index);//恢复原来的顺序，以便后面的排序；
	        }
	        
	    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation test = new StringPermutation();
		//char arr[] = new char[]{'a','b','c'};
		test.Permutation("abb");
		
    }
}