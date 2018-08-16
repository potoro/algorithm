package hashTable;
import java.util.*;//字符串的删除方法
public class DeleteCharOfString2InString {
	public String deleteChar(String s1, String s2){//就用一个数组数组模拟hashTable;
		//多用了一个数组，存储空间，同时在把字符数组转化为字符串还需要遍历一遍到达指定位置
		int []v = new int [256];
		char[] ch = s1.toCharArray();
		for(int i=0; i< s2.length(); i++){
			v[s2.charAt(i)]++;
		}
		//接着删去s1中带有的s2的字符串；
		int slow = 0;
		int fast = 0;
		for(int i=0; i<ch.length; i++){
			
			if(v[s1.charAt(i)]==0){
				//
				ch[slow]=ch[fast];
				slow++;
			}
			fast++;
		}
		s1="";
		for(int i=0; i<slow;i++){
			s1+=ch[i];
		}
		return s1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteCharOfString2InString test = new DeleteCharOfString2InString();
		String result = test.deleteChar("We are studies", "aseo");
		System.out.println(result);
	}
	
}
