package com.springDemo;
import java.util.*;

public class test {
	
	public static int optimalSum(int A[], int B[] , int k) {
		
		Arrays.sort(A);
		Arrays.sort(B);
		int len = A.length-1;
		int sum = 0 ;
		
		for(int i = 1,j = 0 ; i <= k && j <= len; i++,j++) {
			if(A[j] >= B[len-j])
				break;
			A[j] = B[len-j];
		}
		
		for(int i = 0 ; i <= len ; i++)
			sum = sum + A[i];
		
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = Integer.parseInt("10",16);
		double b = Math.pow(10, 9)+7;
		int c= (int)b;
		System.out.println(a%c);
	}

}
