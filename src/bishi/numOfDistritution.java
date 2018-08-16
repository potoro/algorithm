package bishi;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


public class numOfDistritution {
	static int N = 100000007;
	public static int f(int[] changes, int n, int x) {
		int[][] dp=new int[n][x+1];
		for(int i=0;i<n;i++)
		dp[i][0]=1;
		for(int j=0;j*changes[0]<=x;j++){
			dp[0][j*changes[0]]=1;
		}
		
		for(int i=1;i<n;i++){
			for(int j=1;j<=x;j++){
					dp[i][j]=dp[i-1][j] +(j-changes[i]>=0?dp[i][j-changes[i]]:0);
					dp[i][j] = dp[i][j] % N;
					}
				}
		return dp[n-1][x];
		}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
        	int t = in.nextInt();
        	for (int i = 0; i < t; i ++) {
        		int n = in.nextInt();
        		int k = in.nextInt();
        		int [] v = new int [n];
        		for (int j = 0; j < n ; j ++) 
        			v[j] = in.nextInt();
        		System.out.println(f(v,n,k));
        	}       	
        }
    }
}