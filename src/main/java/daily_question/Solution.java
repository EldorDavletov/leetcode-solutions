package daily_question;

import java.util.*;

public class Solution {

    public static void main0(String[] args) {
        String str1 = "My name is Haley";
        String str2 = "My Haley";

        System.out.println(areSentencesSimilar(str1,str2));
        String s1 = "ABFCACDB";
        String s2 = "ACBBD";
        System.out.println(minLength(s1));
        System.out.println(minLength(s2));

    }

    public static void main1(String[] args) {
        String str1 = "ababccc";
        String str2 = "aa";
        String str3 = "wwwzfvedwfvhsww";
//        System.out.println(maxUniqueSplit(str1));
//        System.out.println(maxUniqueSplit(str2));
        System.out.println(maxUniqueSplit(str3));

        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
        System.out.println(makeFancyString("aaa"));

        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
    }


    public static void main2(String[] args) {
//        System.out.println(rotateString("abcde","cdeab"));

        int[] code = {5,7,1,4};
        int[] code2 = {1,2,3,4};
        int[] code3 = {2,4,9,3};
        System.out.println(Arrays.toString(decrypt(code, 3)));
        System.out.println(Arrays.toString(decrypt(code2, 0)));
        System.out.println(Arrays.toString(decrypt(code3, -2)));
    }

    public static void main3(String[] args) {
        int[] nums = {1,1,1,2,3,3,5,6,6,6,6,6,9,9};
        int[] nums2 = {1,5,4,2,9,9,9};
        int[] nums3 = {4,4,4};
        int[] nums4 = {1,2,2};
//        System.out.println(maximumSubarraySum(nums,3));
//        System.out.println(maximumSubarraySum(nums2,3));
//        System.out.println(maximumSubarraySum(nums3,3));
//        System.out.println(maximumSubarraySum(nums4,2));

        System.out.println(maxSumSubarray(nums2,3));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Agar sentence1 uzunroq bo'lsa, joylarini almashtiramiz
        if (sentence1.length() < sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        // sentence1 uzunroq yoki teng
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0;
        // Boshlanishdan o'xshashligini tekshiramiz
        while (i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }

        int j = 0;
        // Oxiridan o'xshashligini tekshiramiz
        while (j < words2.length && words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }

        // Agar umumiy uzunlik kichikroq sentence uzunligiga teng bo'lsa, to'g'ri
        return i + j >= words2.length;
    }

    public static int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int len = sb.length();
            if (len >= 2 && (sb.substring(len - 2, len).equals("AB") || sb.substring(len - 2, len).equals("CD"))) {
                sb.delete(len - 2, len);
            }
        }

