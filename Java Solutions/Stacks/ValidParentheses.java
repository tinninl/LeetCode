import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 
 * Easy
 * 
 * ( ) { } [ ]
 */
public class ValidParentheses {

    /**
     * Suppose our string looked like [ ...]
     * We need a data structure to compare the first and last brackets together
     * 
     * Should we push opening or closing brackets?
     * We know that if the first element is a closing bracket, then
     * the string is invalid, so we can push opening brackets
     * 
     * If we see a closing bracket, then the top of the stack MUST be the 
     * matching opening bracket. then we can pop the stack
     */

    public boolean isValid(String s){

        if (s.length() % 2 != 0)
            return false;

        if (s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();

        // Create a lookup table for bracket pairs
        // key = closing bracket, value = opening bracket
        HashMap<Character,Character> map = new HashMap<>(3);
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for (int i = 0; i < s.length(); i++){

            Character bracket = s.charAt(i);

            // Is c a closing bracket?
            if (map.containsKey(bracket)){

                // The top of the stack should have the matching opening bracket           
                if (!stack.isEmpty() && map.get(bracket).equals(stack.peek()))
                    stack.pop();               
                
                else    // Or else the string is invalid
                    return false;

            }

            // Push opening brackets to the stack
            else    
                stack.push(bracket);

        }
        
        // If the string is valid, then we should have popped every opening bracket
        return stack.isEmpty();
        
    }
    
}
