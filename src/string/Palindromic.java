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
	
	private int lo;//��ʼλ��
    private int maxlen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        
        for(int i=0; i< len-1; i++){//
            Palindrome(s,i,i);//������
            Palindrome(s,i,i+1);//����ż�����Ļ�
        }
        return s.substring(lo, lo + maxlen);
    }
    //ÿ���ж���������չ���Ƚ��Ƿ���֮ǰ����Ļ��Ĵ��ĳ���
    public void Palindrome(String s, int j, int k){//������ʼλ��j������λ��k
        while(j>=0 && k <s.length() && s.charAt(j) == s.charAt(k)){
            j--;    //���ÿ����ȣ������������Ž����жϣ����һ���˳�1.���ȣ�2.����
            k++;
        }
        //�жϴ˴εĻ��Ĵ��ĳ�������һ�ε���󳤶���Ƚ�
        if(maxlen < k-j-1){//������ϴ�Ҫ�����ͼ�¼�û��Ĵ���ʼλ�ú͸������ֵ
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