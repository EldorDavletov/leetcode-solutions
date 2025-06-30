package recursion;

import linkedlist.ListNode;

public class Solutions {
    public static void main(String[] args) {

        System.out.println(myPow(0.44528,0));

    }


    public static double myPow(double x, int n) {
        // n qiymatini long ga aylantiramiz xatolikni oldini olish uchun
        long N = n;
        if (N == 0) {
            return 1;
        }
        // Agar n manfiy bo'lsa
        if (N < 0) {
            x = 1 / x;
            N = -N;  // Long turidagi N ni musbatga aylantiramiz
        }
        // Rekursiv hisoblaymiz
        double half = myPow(x, (int)(N / 2));

        // Juft yoki toqligini tekshiramiz
        if (N % 2 == 0) {
            return half * half; // Juft bo'lsa
        } else {
            return half * half * x; // Toq bo'lsa
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }


}
