package systemInput;

import java.util.Scanner;

public class systemInput {
	public static void main(String[] args) {
     /*   //����Scanner����
        //System.in��ʾ��׼�������Ҳ���Ǽ������
        Scanner sc = new Scanner(System.in);
        //����hasNextXXX()�ж��Ƿ�����һ������
        while (sc.hasNext()) {
            //����nextXXX()�����������
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
