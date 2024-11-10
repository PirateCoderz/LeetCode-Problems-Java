package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains a method to convert a Roman numeral (as a string) into an integer.
 * 
 * Roman numeral rules for conversion:
 * - When a smaller numeral appears before a larger one, the smaller numeral is subtracted (e.g., IV = 4, IX = 9).
 * - When a smaller or equal numeral appears after a larger one, the numerals are added (e.g., VI = 6, XI = 11).
 * 
 * Approach:
 * - A map (rmap) is used to store the integer values corresponding to Roman numeral characters.
 * - We iterate through the string and for each character, retrieve its integer value from the map.
 * - If a smaller value is encountered before a larger value (i.e., when the current character's value is less than the next character's value), we subtract it from the result. Otherwise, we add it.
 * 
 * Time Complexity: O(n), where n is the length of the Roman numeral string.
 * Space Complexity: O(1), as the map is of constant size (7 entries for the Roman numeral characters).
 */
public class _3_RomanToInt {

    static Map<Character, Integer> rmap = new HashMap<>();

    static {
        rmap.put('I', 1);
        rmap.put('V', 5);
        rmap.put('X', 10);
        rmap.put('L', 50);
        rmap.put('C', 100);
        rmap.put('D', 500);
        rmap.put('M', 1000);
    }

    public int romanToInt(String s) {
        int num = 0;
        int len = s.length();

        // Loop through each character in the Roman numeral string
        for (int i = 0; i < len; i++) {
            // Get the current Roman numeral value from the map
            int cur = rmap.get(s.charAt(i));

            // If the current value is smaller than the next value, subtract it
            if (i < len - 1 && cur < rmap.get(s.charAt(i + 1))) {
                num -= cur;
            }
            // Otherwise, add the current value
            else {
                num += cur;
            }
        }

        return num;
    }

    public static void main(String[] args) {

        // Create an instance of the class and test the romanToInt method
        _3_RomanToInt sol = new _3_RomanToInt();
		
        String s = "MCMXCIV"; // Example Roman numeral
        System.out.println(sol.romanToInt(s)); // Output: 1994
    }
}
