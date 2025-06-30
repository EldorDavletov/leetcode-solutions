package linkedlist;

import stack.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA>lenB){
            while (lenA!=lenB){
                headA = headA.next;
                lenA--;
            }
        }
        if (lenB>lenA){
            while (lenA!=lenB){
                headB = headB.next;
                lenB--;
            }
        }

        while (headA != null && headB != null){
            if (headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private static int getLength(ListNode node){
        if (node==null) return 0;
        int len = 0;
        while (node != null){
            len++;
            node = node.next;
        }

        return len;
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                slow = head;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if (head.next == null){
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
            node.left = buildBST(head);
        }
        node.right = buildBST(slow.next);


        return node;
    }
    public static TreeNode buildBST(ListNode head){
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        TreeNode node = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
            node.left = buildBST(head);
        }
        node.right = buildBST(slow.next);


        return node;
    }
}
