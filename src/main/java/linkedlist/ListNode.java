package linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode (){}
    public ListNode (int val){
        this.val = val;
    }
    public ListNode (int val,ListNode next){
        this.val = val;
        this.next = next;
    }

}

class Solutions{

    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);

       printList(reverseBetween(head,2,4));





//        System.out.println("Original list:");
//        printList(head);
//
//
//
//        System.out.println("List after changing:");
//        reorderList(head);
//        printList(head);

    }
    // Metod ro'yxatni yaratish uchun
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }

    // Metod ro'yxatni chop etish uchun
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static boolean isPalindrome0(ListNode head){
        ListNode start = head;
        ListNode temp = head;
        ListNode second = null;
        int  len = 0;
        while (temp!=null){
            temp = temp.next;
            len++;
        }
        System.out.println("length = "+len);
        temp = head;
        int ind = 0;
        if (len%2==0) {
            while (temp != null) {
                temp = temp.next;
                ind++;
                if (ind > len / 2 + 1) {
                    second = temp;
                }
            }
        } else {
            while (temp != null) {
                temp = temp.next;
                ind++;
                if (ind > len / 2 + 1) {
                    second = temp;
                }
            }
        }
         ListNode end = reverseList(second);

         ind = 0;
         while (ind<=len/2){
             if (start.val!=end.val) return false;
             start = start.next;
             end = end.next;
             ind++;
         }




        return true;
    }

    public int getDecimalValue(ListNode head) {

        double decimalValue = 0;
        ListNode reversed = reverseList(head);
        int i =0;
        while (reversed!=null){
            decimalValue = decimalValue + reversed.val *Math.pow(2,i);
            i++;
            reversed = reversed.next;
        }

        return (int) decimalValue;
    }

    public boolean isPalindrome (ListNode head){
        if (head == null || head.next == null) return true;
        ListNode start = head;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while (start!=null){
            str1.append(start.val);
            start = start.next;
        }
        ListNode end = reverseList(head);

        while (end!=null){
            str2.append(end.val);
            end = end.next;
        }

        if (str1==str2) return true;
        else return false;

    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // Oldingi uzel boshida null
        ListNode current = head; // Hozirgi uzel bosh uzel sifatida boshlanadi

        while (current != null) {
            ListNode next = current.next; // Keyingi uzilni vaqtinchalik saqlab qoyamiz
            current.next = prev; // Hozirgi uzelning keyingi uzilga ishorasini oldingi uzilga o'zgartiramiz
            printList(current);
            prev = current; // Endi oldingi uzel sifatida hozirgi uzilni saqlab qoyamiz
            current = next; // Keyingi iteratsiya uchun hozirgi uzilni yangilaymiz
        }

        return prev; // prev endi yangi bosh uzel bo'ladi
    }


    public static ListNode reverse2(ListNode node){
        if (node==null || node.next == null) return node;

        ListNode prev = null;
        ListNode current = node;
        while (node!=null){
            current.next = node;
            node = node.next;
        }
        printList(prev);
        return prev;
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        Set<Integer> list = new HashSet<>();
        list.add(current.val);

        while (current.next != null){
            if (list.contains(current.next.val)){
                current.next = current.next.next;
            }else {
                list.add(current.next.val);
                current = current.next;
            }
        }


        return head;
    }

    public static ListNode deleteDuplicates0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode prev = null; // Oldingi node'ni saqlab turish uchun o'zgaruvchi

        while (current != null) {
            if (seen.contains(current.val)) {
                // Agar qiymat allaqachon ko'rilgan bo'lsa, oldingi node'ning next ko'rsatkichini o'tkazib yuborish orqali o'chirish
                prev.next = current.next;
            } else {
                // Agar yangi qiymat bo'lsa, uni to'plamga qo'shish
                seen.add(current.val);
                prev = current; // Oldingi node'ni yangilash
            }
            current = current.next; // Current'ni keyingi node'ga o'tkazish
        }

        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;


        while (current != null){
            if (seen.contains(current.val)){
                duplicates.add(current.val);
                prev.next = current.next;
            } else {
                seen.add(current.val);
                prev = current;
            }

            current = current.next;
        }
        current = head;
        ListNode result = null;
        while (current != null){
            if (!duplicates.contains(current.val)){
                result = insert(result,current.val);
            }
            current = current.next;
        }
        return result;
    }


    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode current = head;
        // Yangi ro'yxat boshini saqlab turish uchun o'zgaruvchi
        ListNode newHead = head.next;
        ListNode first;
        ListNode second;
        ListNode prevTail = null;

        while (current != null && current.next != null){
            first = current;
            second = current.next;

            first.next = second.next;
            second.next = first;

            // Oldingi juftlikning oxirini yangi juftlikning boshiga ulaymiz
            if (prevTail != null) {
                prevTail.next = second;
            }

            // Keyingi juftlik uchun tayyorgarlik
            prevTail = first;
            current = first.next;
        }

        return newHead;
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next==null || k==0) return head;

        ListNode lastNode = head;
        int countNodes = 1;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            countNodes++;
        }
        // k ni ro'yxat uzunligi bilan modul qilib qisqartirish
        k = k % countNodes;
        if (k==0) return head; // Agar k nol bo'lsa, ro'yxat o'zgarmaydi

        ListNode newLast = head;
        for (int i = 1; i < countNodes - k; i++) {
            newLast = newLast.next;
        }

        // Ro'yxatni aylantirish
        ListNode newHead = newLast.next;
        newLast.next = null; // Yangi ro'yxat oxiri
        lastNode.next = head; // Eski ro'yxat boshini yangi ro'yxat oxiriga ulash

        return newHead;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;

        ListNode result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            ListNode node = lists[i];
            result = mergeTwoLists(result,node);
        }

        return result;
    }


    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Ro'yxatning o'rtasini topish
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // Birinchi yarmini ikkinchi yarmidan ajratish

        ListNode left = head;
        ListNode right = reverseList(slow);

        while (right != null) {
            ListNode temp1 = left.next;
            ListNode temp2 = right.next;

            left.next = right;
            if (temp1 == null) {
                break;
            }
            right.next = temp1;

            left = temp1;
            right = temp2;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode current = head;
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        while (current!=null){
            if (current.val<x){
                if (lessHead == null){
                    lessHead = current;
                    lessTail = current;
                }else {
                    lessTail.next = current;
                    lessTail = current;
                }
            }else {
                if (greaterHead == null){
                    greaterHead = current;
                    greaterTail = current;
                }else {
                    greaterTail.next = current;
                    greaterTail = current;
                }
            }
            current = current.next;
        }
        if (lessHead == null) return greaterHead;
        lessTail.next = greaterHead;
        if (greaterTail.next!=null) greaterTail.next = null;

        return lessHead;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next==null || left ==right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Chap pozitsiyagacha yetib olish
        for (int i = 1; i < left; i++) {
            current = current.next;
        }

        ListNode subListHeadPrev = current;
        ListNode subListTail = current.next;

        System.out.println();

        // O'ng pozitsiyagacha yetib olish
        current = current.next;
        for (int i = left; i < right; i++) {
            current = current.next;
        }

        ListNode subListTailNext = current.next;
        current.next = null;

        ListNode reversed = reverseList(subListTail);

        

        subListHeadPrev.next = reversed;
        subListTail.next = subListTailNext;

        return dummy.next;

    }
}