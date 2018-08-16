package string;
public class NumOf1 {
    public int NumberOf1Between1AndN_Solution(int n) {
       String str = ""+n;
       char[]s = str.toCharArray();
        if(s.length==1&& s[0]>=1){
            return 1;
        }
        if(s.length==0){
            return 0;
         }
        int numFirsDigit = 0;
        int numOtherDigit = 0;
        if(s[0]>'1'){
        	System.out.println(s[0]);
             numFirsDigit = PowValue(s.length-1);
        }
        else{
            numFirsDigit = Integer.parseInt(str.substring(1))+1;
        }
        //剩下的就分成两段进行处理
        if(s[0]>'1'){
            numOtherDigit = 2*(s.length-1)*PowValue(s.length-2);
        }else{
        	 if(s[1]!='0')
             {numOtherDigit = (s.length-1)*PowValue(s.length-2);}
        }
        
        int numRecur = NumberOf1Between1AndN_Solution(Integer.parseInt(str.substring(1)));
        return numFirsDigit + numOtherDigit + numRecur;
    }
    public static int PowValue(int n){
        int result =1;
        for(int i=0;i<n; i++){
            result = result*10;
        }
        return result;
    }
    public static void main(String[] args) {
    	NumOf1 test = new NumOf1();
    	int result = test.NumberOf1Between1AndN_Solution(10);
    	System.out.println(result);
    }
    
}