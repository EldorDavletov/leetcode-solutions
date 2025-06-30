package ds;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // LinkedList yaratish
        LinkedList<String> list = new LinkedList<>();

        // Elementlarni qo'shish
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Date");

        // Ro'yxatni chop etish
        System.out.println("Initial LinkedList: " + list);

        // Elementni olish
        String element = list.get(2);
        System.out.println("Element at index 2: " + element);

        // Elementni o'chirish
        list.remove(3);
        System.out.println("LinkedList after removal: " + list);

        // Ro'yxatning o'lchamini olish
        int size = list.size();
        System.out.println("Size of LinkedList: " + size);
    }
}

