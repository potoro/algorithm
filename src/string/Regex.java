package string;

public class Regex {
	public boolean match(char[] str, char[] pattern)
    {
       if(str==null || pattern==null) return true;
       //if(str.length==0 && pattern.length!=0) return false;
       int index1 = 0;
       int index2 = 0;
       return method(str, pattern,index1,index2);
    }
    
    public boolean method(char[] str, char[] pattern, int index1, int index2){
    	if(index1==str.length && index2==pattern.length) return true;
        if(index1!=str.length && index2==pattern.length) return false;
    	//if(index1==str.length || index2==pattern.length) return false;
    	//后面是两者都没到末尾的情况
        if(index2 < pattern.length-1 && pattern[index2+1]=='*'){
           if(index1!=str.length &&(str[index1]==pattern[index2] ||(pattern[index2]=='.' && index1!=str.length))){
               return method(str,pattern,index1,index2+2)||
                   method(str,pattern,++index1,index2)||
                   method(str,pattern,++index1,index2+2);
           }else{ //不匹配直接跳过
               return method(str,pattern,index1,index2+2);
           }
       }
        //index1[0]<str.length && index2[0]< pattern.length
       else if(index1!=str.length && (str[index1]==pattern[index2]||pattern[index2]=='.' )){
           index1++;
           index2++;
           return  method(str, pattern,index1,index2);
       }
       else return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Regex test = new Regex();
		char []str = "aaba".toCharArray();
		char []pattern ="ab*a*c*a".toCharArray();
		System.out.println(test.match(str,pattern));
	}

}
