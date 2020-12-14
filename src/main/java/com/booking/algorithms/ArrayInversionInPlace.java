package com.booking.algorithms;

public class ArrayInversionInPlace {

	public static void main(String[] args) {
		//new ArrayInversionInPlace();
		
		char[] str = {'H','e','l','l','o','w'};
//		reverseString(str);
		helper(str, 0, str.length -1);
		
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
	}
	
	public ArrayInversionInPlace() {
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		int len = reverseOrderInPlace(nums);

		for (int i = 0; i < len; i++) {
		    System.out.println(nums[i]);
		}
		
	}

	public static void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        helper(s, left, right);
    }
	
	public static void reverseString(char[] s) {
		char temp = 0;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length -1 - i] = temp;
        }
	}
	
	private int reverseOrderInPlace(int[] nums) {
		
		for (int i = 0; i <= Math.floor((nums.length - 2)/2); i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length -1 -i] = temp;
        }
		
		return nums.length;
	}

}