        return sb.length();

//        while (s.contains("AB") || s.contains("CD")){
//            s=s.replace("AB","").replace("CD","");
//        }
//        return s.length();
    }

    public static int maxUniqueSplit(String s) {
        return backtrack(s,0,new HashSet<>());
    }

    private static int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;  // Agar string oxiriga yetib kelsak, bu bo'linishni yakunlaymiz
        }

        int maxSplits = 0;
        StringBuilder currentSubstring = new StringBuilder();

        // Har bir harfni ketma-ket qo'shib, substring yaratamiz
        for (int i = start; i < s.length(); i++) {
            currentSubstring.append(s.charAt(i));
            String substring = currentSubstring.toString();

            // Agar substring oldin ko'rilmagan bo'lsa, to'plamga qo'shamiz
            if (!seen.contains(substring)) {
                seen.add(substring);

                // Rekursiya orqali qolgan string bo'laklarini sinab ko'ramiz
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, i + 1, seen));

                // Backtrack: Agar bu yo'l noto'g'ri bo'lsa, substringni olib tashlaymiz
                seen.remove(substring);
            }
        }

        return maxSplits;
    }


    public static String makeFancyString(String s) {

        StringBuilder builder = new StringBuilder(s);
        for (int i = 1; i <= builder.length()-2; i++) {
//            System.out.println(builder.charAt(i-1) +" " +builder.charAt(i)+" "+builder.charAt(i+1));
            if (builder.charAt(i)==builder.charAt(i-1) && builder.charAt(i)==builder.charAt(i+1)){
                builder.delete(i,i+1);
                i--;
            }
        }
        return builder.toString();
    }

    public String makeFancyString0(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        result.append(s.charAt(0));  // Birinchi belgini qo'shamiz

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            // Agar ketma-ket belgilarning soni 2 dan oshmasa, qo'shamiz
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        if (words.length==1){
            char start = words[0].charAt(0);
            char end = words[0].charAt(words[0].length()-1);
            return Math.abs(start-end)==0 || Math.abs(start-end)==32;
        }
        char letter = words[0].charAt(words[0].length()-1);
        for (int i = 1; i < words.length; i++) {
            char  a = words[i].charAt(0);
            if (letter-a==0 || Math.abs(letter-a)==32){
                letter =  words[i].charAt(words[i].length()-1);
            }else {
                return false;
            }
        }
        return words[0].charAt(0)==letter;
    }

    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)) return true;
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < builder.length(); i++) {
            char letter = builder.charAt(0);
            builder.delete(0,1).append(letter);
            if (builder.toString().equals(goal)){
                return true;
            }
        }
        return false;
    }

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] result = new int[len];
        if (k>0){
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = i+1; j <= i+k; j++) {
                    if(j>=len) {
                        sum += code[j-len];
                    }else {
                        sum += code[j];
                    }
                }
                result[i]=sum;
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = 1; j <= Math.abs(k); j++) {
                    if(i-j<0) {
                        sum += code[len-j+i];
                    }else {
                        sum += code[i-j];
                    }
                }
                result[i]=sum;
            }
        }

        return result;

    }


    public static long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < i+k; j++) {
                if (j<nums.length) {
                    if (!list.contains(nums[j])) {
                        list.add(nums[j]);
                    }
                }
            }
            if (list.size()==k) {
                max = Math.max(max, list.stream().mapToInt(Integer::intValue).sum());
            }
        }

        return max;
    }
    public static long maximumSubarraySum0(int[] nums, int k) {
        long maxSum = 0, currentSum = 0;
        Set<Integer> uniqueElements = new HashSet<>();

        int left = 0; // Sliding window boshlanishi
        for (int num : nums) {
            // Agar `nums[right]` element setda bo'lsa, unikal bo'lmasligi sababli
            // left ko'rsatkichni oldinga siljitamiz va elementlarni setdan o'chiramiz.
            while (uniqueElements.contains(num)) {
                uniqueElements.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Elementni setga qo'shamiz va yig'indiga qo'shamiz
            uniqueElements.add(num);
            currentSum += num;

            // Agar oyna hajmi `k` ga teng bo'lsa, natijani yangilaymiz
            if (uniqueElements.size() == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Eng chap elementni olib tashlab, oyna hajmini kichraytiramiz
                uniqueElements.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }


    public static double maxSumSubarray(int[] nums, int k) {
        int maxSum = nums[0], currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];  // Elementni oynaga qo'shish

            if (i >= k - 1) {  // Oyna uzunligi `k` ga yetdi
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[i - (k - 1)];  // Eski elementni chiqarish
            }
        }

        return (double) maxSum /k;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // Birinchi `k` elementning yig'indisini hisoblaymiz
        double maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        double currentSum = maxSum;

        // Sliding Window usuli yordamida har bir subarrayni hisoblaymiz
        for (int i = k; i < n; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        // Maksimal yig'indining o'rtacha qiymatini qaytaramiz
        return maxSum / k;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)){
                return i+1;
            }
        }

        return -1;
    }

    public static void main4(String[] args) {
        String str = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(addSpaces2(str,spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        int k = 0;
        for (int space : spaces) {
            s = s.substring(0, space + k) + " " + s.substring(space + k);
            k++;
        }
        return s;
    }

     public static String addSpaces2(String s, int[] spaces) {
        StringBuilder builder = new StringBuilder();
        int prev = 0;
         for (int space : spaces) {
             builder.append(s, prev, space);
             builder.append(s.substring(prev,space));
             builder.append(' ');
             prev = space;
         }
         builder.append(s,prev,s.length());
        return builder.toString();
    }


    public static void main(String[] args) {

//        int[] banned = {1,2,3,4,5,6,7};
//        System.out.println(maxCount(banned,8,1));


    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int sum = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if(!isAvailable(i,banned)){
                if (sum+i<=maxSum){
                    System.out.println(i);
                    sum += i;
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private static boolean isAvailable(int number, int[] arr){
        int left = 0, right = arr.length-1;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if (number==arr[mid]) return true;
            if (number>arr[mid]){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }

        return false;
    }



}
