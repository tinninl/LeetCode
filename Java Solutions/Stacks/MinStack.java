import java.util.EmptyStackException;
import java.util.Stack;

/**
 * We can use the stack data structure to implement a minstack
 * We just need to track the minElement min
 * 
 * The main question is what happens when we pop min
 * How can we find the next min element?
 * Maybe we can have a secret stack to track min elements
 * 
 * Both stacks will always be the same size
 * minStack is a stack of the min element
 * 
 * ex:
 * stack =      18 19 21 15 16 (top)
 * minstack =   18 19 19 15 16
 * 
 * This solution requires two stacks, so more space, buts still O(1) time
 * 
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    /**
     * Each time we push a new element, we need to compare it to min
     * Unless the stack is empty
     */
    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty())
            minStack.push(val);

        else
            minStack.push(Math.min(val, minStack.peek()));

    }
    
    public void pop() {
        
        stack.pop();
        minStack.pop();
    }
    
    /**
     * The problem says top will never be called on an empty stack
     * But just in case, throw an exception
     */
    public int top() {

        if (stack.isEmpty())
            throw new EmptyStackException();

        return stack.peek();

    }
    
    public int getMin() {

        if (stack.isEmpty())
            throw new EmptyStackException();

        return minStack.peek();

    }
}
