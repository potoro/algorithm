package string;
import java.util.*;

/*public class StringPermutation {
	public void swap(char[] arr, int idx1, int idx2){
		char temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	public void permutation(char[] arr, int index, int size){
		if(index == size){//һֱ��sizeΪֹ,�������һ������
			for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		else{
			for(int i = index;i < size;i++){
				swap(arr,i,index);
				permutation(arr,index+1,size);
				swap(arr,i,index);//����Ϊ��ÿ��������ٻظ�ԭ����˳��ý������������
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
	    //ΪʲôҪ
	    public void Permutation(char[] arr,int index,ArrayList<String>list) {//���ڸ������ַ����п�������ͬ����ĸ�ģ�����������Ͽ������ظ�����set��ȥ�����ظ���
	        if(arr==null || arr.length==0 || index<0 || index>arr.length) { return ; }
	        if(index == arr.length){//�պõ������ַ���β����ʱ��ʹ�ӡ�ַ���
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
	            swap(arr,i,index);//�ָ�ԭ����˳���Ա���������
	        }
	        
	    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation test = new StringPermutation();
		//char arr[] = new char[]{'a','b','c'};
		test.Permutation("abb");
		
    }
}