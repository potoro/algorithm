package string;

public class ReverseSentence {
	public static String ReverseSentence(String str) {
	       char s[] = str.toCharArray();
	       reverse(s,0,s.length-1);
	       //�����е���ĸ����ת������
	       //��������ת���еĵ���
	       int start=0;
	       int end = 0;
	       while(start!=(s.length-1)){
	    	   while(s[start]==' '){
	    		   start++;
	    	   }
	    	   end = start;
	    	   while(s[end]!=' '&& end!=s.length-1){
	    		   end++;
	    	   }
	    	   if(s[end]==' '){
	    		   reverse(s,start,--end);//�˻ز���' '�ĵط�
	    		   end++;
	    	   }else if(end==s.length-1){
	    		   reverse(s,start,end);
	    	   }
	    	   start = end;
	       }
	       
	       System.out.println(String.valueOf(s));
	       return String.valueOf(s);
	    }
	public static void reverse(char[]s, int start, int end){
       while(start < end){
    	   char temp = s[start];
    	   s[start] = s[end];
    	   s[end] = temp;
    	   end--;
    	   start++;
       }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseSentence("i am a student");
	}

}
