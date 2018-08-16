package dynamicProgramming;

public class BuyStocks {
	public int maxProfit(int[] prices){
		if(prices.length < 2){
			return 0;
		}//Ѱ��һ������������������
		int []diff = new int[prices.length-1];
		for(int i=0; i < diff.length; i++){
			diff[i] = prices[i+1]-prices[i];
		}
		return maxSubArray(diff);
	}
	
	public int maxSubArray(int [] diff){
		//ֻҪ�ҳ����������ĺͼ���
		int m=0, preMax=0;
		for(int i=0; i<diff.length; i++){
			preMax = Math.max(0, preMax+diff[i]);
			m = Math.max(m, preMax);
		}
		return m;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
