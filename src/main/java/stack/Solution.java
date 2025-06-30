package stack;

import com.google.common.io.CharStreams;

import java.util.*;

public class Solution {


    public static void main0(String[] args) {
//        System.out.println(clearDigits("cb34"));
//        System.out.println(clearDigits("abc"));

        System.out.println(removeKdigits("9994321",3));
        StringBuilder sb = new StringBuilder();
        sb.append("123456789");
        System.out.println(sb);
        sb.setLength(6);
        System.out.println(sb);

    }

    public static String clearDigits(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>=97 && s.charAt(i)<=122){
                characters.push(s.charAt(i));
            }else {
                characters.pop();
            }
        }

        while (!characters.empty()) {
            result.append(characters.pop());
        }


        return result.reverse().toString();
    }

    public static String removeDuplicates(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (characters.isEmpty()){
                characters.add(s.charAt(i));
            } else if (s.charAt(i)!=characters.peek()){
                characters.push(s.charAt(i));
            }else {
                characters.pop();
            }
        }
        StringBuilder result = new StringBuilder();
//        while (!characters.isEmpty()){
//            result.append(characters.pop());
//        }
        for (char c : characters) {
            result.append(c);
        }

//        return result.reverse().toString();
        return result.toString();
    }


    public static String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26]; // Har bir harfning oxirgi pozitsiyasi
        boolean[] seen = new boolean[26];   // Harflar stackda bor-yo'qligini tekshirish

        char[] chars = s.toCharArray();
        int n = chars.length;

        // Har bir harfning oxirgi uchrashgan pozitsiyasini hisoblaymiz
        for (int i = 0; i < n; i++) {
            lastOccurrence[chars[i] - 'a'] = i;
        }

        // Stackni StringBuilder bilan almashtiramiz
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = chars[i];
            int index = c - 'a';

            // Agar harf stackda bo'lsa, o'tkazib yuboramiz
            if (seen[index]) {
                continue;
            }

            // Stackning oxiridan elementlarni olib tashlaymiz
            while (stack.length() > 0 && c < stack.charAt(stack.length() - 1) &&
                    lastOccurrence[stack.charAt(stack.length() - 1) - 'a'] > i) {
                seen[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            // Harfni stackga qo'shamiz
            stack.append(c);
            seen[index] = true;
        }

        return stack.toString();
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        // Har bir raqamni ko'rib chiqish
        for (char digit : num.toCharArray()) {
            // Stack'dagi oxirgi elementni o'chirish kerak bo'lsa
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Qolgan raqamlarni o'chirish
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Natijani yig'ish
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        // Boshidagi 0 larni olib tashlash
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static String removeKdigits2(String num, int k) {
        // Bo'sh stackni yaratish
        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            // Stack oxiridagi raqamdan kichik raqam kirsa, o'chirish
            while (!stack.isEmpty() && k > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        // Qolgan raqamlarni o'chirish kerak bo'lsa
        stack.setLength(stack.length() - k);

        // Boshidagi 0'larni olib tashlash
        while (stack.length() > 1 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }

        return stack.isEmpty() ? "0" : stack.toString();
    }


    public static void main(String[] args) {
        System.out.println(calculate("321+21*60+50"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char lastOperator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (lastOperator) {
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNumber);
                        break;
                }
                lastOperator = c;
                currentNumber = 0;
            }
        }
        int result = 0;
        for (int num : stack) {
            result += num;
        }
        return result;
    }


}
