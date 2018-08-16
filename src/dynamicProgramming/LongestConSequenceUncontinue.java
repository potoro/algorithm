package dynamicProgramming;

public class LongestConSequenceUncontinue {
	public static String LCS(String str1, String str2){  //记录一下长度
		if(str1==null||str2==null) return null;
		int dp[][]= new int[str1.length()+1][str2.length()+1];
		int flag[][]=new int[str1.length()+1][str2.length()+1];  //记录轨迹的
		for(int i=1; i<=str1.length(); i++){
			for(int j=1; j<=str2.length(); j++){//为了避免每次判断检查左边和上边的为元素是否不存在，多了dp[0][X]的一行和dp[j][0]的一列
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
					flag[i][j]=1;
				}else if(dp[i-1][j]>dp[i][j-1]){//即为上方的大于左边的
					dp[i][j]=dp[i-1][j];
					flag[i][j]=2;//表示是向下的(由顶上的元素往下)
				}else{
					dp[i][j]=dp[i][j-1];
					flag[i][j]=3;//向右的
				}
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
		int i=str1.length();
		int j=str2.length();//从后往前还是从前往后呢，假设是从后
		//StringBuffer result= new StringBuffer();//创造为空的
		char [] re = new char[dp[str1.length()][str2.length()]];//标记总长度
		int count = 0;
		while(i>0&&j>0){
			if(flag[i][j]==1){
				//result.append(str1.charAt(i-1));
				re[count]=str1.charAt(i-1);
				count++;
				i--;
				j--;
			}
			else if(flag[i][j]==2){//由顶上的元素往下
				i--;
			}
			else if(flag[i][j]==3){
				j--;
			}
		}
		String result = re.toString();
		return result;
		//return .toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCS("ABCDAB","BDCABA"));
	}

}
