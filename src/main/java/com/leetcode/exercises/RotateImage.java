package com.leetcode.exercises;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {
		
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix = {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7}, {15,14,12,16}};
		
		RotateImage.rotate(matrix);
	}
	
	
	
	public static void rotate(int[][] matrix) {
        int tmp, n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
        
    }
	
	/**
	 * Rotate four rectangles in one single loop
	 * @param matrix
	 */
	public static void rotate1(int[][] matrix) {
        
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 -i][n -j -1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		
		print2D(matrix);
    }

	public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int[] row : mat) 
  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    } 
}
