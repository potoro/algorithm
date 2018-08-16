package dynamicProgramming;

public class LeastOperationToGetMaxConSequen {//
	public static int LOGMC(String str1, String str2){
		int[][] dp = new int[str1.length()+1][str2.length()+1];  //首先指定所有的全为最大值，以防止某些项没有更改的时候会变最小
		for(int i=0;i<str1.length();i++){
			for(int j=0; j<str2.length();j++){
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		dp[str1.length()][str2.length()]=0;
		for(int i=0; i<str1.length(); i++){
			dp[i][str2.length()]=str1.length()-i;//相当于从尾部开始计数的str2还没开始，str2比较的部分为0，因此要改变str1.length();的长度
		}
		for(int j=0; j<str2.length();j++){
			dp[str1.length()][j]=str2.length()-j;
		}
		//从后往前
		for(int j=str2.length()-1; j>=0; j--){
			for(int i=str1.length()-1; i>=0; i--){
				if(str1.charAt(i)==str2.charAt(j)){//如果刚好相等的话
					dp[i][j]=dp[i+1][j+1];//无需操作
				}
				else{//有删除的i位置得到相等的，有删除str2的j相等的
					int a = dp[i+1][j]; //删除i的和j为止的相同
					int b = dp[i][j+1];//删除j的
					int c = dp[i+1][j+1]+1;//删除两个的，其实和替换的是一个效果，假设替换2个中的一个和删除两个，但是操作的步数还是一样的啊
					//删除两个操作步骤应该是2了，这里的意思应该是替换其中一个
					dp[i][j]=min(a,b,c);
				}
			}
		}
		return dp[0][0];
	}
	public static int min(int a, int b, int c){
		int max=0;
		max = a>b? a:b;
		max = max>c? max:c;
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		int result=LOGMC("ABcf", "Amvf");
		System.out.println(result);
	}
}
