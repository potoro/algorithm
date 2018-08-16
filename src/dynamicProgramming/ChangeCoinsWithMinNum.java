package dynamicProgramming;

public class ChangeCoinsWithMinNum {
	public static int ChangeCoins(int []change,int value){
		int [][]dp=new int[change.length+1][value+1];
		for(int i=0; i<=value; i++){
			dp[0][i]=Integer.MAX_VALUE-value; //获得最大值
		}//为了控制不溢出，-value
		for(int i=1; i<=change.length; i++){
			dp[i][0]=0;//找面值为0的应该是0
		}
		for(int i=1; i<=change.length; i++){//i时对应i-1
			for(int j=1; j<=value; j++){
				if(change[i-1]>j){//第i种零钱的面值大于j本身
					dp[i][j]=dp[i-1][j];
					continue;
				}
				else{
					if(dp[i-1][j]<dp[i][j-change[i-1]]+1){//此处在判断时若dp[i][j-change[i-1]]为最大值MAX_VALUE时加1会溢出变成负数
						dp[i][j]=dp[i-1][j];
					}else{
						dp[i][j]=dp[i][j-change[i-1]]+1;  //
					}
				}
			}
		}
		return dp[change.length][value];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []change= new int[]{2,3,5};
		System.out.println(ChangeCoins(change,10));
	/*	System.out.println(Integer.MAX_VALUE);
		int a = Integer.MAX_VALUE;
		System.out.println(a);*/
	}

}
