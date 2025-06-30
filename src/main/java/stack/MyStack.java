package stack;

import java.util.*;

public class MyStack {
    Deque<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.addFirst(x);
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(2);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
