package hashTable;
import java.util.*;//�ַ�����ɾ������
public class DeleteCharOfString2InString {
	public String deleteChar(String s1, String s2){//����һ����������ģ��hashTable;
		//������һ�����飬�洢�ռ䣬ͬʱ�ڰ��ַ�����ת��Ϊ�ַ�������Ҫ����һ�鵽��ָ��λ��
		int []v = new int [256];
		char[] ch = s1.toCharArray();
		for(int i=0; i< s2.length(); i++){
			v[s2.charAt(i)]++;
		}
		//����ɾȥs1�д��е�s2���ַ�����
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
