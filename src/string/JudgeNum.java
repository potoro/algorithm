package string;


public class JudgeNum {
    public boolean isNumeric(char[] str) {
        if(str.length==0) return false;
        int[] index= new int[1];
        
        boolean num = InterJudge(str,index);
        if(index[0]!=str.length && str[index[0]]=='.'){
            index[0]++;
            num = UnsignedIn(str,index)||num;
        }
        
        if(num){//Ҫô���������У�ҪôС��������
            if(index[0]!=str.length && (str[index[0]]=='e'||str[index[0]]=='E')){
            	index[0]++;
                num = InterJudge(str,index);//
            }
            return num && (index[0]==str.length);
        }
        else return false;
    }
    
    public boolean InterJudge(char[]str,int[]index){
        if(str[index[0]]=='+' || str[index[0]]=='-'){
            index[0]++;
        }
        return UnsignedIn(str,index);
    }
    
    
    public boolean UnsignedIn(char[]str,int[]index){
        int start = index[0];
        while(index[0]!=str.length&& str[index[0]]>='0'&&str[index[0]]<='9'){
            index[0]++;
        }
        if(index[0]>start) return true;//�ж����ţ�����еĻ��������Ƿ�Ϊ����
        else return false;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	JudgeNum test = new JudgeNum();
    	char[] str = "123.e+6".toCharArray();
    	System.out.println(test.isNumeric(str));
	}
}