package stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Asosiy stack: " + stack);
        sort(stack);
        System.out.println("Saralangan stack: " + stack);
    }

    public static void sort(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            while (!temp.isEmpty() && temp.peek()>current){
                stack.push(temp.pop());
            }
            temp.push(current);
        }

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
}
