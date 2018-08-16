package hashTable;

public class Anagram {
	public static boolean judge(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		int []v = new int [256];
		char[] ch = s1.toCharArray();
		for(int i=0; i< s1.length(); i++){
			v[s1.charAt(i)]++;
		}
		for(int i=0; i< s2.length(); i++){
			v[s2.charAt(i)]--;
		}
		for(int i=0; i<256;i++){
			if(v[i]!=0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(judge("livef","evilg"));
	}

}
