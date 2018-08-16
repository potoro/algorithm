package dynamicProgramming;

public class TranslateNumIntoLetter {
	public static int tranlate(String num){
		int []count =new int[num.length()];
		char[] s = num.toCharArray();
		for(int i = s.length-1; i >=0; i--){
			if((i+1)< s.length){
				int cur = s[i]-'0';
				int next = s[i+1]-'0';
				int sum = cur*10 + next;
				if(sum>=0 && sum <=25){//可以一起翻译
					if((i+2) < s.length){
						count[i]=count[i+1]+count[i+2];
					}
					else count[i]=count[i+1]+1;
				}
				if(sum>25){//可以一起翻译
					count[i] = count[i+1];
				}
			}
			else{
				count[i]=1;//即为最后一个元素的情况
			}
		}
		return count[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tranlate("12258"));
	}

}
 