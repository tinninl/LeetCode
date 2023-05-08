import java.util.Stack;

/**
 * 150. 
 * 
 * stack calculator
 * 
 * input 2 1 + 3 *
 * 
 * output (2 + 1) * 3 = 9
 */
public class EvaluateReversePolishNotation {
    
    public int evalRPN(String[] tokens) {

        /**
         * If its a number, push it 
         * If its an op, pop twice, do math, and push the result
         * The final result should be the one and only element left in the stack
         */

        /**
         * Special case with divsion and subtraction, 
         * [13 5 /] should be read as 13 / 5 = 2, NOT 5 / 13 = 0
         */

        Stack<Integer> s = new Stack<>();

        int a, b;

        for (int i = 0; i < tokens.length; i++){

            switch(tokens[i]){

                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                
                case "-":
                    b = s.pop();
                    a = s.pop();
                    s.push(a - b);
                    break;

                case "*":
                    s.push(s.pop() * s.pop());
                    break;

                case "/":
                    b = s.pop();
                    a = s.pop();
                    s.push(a / b);
                    break;

                default:
                    s.push(Integer.parseInt(tokens[i]));
                    break;

            }

        }

        return s.pop();

    }

}
