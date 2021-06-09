package com.learn.springAnnotations;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;
		int n = 4;
		int arr[][] = new int[m][n];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++)
				arr[i][j] = sc.nextInt();
		}
		
		int[][] result = Sort2DArrayByRow(arr);
		
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++)
				System.out.println(result[i][j]);
		}
		
	}

	private static int[][] Sort2DArrayByRow(int[][] arr) {
		
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			int temp[] = new int[arr[i].length];
			
			for(int j = 0 ; j < arr[i].length ; j++)
				temp[j] = arr[i][j];
			
			Arrays.sort(temp);
			
			for(int j = 0 ; j < arr[i].length ; j++)
				arr[i][j] = temp[j];
			
		}
		
		return arr;
	}


}
