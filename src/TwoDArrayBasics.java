import java.util.Arrays;

public class TwoDArrayBasics {

	public static void main(String[] args) {
		// Create a 3 x 5 array of ints
		int[][] twoD = new int[3][5];
		// Fill the array with random numbers using fillRandom
		fillRandom(1, 10, twoD);
		// test each method you create below.
		print2D(twoD);
		System.out.println(sumRow(twoD, 1));
		System.out.println(Arrays.toString(sumRowCreateArrayOfAllSums(twoD)));
		System.out.println(isUnique(twoD[0]));
		System.out.println(search(twoD[0], 5));
		System.out.println(min(twoD));
		System.out.println(max(twoD));
	}
	
	/*
	 * given the lower and upper bounds of the random numbers
	 * fill an array of random numbers 
	 */
	public static void fillRandom(int lower, int upper, int[][] arr) {
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				arr[i][j] = (int) (Math.random() * (upper - lower) + lower);
			}
		}
	}
	
	/*
	 * create a method that prints a 2D array
	 */
	public static void print2D(int[][] arr) {
		int max = Math.abs(max(arr));
		int maxLength = 0;
		while(max != 0) {
			++maxLength;
			max /= 10;
		}
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				System.out.printf("%" + (maxLength + 1) + "d", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * return the sum of a row (r) in a 2D array (arr)
	 */
	public static int sumRow(int[][] arr, int r) {
		int sum = 0;
		for(int i : arr[r - 1])
			sum += i;
		return sum;
	}
	
	/*
	 * return an array of row sums of a 2D array (nums)
	 */
	public static int[] sumRowCreateArrayOfAllSums(int[][] arr) {
		int[] sums = new int[arr.length];
		for(int i = 0; i < sums.length; ++i)
			sums[i] = sumRow(arr, i + 1);
		return sums;
	}
	
	/*
	 * check an 1D array for repeats, return true if all 
	 * elements of the array are unique
	 */
	public static boolean isUnique(int[] arr) {
		for(int i = 0; i < arr.length; ++i) {
			for(int j = i + 1; j < arr.length; ++j) {
				if(arr[i] == arr[j])
					return false;
			}
		}
		return true;
	}
	
	/*
	 * given an array
	 * return the index of the target value, 
	 * return -1 if it is not found
	 */
	public static int search(int[] arr, int target) {
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] == target)
				return i;
		}
		return -1;
	}
	
	/*
	 * return the min value in a 2D array
	 */
	public static int min(int[][] arr) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				if(arr[i][j] < min)
					min = arr[i][j];
			}
		}
		return min;
	}
	
	/*
	 * return the max value in a 2D array
	 */
	public static int max(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				if(arr[i][j] > max)
					max = arr[i][j];
			}
		}
		return max;
	}

}
