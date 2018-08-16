package dynamicProgramming;

public class LeastOperationToGetMaxConSequen {//
	public static int LOGMC(String str1, String str2){
		int[][] dp = new int[str1.length()+1][str2.length()+1];  //����ָ�����е�ȫΪ���ֵ���Է�ֹĳЩ��û�и��ĵ�ʱ������С
		for(int i=0;i<str1.length();i++){
			for(int j=0; j<str2.length();j++){
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		dp[str1.length()][str2.length()]=0;
		for(int i=0; i<str1.length(); i++){
			dp[i][str2.length()]=str1.length()-i;//�൱�ڴ�β����ʼ������str2��û��ʼ��str2�ȽϵĲ���Ϊ0�����Ҫ�ı�str1.length();�ĳ���
		}
		for(int j=0; j<str2.length();j++){
			dp[str1.length()][j]=str2.length()-j;
		}
		//�Ӻ���ǰ
		for(int j=str2.length()-1; j>=0; j--){
			for(int i=str1.length()-1; i>=0; i--){
				if(str1.charAt(i)==str2.charAt(j)){//����պ���ȵĻ�
					dp[i][j]=dp[i+1][j+1];//�������
				}
				else{//��ɾ����iλ�õõ���ȵģ���ɾ��str2��j��ȵ�
					int a = dp[i+1][j]; //ɾ��i�ĺ�jΪֹ����ͬ
					int b = dp[i][j+1];//ɾ��j��
					int c = dp[i+1][j+1]+1;//ɾ�������ģ���ʵ���滻����һ��Ч���������滻2���е�һ����ɾ�����������ǲ����Ĳ�������һ���İ�
					//ɾ��������������Ӧ����2�ˣ��������˼Ӧ�����滻����һ��
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
