package systemInput;

import java.util.Scanner;

public class systemInput {
	public static void main(String[] args) {
     /*   //创建Scanner对象
        //System.in表示标准化输出，也就是键盘输出
        Scanner sc = new Scanner(System.in);
        //利用hasNextXXX()判断是否还有下一输入项
        while (sc.hasNext()) {
            //利用nextXXX()方法输出内容
            String str = sc.next();
            System.out.println(str);*/
		System.out.println(solution(5, 2));
   }
	
	public  static int solution(int n, int k){
		int count=0;
		int y =k+1;
		int temp = y;
		while(k < n){
			int x = y-1;
			temp = y;
			while(y <=n){
				while(x<= n){
					count++;
					x=x+y;
				}
				x = temp-1;
				y++;
			}
			y = temp;
			k++;
			y++;
		}
		return count;
	}
}
