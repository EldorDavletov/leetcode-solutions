package string;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc","abc"));
        System.out.println(removeOccurrences("axxxxyyyyb","xy"));
    }
    public static String removeOccurrences0(String s, String part) {
        while (s.contains(part)){
            s = s.replaceFirst(part,"");
        }
        return s;
    }
    public static String removeOccurrences(String s, String part) {
        if (s.length()<part.length()) return s;
        int partLen = part.length();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            sb.append(c);
            if (sb.length()>=partLen && sb.substring(sb.length()-partLen,sb.length()).equals(part)){
                sb.delete(sb.length()-partLen,sb.length());
            }
        }
        return sb.toString();
    }


}
