package string;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main0(String[] args) {
//        String s = "abc", t = "ahbgdc";
//        System.out.println(isSubsequence(s,t));
        System.out.println(canMakeSubsequence("abc","ad"));
        System.out.println(canMakeSubsequence("zc","ad"));
        System.out.println(canMakeSubsequence("ab","d"));
    }

    public static boolean isSubsequence(String s, String t) {
        int len = s.length();
        if (len==0) return true;
        int k = 0;

        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(k) == t.charAt(j)) {
                k++;
            }
            if (k==len) return true;
        }
        return false;
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        int len = str2.length();
        if (len==0) return true;
        int k = 0;

        for (int j = 0; j < str1.length(); j++) {
            if (str1.charAt(j) == str2.charAt(k) || getCyclicLetter(str1.charAt(j)) == str2.charAt(k)) {
                k++;
            }
            if (k==len) return true;
        }
        return false;
    }
    private static char getCyclicLetter(char c){
        if (c=='z') return 'a';
        else return ++c;
    }


    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c','a'};
        System.out.println(compress(chars));

        String post = "00107";
        int number = 123;
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String declNumber = String.format("%s/%s/%07d", post, localDate.format(formatter), number);
        System.out.println(declNumber);
    }

    public static int compress(char[] chars) {
        System.out.println(chars);
        int index = 0;
        int i = 0;
        while (i<chars.length){
            char current = chars[i];
            int count = 0;
            while (i<chars.length && current == chars[i]){
                i++;
                count++;
            }
            chars[index++] = current;
            if (count>1){
                for (char c: String.valueOf(count).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        System.out.println(chars);

        return index;
    }
}
