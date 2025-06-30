package divide_and_concuer;

import linkedlist.ListNode;

public class SortLinkedList {
    public static void main(String[] args) {



        ListNode head = new ListNode(15);
        head.next = new ListNode(10);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(20);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println("Tartiblanmagan ro'yxat:");
        printList(head);

        head = sortList(head);

        System.out.println("Tartiblangan ro'yxat:");
        printList(head);

    }

    public static ListNode sortList(ListNode head) {
        printList(head);
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode nextMid = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextMid);


        printList(left);
        printList(right);
        return merge(left,right);
    }

    public static ListNode merge0(ListNode left,ListNode right){
        if (left==null) return right;
        if (right==null) return left;

        ListNode result;
        if (left.val<=right.val){
            result = left;
            result.next = merge(left.next,right);
        } else {
            result = right;
            result.next = merge(left,right.next);
        }

        return result;
    }
    public static ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Qolgan elementlarni birlashtirish
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;
    }

    public static ListNode getMiddle(ListNode head){
        if (head == null) return head;
        ListNode slow = head, fast = head;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Ro'yxatni chop etish
    public static void printList(ListNode head) {
//        ListNode temp = head;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
