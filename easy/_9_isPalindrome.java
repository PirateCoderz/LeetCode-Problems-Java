package easy;

/**
 * This class contains a method to check if a given integer is a palindrome.
 * 
 * A number is considered a palindrome if it reads the same forward and backward.
 * 
 * Approach:
 * - If the number is negative, return false immediately as negative numbers can't be palindromes.
 * - Store the original number and reverse the digits of the given number.
 * - Compare the original number with the reversed number. If they are the same, return true (it is a palindrome).
 * - If not, return false (it is not a palindrome).
 * 
 * Time Complexity: O(n), where n is the number of digits in the integer.
 * Space Complexity: O(1), since we are using a constant amount of extra space.
 */
public class _9_isPalindrome {

    public boolean isPalindrome(int x) {
        // Check if the number is negative
        if (x < 0) { 
            return false;
        }

        int a = x;  // Store the original number
        int rev = 0, rem, div;
        
        // Find the number of digits
        int length = String.valueOf(x).length();
       
        // Reverse the digits of the number
        for (int y = 0; y < length; y++) {
            rem = x % 10;  // Get the last digit
            div = x / 10;  // Remove the last digit
            rev = (rev * 10) + rem;  // Add the digit to the reversed number
            x = div;  // Update x by removing the last digit
        }
        
        // Compare the reversed number with the original number
        if(a == rev) {
            return true;  // It is a palindrome
        }
        return false;  // It is not a palindrome
    }

    public static void main (String[] args) {
        _9_isPalindrome s = new _9_isPalindrome();
        int x = -101;  // Test input
        
        // Check if the number is a palindrome
        boolean p = s.isPalindrome(x);
        System.out.println(p);  // Output: false, since -101 is not a palindrome
    }
}
