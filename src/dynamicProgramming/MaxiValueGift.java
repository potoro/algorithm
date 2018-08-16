package dynamicProgramming;

public class MaxiValueGift {
//自底向上分析
	public int getMax(int[]price, int rows,int cols){
		if(price.length==0 || rows <0 || cols<0 || price.length!=rows*cols){
			return -1;
		}
		int maxiValue[] = new int[cols];
		for(int i=0; i < rows; i++){
			for(int j=0; j < cols; j++){
				int left = 0;
				int up = 0;
				if(i>0){
					up = maxiValue[j];
				}
				if(j>0){
					left = maxiValue[j-1]; 
				}
				
				maxiValue[j] = Math.max(left,up) + price[i*cols+j];
			}
		}
		return maxiValue[cols-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[] = new int[]{1,10,3,8,12,2,9,6,5,7,4,11,3,7,16,5};
		MaxiValueGift test = new MaxiValueGift();
		int result = test.getMax(price, 4, 4);
		System.out.println(result);
		int []v = new int [256];
	
	/*	char []s = new char[]{'a','b','c','d','e','f','g'};
		for(int i=0; i<s.length; i++){
			
			v[s[i]]++;
			System.out.println(Character.charCount(s[i]));
		}*/
		
	}
}
