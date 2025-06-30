package linkedlist;

public class Test {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        print(root);
        System.out.println();

        print(reverse(root));


    }

    public static void print (ListNode root){
        while (root != null){
            System.out.print(root.val + "->");
            root = root.next;
        }
    }

    public static ListNode reverse(ListNode node){
        ListNode current = node;
        ListNode  prev = null;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
