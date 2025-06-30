package ds;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Initial Stack: " + stack);


        // Ustki elementni ko'rish
        System.out.println("Top Element: " + stack.peek());


        // Ustki elementni o'chirish
        stack.pop();
        System.out.println("Stack After Pop: " + stack);

        // Stek bo'shmi yoki yo'qligini tekshirish
        System.out.println("Is Stack Empty? " + stack.isEmpty());
    }


}
