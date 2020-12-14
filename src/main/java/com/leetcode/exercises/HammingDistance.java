package com.leetcode.exercises;

public class HammingDistance {

	public static void main(String[] args) {
		new HammingDistance();
	}

	public HammingDistance() {
		System.out.println(hammingDistance(1, 3));
	}

	public int hammingDistance(int x, int y) {
        int res = 0;
        for (int i=0; i<32; i++) {
            int j = ((x >> i) & 1) ^ ((y >> i) & 1);
            if (j == 1) {
                res ++;
            }
        }
        
        return res;
    }
	
	//Aplicar fibonacci
	public int hammingDistanceFibo(int x, int y) {

		if (x == y)
			return 0;

		int fibX = 0;
		int fibY = 0;
		int count = 1;
		for (int i = 0; i <= x; i++) {
			count += i;
			++fibX;
			++fibY;
			if (x == count) {
				break;
			}
		}

		count = 1;
		for (int i = fibX; i <= y; i++) {
			++fibY;
			if (y == (count + i)) {
				break;
			}
			count += i;
		}

		return fibY - fibX;
	}
}
