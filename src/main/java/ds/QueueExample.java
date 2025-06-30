package ds;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // LinkedList yordamida navbat
        Queue<Integer> linkedListQueue = new LinkedList<>();

        linkedListQueue.add(10);
        linkedListQueue.add(20);
        linkedListQueue.add(30);

        System.out.println("LinkedList Queue: " + linkedListQueue);
        System.out.println("Front Element (LinkedList): " + linkedListQueue.peek());
        linkedListQueue.poll();
        System.out.println("After Dequeue (LinkedList): " + linkedListQueue);

        // PriorityQueue yordamida navbat
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(30);

        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Front Element (PriorityQueue): " + priorityQueue.peek());
        priorityQueue.poll();
        System.out.println("After Dequeue (PriorityQueue): " + priorityQueue);
    }
}


