package string;


public class Palindromic {
	/*private int lo, maxLen;
	
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}
	
	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}*/
	
	private int lo;//起始位置
    private int maxlen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        
        for(int i=0; i< len-1; i++){//
            Palindrome(s,i,i);//奇数环
            Palindrome(s,i,i+1);//若是偶数环的话
        }
        return s.substring(lo, lo + maxlen);
    }
    //每次判断往两边扩展，比较是否与之前的最长的回文串的长度
    public void Palindrome(String s, int j, int k){//给的起始位置j和最终位置k
        while(j>=0 && k <s.length() && s.charAt(j) == s.charAt(k)){
            j--;    //如果每次相等，就往两边扩张进行判断，最后一次退出1.不等，2.过界
            k++;
        }
        //判断此次的回文串的长度与上一次的最大长度相比较
        if(maxlen < k-j-1){//如果比上次要长，就记录该回文串起始位置和更新最大值
            lo = j+1;
            maxlen = k-j-1;
        }
    }
    
    
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
		 Palindromic test = new Palindromic();
			String s = "abacdfgdcaba";
			System.out.println(test.longestPalindrome(s));
	 }
}