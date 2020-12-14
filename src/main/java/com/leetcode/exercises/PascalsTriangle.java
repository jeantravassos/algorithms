package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();

		List<List<Integer>> lista = pt.generate(6);
		lista.stream().forEach(System.out::println);
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>(numRows);
		if (numRows == 0)
			return triangle;
		
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);
		
		for (int rowNum = 1; rowNum < numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);
			
			row.add(1);
			
			for (int j = 1; j < rowNum; j++) {
				row.add(prevRow.get(j-1) + prevRow.get(j));
			}
			
			row.add(1);
			
			triangle.add(row);
		}
		
		return triangle;
	}
	
	
	public List<List<Integer>> generateMinhaSolucaoPedreira(int numRows) {

		List<List<Integer>> tree = new ArrayList<List<Integer>>(numRows);
		
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			
			if (tree.isEmpty()) {
				row.add(1);
			}
			else {
				row.add(1);
				
				for (int j = 1; j <= i; j++) {
					List<Integer> prev = tree.get(i-1);
					
					int sum = prev.get(j-1);
					if (j < i)
						sum += prev.get(j);
					
					row.add(sum);
				}
			}
			
			tree.add(row);
		}
		
		return tree;
	}

}
