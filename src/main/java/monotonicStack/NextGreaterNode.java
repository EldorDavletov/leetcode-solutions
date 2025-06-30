package monotonicStack;

import linkedlist.ListNode;

import java.util.*;

public class NextGreaterNode {
    public static void main(String[] args) {

    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        int[] result = new int[vals.size()];
        Deque<Integer> stack = new ArrayDeque<>(); // Stack for indexes

        for (int i = 0; i < vals.size(); i++) {
            while (!stack.isEmpty() && vals.get(i) > vals.get(stack.peek())) {
                result[stack.pop()] = vals.get(i);
            }
            stack.push(i);
        }

        return result;
    }
}
