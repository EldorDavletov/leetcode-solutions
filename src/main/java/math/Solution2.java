package math;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main0(String[] args) {
        String number = "9";
        int a =  number.charAt(0)-'0';
        System.out.println(a);

        int b = '9' - '6';
        System.out.println(b);


        System.out.println(addStrings("0","10"));
        System.out.println(addStrings("124","101000000000"));
    }

    public static void main(String[] args) {
//        System.out.println(checkPerfectNumber(28));

//        System.out.println(addBinary("11","1"));
//        System.out.println(addBinary("1010","1011"));
//        System.out.println(addBinary("1111","1111"));

        System.out.println(dayOfYear("2004-03-01"));
        System.out.println(dayOfYear("1900-05-02"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);

            i--;
            j--;
        }

        return result.reverse().toString();
    }


    // Ikki nuqta orasidagi masofani hisoblovchi metod
    private double calculateDistance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }

    // Geron formulasi yordamida uchta tomon orqali uchburchak yuzasini hisoblovchi metod
    private double calculateArea(double a, double b, double c) {
        // Uchburchak tengsizliklarini tekshiramiz
        if (a + b > c && a + c > b && b + c > a) {
            double s = (a + b + c) / 2; // Yarim perimetr
            return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Geron formulasi
        } else {
            return 0; // Agar uchburchak tengsizliklari bajarilmasa, yuzani 0 deb qaytaramiz
        }
    }

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;

        // Uch nuqta kombinatsiyalari bo'yicha aylanamiz
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Uchburchakning tomonlarini hisoblaymiz
                    double a = calculateDistance(points[i], points[j]);
                    double b = calculateDistance(points[j], points[k]);
                    double c = calculateDistance(points[i], points[k]);

                    // Geron formulasi yordamida yuzani hisoblaymiz
                    double area = calculateArea(a, b, c);

                    // Eng katta yuzani saqlaymiz
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }


    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 3; i++) {
            if (num % i == 0) sum += i;
        }

        if (num % 2 == 0) {
            sum += num / 2;
        }
        System.out.println(sum);
        return sum == num;
    }






    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry; // carry ni qo'shishni esdan chiqarmang

            result.append(sum % 2); // faqat 0 yoki 1 qiymatni qoldiramiz
            carry = sum / 2; // carry 1 bo'lsa, yuqoriga olib o'tamiz

            i--;
            j--;
        }

        return result.reverse().toString();
    }


    public static boolean divisorGame(int n) {
        return n%2==0;
    }

    public static int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        List<Integer> list = List.of(31,28,31,30,31,30,31,31,30,31,30,31);
        int result = 0;

        for (int i = 0; i < month - 1; i++) {
            if (i == 1 ){
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    result += 29;
                } else {
                    result += 28;
                }
            } else {
                result += list.get(i);
            }
        }
        result += day;

        return result;
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        // Eng kattadan boshlab uchliklarni tekshiramiz
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                // Eng katta uchburchak perimetrini topdik
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        // Agar hech qanday uchburchak hosil bo'lmasa, 0 qaytariladi
        return 0;
    }

//    public String gcdOfStrings(String str1, String str2) {
//
//    }


    public static boolean confusingNumber(int n) {
        String number = String.valueOf(n);
        if (number.contains("2") ||number.contains("3") ||number.contains("4") ||number.contains("5") ||number.contains("7")){
            return false;
        }
        int rotatedNum = 0;
        while (n>0){
            int rem = n%10;
            n=n/10;
            rotatedNum = rotatedNum *10 + getRotatedDigit(rem);
        }
        return !String.valueOf(rotatedNum).equals(number);
    }
    public static int getRotatedDigit(int digit){
        if (digit == 9) return 6;
        if (digit == 6) return 9;
        return digit;
    }
}
