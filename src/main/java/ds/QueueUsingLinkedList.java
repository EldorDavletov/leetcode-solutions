package ds;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Navbatga elementlarni qo'shish
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Navbatni chop etish
        System.out.println("Queue: " + queue);

        // Bosh elementni ko'rish
        System.out.println("Front Element: " + queue.peek());

        // Bosh elementni o'chirish
        queue.poll();
        System.out.println("Queue after dequeue: " + queue);
    }
}

