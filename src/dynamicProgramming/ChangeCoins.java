package dynamicProgramming;

public class ChangeCoins {
	public static int method(int[]change, int value){
		int k=change.length;
		int [][]dp = new int[k+1][value+1];//第一行是为了方便计算的
		for(int i=0;i<value+1;i++){
			dp[0][i]=0;  //只有零种散钱，当然是0
		}
		for(int i=1; i<=k; i++){
			dp[i][0]=1;
		}
		for(int i=1; i<k+1;i++){
			for(int j=1; j<value+1; j++){//这里要兑换的钱为j
				if(j<change[i-1]){
					dp[i][j]=dp[i-1][j];//所以不能用面值为change[i]的
				}else{
					dp[i][j]=dp[i-1][j]+dp[i][j-change[i-1]];//注意这里的
				}
			}
		}
		return dp[k][value];
	}
	public static int recrusiveChangeType(int []change, int k, int value){
		//不包含第k种的值，
		if(value<0){
			return 0;
		}
		if(value==0){
			return 1;
		}
		if(k<=0){
			return 0;
		}
		return recrusiveChangeType(change, k-1, value) + recrusiveChangeType(change, k, value-change[k-1]);
	}                                                                              //value-change[k-1]有可能等于0
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []change= new int[]{2,3,5};
		System.out.println(method(change,10));
		System.out.println(recrusiveChangeType(change,3,10));
	}

}
