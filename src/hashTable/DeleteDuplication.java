package hashTable;

public class DeleteDuplication {
	public String deleted(String s1){
		int []v = new int [256];
		char[] ch = s1.toCharArray();
		int slow=0;
		for(int i=0; i < ch.length; i++){
			//出现次数大于1的slow不操作
			if(v[ch[i]]==0){
				ch[slow]=ch[i];
				slow++;
			}
			v[ch[i]]++;//对出现过的次数计数
		}//第一次遍历
		s1="";
		for(int i =0; i < slow; i++){
			s1+=ch[i];
		}
		return s1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteDuplication test = new DeleteDuplication();
		System.out.println(test.deleted("goolesvae"));
	}
}	