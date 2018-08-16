package dynamicProgramming;

public class ChangeCoinsWithMinNum {
	public static int ChangeCoins(int []change,int value){
		int [][]dp=new int[change.length+1][value+1];
		for(int i=0; i<=value; i++){
			dp[0][i]=Integer.MAX_VALUE-value; //������ֵ
		}//Ϊ�˿��Ʋ������-value
		for(int i=1; i<=change.length; i++){
			dp[i][0]=0;//����ֵΪ0��Ӧ����0
		}
		for(int i=1; i<=change.length; i++){//iʱ��Ӧi-1
			for(int j=1; j<=value; j++){
				if(change[i-1]>j){//��i����Ǯ����ֵ����j����
					dp[i][j]=dp[i-1][j];
					continue;
				}
				else{
					if(dp[i-1][j]<dp[i][j-change[i-1]]+1){//�˴����ж�ʱ��dp[i][j-change[i-1]]Ϊ���ֵMAX_VALUEʱ��1�������ɸ���
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
