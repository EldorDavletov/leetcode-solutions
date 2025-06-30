package queue;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main0(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {1,1,0,1};
        System.out.println(countStudents(students,sandwiches));
        String num = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        BigInteger number = new BigInteger(num);
        System.out.println(number);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int count1 = 0;
        int count0 = 0;
        for (int student : students) {
            if (student == 1) {
                count1 += 1;
            } else {
                count0 += 1;
            }
        }
        for (int sandwich : sandwiches){
            if (sandwich ==1){
                if (count1 > 0){
                    count1--;
                }else {
                    break;
                }
            }
            if (sandwich == 0){
                if (count0>0){
                    count0--;
                }else {
                    break;
                }
            }
        }

        return count1 + count0;
    }

    public int countStudents1(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.offer(student);
        }

        int sandwichIndex = 0; // Sendvichlarni boshqarish
        int tries = 0; // Talabalar rad etgan urinishlar soni

        while (!studentQueue.isEmpty() && tries < studentQueue.size()) {
            if (studentQueue.peek() == sandwiches[sandwichIndex]) {
                // Talaba sendvichni yeydi
                studentQueue.poll();
                sandwichIndex++;
                tries = 0; // Urinishlarni qayta nolga o'rnatish
            } else {
                // Talaba sendvichni rad etadi, u navbat oxiriga qaytadi
                studentQueue.offer(studentQueue.poll());
                tries++;
            }
        }

        return studentQueue.size(); // Qolgan talabalar soni
    }

    public static void main(String[] args) {
        int[] tickets = {2,3,2};
        int[] tickets2 = {5};
        int[] tickets3 = {5,1,1,1};
        int[] tickets4 = {84,49,5,24,70,77,87,8};
        System.out.println(timeRequiredToBuy(tickets,2));
        System.out.println(timeRequiredToBuy(tickets2,0));
        System.out.println(timeRequiredToBuy(tickets3,0));
        System.out.println(timeRequiredToBuy(tickets4,3));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
//        Queue<Integer> queue = new LinkedList<>();
//        for (int ticket : tickets) {
//            queue.add(ticket);
//        }
//        int time = 0;
//        int personIndex = k;
//        while (!queue.isEmpty()){
//            time++;
//            int ticket = queue.poll() - 1;
//            if (ticket == 0 && personIndex == 0){
//                return time;
//            }
//            if (ticket > 0){
//                queue.offer(ticket);
//            }
//            if (personIndex == 0){
//                personIndex = queue.size()-1;
//            }else {
//                personIndex--;
//            }
//
//        }
//        return time;

        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            // Agar odam k indeksidagi odamdan oldin yoki teng bo'lsa
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            }
            // Agar odam k indeksidagi odamdan keyin bo'lsa
            else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }
}
