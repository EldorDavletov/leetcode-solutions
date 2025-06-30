package ds;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();

        // Stekka elementlarni qo'shish
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Stekni chop etish
        System.out.println("Stack: " + stack);

        // Ustki elementni ko'rish
        System.out.println("Top Element: " + stack.peek());

        // Ustki elementni o'chirish
        stack.pop();
        System.out.println("Stack after pop: " + stack);
    }
}

