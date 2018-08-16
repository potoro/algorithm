package Array;

public class Solution {
	public static int[] desolve(int n){
		boolean exit = false;
		for(int y =2; y < n/2; y+=2){
			if(n%y==0 && (n/y)%2==1){
				exit=true;
				return new int[]{n/y, y};
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(desolve(10)!=null){
			int []a = desolve(10);
			System.out.println(a[0]);
			System.out.println(a[1]);
		}
	}

}
