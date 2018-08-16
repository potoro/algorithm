package dynamicProgramming;

import string.NumOf1;

public class MaxiSubString {
	public int longestSubStringWithoutDuplicaiton(String s){
		int curLength =0;
		int maxLength =0;
		int []position = new int[26];
		for(int i=0; i<26; i++){
			position[i] = -1;
		}
		int preIndex = 0;
		for(int i=0; i<s.length();i++){
			preIndex = position[s.charAt(i)-'a'];
			if(position[s.charAt(i)-'a']<0||(i-preIndex)>curLength){//之前的没有出现过，或者之前出现（index-当前index）>curLength
				curLength++;
			}
			else{
				curLength = i-preIndex;
			}
			if(curLength>maxLength){
				maxLength = curLength;
			}
			position[s.charAt(i)-'a']=i;
		}
		return maxLength;
	}
	 public static void main(String[] args) {
		 MaxiSubString test= new MaxiSubString();
	    	int result = test.longestSubStringWithoutDuplicaiton("arabcacfr");
	    	System.out.println(result);
	    }
	
}
