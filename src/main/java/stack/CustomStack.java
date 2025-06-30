package stack;

import java.util.Stack;

public class CustomStack {
    Stack<Integer> stack;
    private int maxSize;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (stack.size()<maxSize){
            stack.push(x);
        }
    }

    public int pop() {
        if (stack.isEmpty()){
            return -1;
        }
        return stack.pop();
    }

    public void increment(int k, int val) {
        int min = Math.min(k,stack.size());
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()){
            temp.push(stack.pop());
        }

        for (int i = 0; i < min; i++) {
            stack.push(temp.pop()+val);
        }

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }

    }
}
