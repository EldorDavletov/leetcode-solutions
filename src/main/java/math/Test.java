package math;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main0(String[] args) {

        int number = 123;
        int number2 = 123456;
        int number3 = 1234567;
        String str = String.format("%07d",number);
        String str2 = String.format("%07d",number2);
        String str3 = String.format("%07d",number3);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);

        int n = 27; // Sinov uchun qiymat

        // Vaqt o'lchashni boshlash
        long startTime = System.nanoTime();

        // Metodni chaqirish
        boolean result = isPowerOfThree(n);

        // Vaqt o'lchashni tugatish
        long endTime = System.nanoTime();

        // Olingan natija
        System.out.println("Result: " + result);

        // Bajarilish vaqtini hisoblash (nanosekundlarda)
        long duration = (endTime - startTime);
        long durationInMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + durationInMillis + " milliseconds");
        System.out.println("Execution time: " + duration + " nanoseconds");
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0 || n == -1) return false;
        if (n == 1) return true;
        long result = 1;
        boolean negative = n < 0;
        if (negative) n = -n;
        while (result < n){
            result = result *3;
            System.out.println("result = "+result);
        }
        return result==n;
    }


    public static void main1(String[] args) {
        System.out.println(computeArea( -3,  0,  3,  4,  0,  -1,  9,  2));
        System.out.println(computeArea(  -2,  -2,  2,  2,  -2,  -2,  2,  2));
        System.out.println(computeArea(  -2,  -2,  2,  2,  -1,  -1,  1,  1));
    }

    public static void main(String[] args) {
//        System.out.println(daysBetweenDates("2020-01-15","2019-12-31"));
//        System.out.println(daysBetweenDates("2019-06-29","2019-06-30"));

//        System.out.println(gcdOfStrings("ABCABC","ABC"));
//        System.out.println(gcdOfStrings("ABABAB","ABAB"));
//        System.out.println(gcdOfStrings("LEETCODE","CODE"));
//        System.out.println(gcdOfStrings("LEETCODE","CO"));

//        System.out.println(tribonacci(4));
//        System.out.println(tribonacci(25));

        int[] num = {2,1,5};

        System.out.println(addToArrayForm(num,806));

    }


    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = Math.abs(ax2-ax1) * Math.abs(ay2-ay1);
        int area2 = Math.abs(bx2-bx1) * Math.abs(by2-by1);
        int commonArea = 0;

        int left = Math.max(ax1,bx1);
        int right = Math.min(ax2,bx2);
        int bottom = Math.max(ay1, by1);
        int top = Math.min(ay2, by2);

        if (right>left && top>bottom){
            commonArea = (right-left) * (top-bottom);
        }

        return area1 + area2 - commonArea;
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        List<Integer> dayOfMonth = List.of(31,28,31,30,31,30,31,31,30,31,30,31);
        int totalDays = 0;
        // Yil boshi 1900-01-01 kuniga asoslangan hafta kuni
        for (int i = 1900; i < year; i++) {
            totalDays += isLeap(i) ? 366:365;
        }

        for (int i = 0; i < month-1; i++) {
            totalDays += dayOfMonth.get(i);
            if (i==1 && isLeap(year)){
                totalDays++;
            }
        }

        totalDays = totalDays + day - 1;

        return days[totalDays%7];
    }

    // kabisa yilini aniqlash
    public static boolean isLeap(int year){
        return (year%4 == 0 && year%100 != 0) || year%400==0;
    }


    public int maximumProduct(int[] nums) {

        int len = nums.length-1;
        Arrays.sort(nums);
        int max1, max2;
        max1 = nums[0] * nums[1] * nums[len];
        max2 = nums[len] * nums[len-1] * nums[len-2];

        return Math.max(max1,max2);
    }

    public static int daysBetweenDates(String date1, String date2) {
        int year1 = Integer.parseInt(date1.substring(0,4));
        int year2 = Integer.parseInt(date2.substring(0,4));
        int month1 = Integer.parseInt(date1.substring(5,7));
        int month2 = Integer.parseInt(date2.substring(5,7));
        int day1 = Integer.parseInt(date1.substring(8,10));
        int day2 = Integer.parseInt(date2.substring(8,10));

        int totalDays1 = getYearDays(year1,month1,day1);
        int totalDays2 = getYearDays(year2,month2,day2);

        return Math.abs(totalDays1-totalDays2);
    }



    public static int getYearDays(int year, int month, int day){
        int days = 0;
        List<Integer> dayOfMonth = List.of(0,31,28,31,30,31,30,31,31,30,31,30,31);
        for (int i = 1701; i < year; i++) {
            days += isLeap(i)? 366 :365;
        }
        for (int i = 1; i < month; i++) {
            days += dayOfMonth.get(i);
        }
        days += day;
        if (isLeap(year) && month > 2){
            days += 1;
        }
        return days;
    }

    public static int daysBetweenDates2(String date1Str, String date2Str) {
        // Sana formatini parse qilish
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date1Str, formatter);
        LocalDate date2 = LocalDate.parse(date2Str, formatter);

        // Sanalarni o'zaro tartibda tekshirish
        LocalDate startDate = date1.isBefore(date2) ? date1 : date2;
        LocalDate endDate = date1.isAfter(date2) ? date1 : date2;

        // Kunlar orasidagi farqni hisoblash
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        return (int) daysBetween;
    }



    public static String gcdOfStrings(String str1, String str2){
        if (str1.length() == str2.length() && !str1.equals(str2)){
            return "";
        }
        // Stringlarni qisqartirish davomida
        while (!str1.isEmpty() && !str2.isEmpty()) {
            if (str1.length() > str2.length()) {
                if (str1.startsWith(str2)) {
                    str1 = str1.substring(str2.length()); // Faqat boshida bo'lsa, qisqartiramiz
                } else {
                    return ""; // GCD yo'q
                }
            } else {
                if (str2.startsWith(str1)) {
                    str2 = str2.substring(str1.length()); // Faqat boshida bo'lsa, qisqartiramiz
                } else {
                    return ""; // GCD yo'q
                }
            }
        }

        // Agar biror string bo'sh bo'lsa, qolgan string GCD
        return str1.isEmpty() ? str2 : str1;
    }

    public static int[] constructRectangle(int area) {
        int[] result = new int[2];
        result[0] = area;
        result[1] = 1;

        int diff = area-1;
        for (int i = 1; i <=Math.sqrt(area) ; i++) {
            if (area%i==0){
                if (diff>Math.abs(area/i -i)){
                    diff = Math.abs(area/i -i);
                    result[0] = Math.max(i,area/i);
                    result[1] = Math.min(i,area/i);
                }
            }
        }
        return result;
    }

    public static int tribonacci(int n) {
        if (n==0) return 0;
        else if (n==1 || n==2){
            return 1;
        }
        int[] t = new int [n+1];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        for (int i = 3; i <= n; i++) {
            t[i] = t[i-1]+t[i-2]+t[i-3];
        }
        return t[n];
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        int len = num.length-1;
        List<Integer> result = new ArrayList<>();

        while (len>=0 || carry>0 || k>0){
            int sum = carry+k%10;
            if (len>=0){
                sum+=num[len];
            }
            result.add(sum%10);
            carry = sum/10;
            k=k/10;
            len--;
        }

        return  result.reversed();
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String binary = Integer.toBinaryString(i);
            int countOne = 0;
            for(char c: binary.toCharArray()){
                if (c == '1') countOne++;
            }
            if (isPrime(countOne)){
                count++;
            }
        }

        return count;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true; // 2 va 3 tub sonlar
        if (num % 2 == 0 || num % 3 == 0) return false; // 2 va 3 ga bo'linadiganlar

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }

        return true;
    }
}
