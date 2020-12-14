package com.leetcode.exercises;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MinStack {

	private Stack<Integer> pilha;
	
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(1);
		obj.pop();
		int param_3 = obj.top();
		int param_4 = obj.getMin();
	}

	public MinStack() {
		pilha = new Stack<>();
	}

	public void push(int x) {
		pilha.push(x);
	}

	public void pop() {
		pilha.pop();
	}

	public int top() {
		return pilha.peek();
	}

	public int getMin() {
//		pilha.stream().filter()
		Integer min = pilha
			      .stream()
			      .mapToInt(v -> v)
			      .min().orElseThrow(NoSuchElementException::new);
		
		return min;
	}

}