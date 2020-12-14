package com.booking.algorithms;

public class RemoveDuplicatesSortedArrayInPlace {

	public static void main(String[] args) {
		new RemoveDuplicatesSortedArrayInPlace();
	}

	public RemoveDuplicatesSortedArrayInPlace() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		//int[] nums = { 1, 2, 2 };

		int len = removeDuplicates(nums);

		for (int i = 0; i < len; i++) {
			System.out.println(nums[i]);
		}
	}

	public int removeDuplicates(int[] nums) {
		int count = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[count]) {
				nums[++count] = nums[i];
			}
		}
		return count + 1;
	}

//	public int removeDuplicates(int[] nums) {
//		if (nums.length == 0)
//			return 0;
//		int i = 0;
//		for (int j = 1; j < nums.length; j++) {
//			if (nums[j] != nums[i]) {
//				i++;
//				nums[i] = nums[j];
//			}
//		}
//		return i + 1;
//	}

//	public int removeDuplicates(int[] nums) {
//        int preceding = nums[0];
//        int index = 1;
//        
//        for (int i = 1; i < nums.length; i++) {
//        	System.out.println("Nums[i] : " + nums[i] + " - index: " + index + " - i: " + i + " - preceding: " + preceding);
//            if (nums[i] != preceding) {
//                nums[index] = nums[i];
//                preceding = nums[i];
//                index++;
//            } 
//        }
//        System.out.println("Index returned: " + index);
//        return index;
//    }
}
