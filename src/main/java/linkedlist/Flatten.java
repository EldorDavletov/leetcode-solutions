package linkedlist;

import java.util.Stack;

public class Flatten {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node (int val){
            this.val = val;
        }
    };


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.prev = head.next.next.child;

        head.next.next.child.next.child = new Node(11);
        head.next.next.child.next.child.next = new Node(12);
        head.next.next.child.next.child.next.prev = head.next.next.child.next.child;

        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Flatten qilingan ro‘yxat:");
        Node result = flatten(head);
        printList(result);
    }
    // Ro‘yxatni chop etish uchun yordamchi metod
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static Node flatten(Node head) {
        if (head==null){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current!=null){
            if (current.child!=null){
                if (current.next!=null) {
                    stack.push(current.next);
                }
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }
            if (current.next == null && !stack.empty()){
                current.next = stack.pop();
                current.next.prev = current;
            }


            current = current.next;
        }

        return head;
    }
}



