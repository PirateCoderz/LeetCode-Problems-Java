package simple;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Two Sum
 * 
 * Given an array of integers and a target value, find the indices of the two numbers
 * that add up to the target. Each input will have exactly one solution, and the same
 * element cannot be used twice. The function should return the indices of the two
 * numbers in an array format.
 * 
 * Solution Approach:
 * 1. Use a HashMap to store each element and its index as we iterate through the array.
 * 2. For each element (current value `cur`), compute the required complement value `x`
 *    that would add up to the target with `cur`.
 * 3. If `x` is found in the HashMap, return the current index `i` and the stored index of `x`
 *    as the result.
 * 4. If `x` is not in the HashMap, store the current element and its index in the HashMap.
 * 
 * This solution has an optimal time complexity of O(n), where n is the number of elements in the array.
 */


public class One_TwoSum {
	
	static int[] twoSum (int[] a, int target) {

        Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < a.length; i++) {
            int cur = a[i];
            int x = target - cur;
            System.out.println("Value i = " + i);
			if(map.containsKey(x)) {
				System.out.println("Value i = " + i + " && Value j = " + map.get(x));
				return new int[] {i, map.get(x)};
			}
			 map.put(cur, i);
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 5, 6, 7, 9, 12};
		int target = 9;
		int[] result = twoSum(arr, target);
	}

	
	
	
	
	/*
	static int[] twoSum (int[] a, int target) {
		int length = a.length-1;
		for(int i = 0; i < length; i++) {
			for(int j = i+1; j <= length; j++) {
				if(a[i]+ a[j] == target) {
					System.out.println("i = " + i + ", j = " + j);
					return new int[]{i, j};
				}
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 5, 6, 7, 9, 12};
		int target = 9;
		int[] result = twoSum(arr, target);
		
	}
	
	*/
}
