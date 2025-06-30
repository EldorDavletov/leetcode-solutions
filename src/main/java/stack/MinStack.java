package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int val = mainStack.pop();
        if (val==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
