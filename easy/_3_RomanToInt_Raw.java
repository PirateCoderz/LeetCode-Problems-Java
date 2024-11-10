package easy;

/**
 * This class contains a method to convert a Roman numeral (as a string) into an integer.
 * The Roman numeral is processed by iterating through the string (or its reversed version) from right to left.
 * 
 * Roman numeral rules for conversion:
 * - When a smaller numeral appears before a larger one, the smaller numeral is subtracted (e.g., IV = 4, IX = 9).
 * - When a smaller or equal numeral appears after a larger one, the numerals are added (e.g., VI = 6, XI = 11).
 * 
 * Approach:
 * - The input string is reversed to make it easier to apply the Roman numeral subtraction rule.
 * - We iterate through the string and check the corresponding integer value for each Roman character.
 * - If a smaller value is encountered before a larger value (as we go from right to left), we subtract it.
 * - Otherwise, we add it.
 * 
 * Time Complexity: O(n), where n is the length of the Roman numeral string.
 * Space Complexity: O(n) due to the extra array used for reversing the string.
 */
class _3_RomanToInt_Raw {
    public int romanToInt(String s) {
        int temp = 0, num = 0, t = 0;

        // Convert the Roman numeral string to a character array for easier processing
        char[] c = s.toCharArray();
        int length = c.length;
        int j = length;

        // Reverse the character array for processing from right to left
        char[] rev = new char[length];
        for (int i = 0; i < length; i++) {
            rev[j - 1] = c[i];
            j--;
        }

        // Print reversed array for debugging
        System.out.println(rev);

        /** 
         * The logic for Roman numerals works by checking if a smaller number
         * appears before a larger number, in which case it needs to be subtracted.
         * The reverse iteration helps simplify this by processing the characters
         * from right to left.
         */
        for (int i = length - 1; i >= 0; i--) {
            char a = c[i]; // Current character
            switch (a) {
                case 'I': temp = 1; break;
                case 'V': temp = 5; break;
                case 'X': temp = 10; break;
                case 'L': temp = 50; break;
                case 'C': temp = 100; break;
                case 'D': temp = 500; break;
                case 'M': temp = 1000; break;
                default:
                    System.out.println("Your Roman Number is not Correct.\n Put Correct Roman Number");
                    break;
            }

            // If the current value is less than the previous value, subtract it
            boolean con = t > temp && t != 0;

            // Update the previous value to the current value for next comparison
            t = temp;

            // Add or subtract the current value based on comparison
            if (con) {
                num -= temp; // Subtract if smaller value is on the left
            } else {
                num += temp; // Add if larger or equal value is on the left
            }
        }

        // Return the final result
        return num;
    }

    public static void main(String[] args) {
        // Create an instance of the class and test the romanToInt method
        _3_RomanToInt_Raw sol = new _3_RomanToInt_Raw();
        String s = "MCMXCIV"; // Example Roman numeral
        System.out.println(sol.romanToInt(s)); // Output: 1994
    }
}
