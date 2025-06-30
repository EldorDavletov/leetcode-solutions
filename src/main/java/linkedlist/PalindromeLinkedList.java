package linkedlist;

public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome0(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val);
            head = head.next;
        }
        if (sb.length()==1) return true;
        int left = 0, right = sb.length()-1;
        while (left<right){
            if (sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Compare both halves
        ListNode first = head, second = prev;
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

}
