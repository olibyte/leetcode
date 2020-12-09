package interviewQuestions;

import java.util.Stack;

class MinStack {
    //2 stack solution
    /**
    Stack<Integer> myStack = new Stack<>();
    Stack<Integer> minVals = new Stack<>();
    // initialize your data structure here.
    public MinStack() {}
    
    public void push(int x) {
        if (minVals.isEmpty() || x <= minVals.peek()) {
            minVals.push(x);
        }
        myStack.push(x);
    }
    
    public void pop() {
        if (myStack.peek().equals(minVals.peek())) {
            minVals.pop();
        }
        myStack.pop();
    }
    
    public int top() {
        return myStack.peek();
    }
    
    public int getMin() {
        return minVals.peek();
    }*/
    //single stack solution - use an int instead to track minimum value.
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {}
    
    public void push(int x) {
        //only push old min when when minchanges after pushing new value
        if (x <= min) {
            stack.push(min);
            min =  x;
        }
        stack.push(x);
    }
    
    public void pop() {
        //if pop operation could result in changing current min
        //pop twice and change the current min to the last min
        if (stack.pop() == min) {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */