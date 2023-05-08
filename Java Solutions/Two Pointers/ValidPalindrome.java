/**
 * 125. Valid Palindrome
 * 
 * Easy
 * 
 * consider white spaces, and uppercase letters
 * 
 * This problem gets a lot easier if its just lowercase letters
 * with no whitespaces, symbols, numbers, etc
 * 
 */
public class ValidPalindrome {
    
    /**
     * Solution: Two Pointers
     * Start at the left and right ends of the string and check that the 
     * characters match. Move the pointers until they meet at the middle.
     */
    public boolean isValidPalindrome(String s){

        int left = 0, right = s.length() - 1;

        while (left < right){

            // Skip empty spaces
            while (!Character.isLetterOrDigit(s.charAt(right)))
                right--;

            while (!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            
            // Do the letters match? (Convert them to lowercase first)
            // If they don't match, then the string is NOT a valid palidrome
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            
            left++;
            right--;     

        }

        return true;

    }
    
}
