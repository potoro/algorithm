package dynamicProgramming;

public class LongestConSequenceUncontinue {
	public static String LCS(String str1, String str2){  //��¼һ�³���
		if(str1==null||str2==null) return null;
		int dp[][]= new int[str1.length()+1][str2.length()+1];
		int flag[][]=new int[str1.length()+1][str2.length()+1];  //��¼�켣��
		for(int i=1; i<=str1.length(); i++){
			for(int j=1; j<=str2.length(); j++){//Ϊ�˱���ÿ���жϼ����ߺ��ϱߵ�ΪԪ���Ƿ񲻴��ڣ�����dp[0][X]��һ�к�dp[j][0]��һ��
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
					flag[i][j]=1;
				}else if(dp[i-1][j]>dp[i][j-1]){//��Ϊ�Ϸ��Ĵ�����ߵ�
					dp[i][j]=dp[i-1][j];
					flag[i][j]=2;//��ʾ�����µ�(�ɶ��ϵ�Ԫ������)
				}else{
					dp[i][j]=dp[i][j-1];
					flag[i][j]=3;//���ҵ�
				}
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
		int i=str1.length();
		int j=str2.length();//�Ӻ���ǰ���Ǵ�ǰ�����أ������ǴӺ�
		//StringBuffer result= new StringBuffer();//����Ϊ�յ�
		char [] re = new char[dp[str1.length()][str2.length()]];//����ܳ���
		int count = 0;
		while(i>0&&j>0){
			if(flag[i][j]==1){
				//result.append(str1.charAt(i-1));
				re[count]=str1.charAt(i-1);
				count++;
				i--;
				j--;
			}
			else if(flag[i][j]==2){//�ɶ��ϵ�Ԫ������
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
