package math;

import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main0(String[] args) {
        int[] digits = {1,2,3};
        int[] digits2 = {9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne(digits2)));

        System.out.println(addBinary("1","111"));

        System.out.println('0'-'0');
        System.out.println('1'-'0');

//        System.out.println('A' - 1);
//        char c = 64;
//        System.out.println(c);

//        System.out.println(convertToTitle(701));
//        System.out.println(convertToTitle(27));
//        System.out.println(convertToTitle(28));
//        System.out.println(convertToTitle(1));
//        System.out.println(convertToTitle(197));
//        System.out.println(convertToTitle(963));
//        System.out.println(convertToTitle(52));
//        System.out.println(convertToTitle(260));
//        System.out.println(convertToTitle(130));
//
//        System.out.println(charToNumber('A'));
//        System.out.println(charToNumber('Z'));

//        System.out.println(titleToNumber("AA"));
//        System.out.println(titleToNumber("AB"));
//        System.out.println(titleToNumber("ALM"));
//        System.out.println(titleToNumber("AKA"));

//        System.out.println(addDigits(38));
        System.out.println(isUgly(14));
    }


    public static void main(String[] args) {

//        System.out.println(toHex(26));
//        System.out.println(toHex(10));
//        System.out.println(toHex(9));
//        System.out.println(toHex(-1));

//        System.out.println(multiply("173","256"));
//        System.out.println(multiply("123","456"));
//        System.out.println(multiply("2","3"));
//        System.out.println(multiply("123456789","987654321"));

//        System.out.println(countPrimes(0));
//        System.out.println(countPrimes(2));
//        System.out.println(countPrimes(3));
//        System.out.println(countPrimes(5));
//        System.out.println(countPrimes(7));
        System.out.println(countPrimes(689171));
    }

    public static int[] plusOne(int[] digits) {
        int rem = 1;
        for (int i = digits.length-1; i >=0 ; i--) {
            int sum = digits[i] +rem;
            if (sum<10){
                digits[i]=sum;
                return digits;
            }else {
                rem = sum/10;
                digits[i] = sum%10;
            }
        }
        if (rem>0){
            int[] result = new int[digits.length+1];
            result[0]=rem;
            for (int i = 1; i < digits.length; i++) {
                result[i] = digits[i-1];
            }

            return result;
        }

        return digits;
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int len1 = a.length()-1;
        int len2 = b.length()-1;
        while (len1>=0 && len2>=0){
            int a1 = a.charAt(len1)=='0'?0:1;
            int b1 = b.charAt(len2)=='0'?0:1;
            int sum = a1 + b1 + carry;
            result.append(sum%2);
            carry = sum/2;
            len1--;
            len2--;
        }
        while (len1>=0 ){
            int a1 = a.charAt(len1)=='0'?0:1;
            int sum = a1 + carry;
            result.append(sum%2);
            carry = sum/2;
            len1--;
        }
        while (len2>=0 ){
            int b1 = b.charAt(len2)=='0'?0:1;
            int sum = b1 + carry;
            result.append(sum%2);
            carry = sum/2;
            len2--;
        }


        if (carry!=0) result.append(carry);
        return result.reverse().toString();
    }
    public static String addBinary2(String a,String b){
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);

        // Ikkita katta sonni qo'shamiz
        BigInteger sum = num1.add(num2);

        // Natijani yana ikkilik stringga o'girib qaytaramiz
        return sum.toString(2);
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int rem;
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            sum = 0;
            while (n > 0) {
                rem = n % 10;
                n = n / 10;
                sum += rem * rem;
            }
            n = sum;
        }
        return n == 1;
    }


    public static String convertToTitle(int columnNumber) {
        if (columnNumber<=26){
            return convertString( columnNumber);
        }
        StringBuilder result = new StringBuilder();
        int rem = 0;
        while (columnNumber>26){
            rem = columnNumber%26;
            if (rem == 0){
                result.append("Z");
                columnNumber--;
            }else {
                result.append(convertString(columnNumber % 26));
            }
            columnNumber = columnNumber/26;
        }
        if (columnNumber>0){
            result.append(convertString(columnNumber));
        }
        return result.reverse().toString();
    }

    public static String convertString(int number){
        return String.valueOf((char)('A' + number - 1));
    }


    public static int titleToNumber(String columnTitle) {
        if (columnTitle.length()==1){
            return columnTitle.charAt(0) -64;
        }
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            result = result*26+(c-64);
        }

        return result;
    }

    public static int charToNumber(char c){
        return c-64;
    }


    public static int addDigits(int num) {
        if (num<10){
            return num;
        }
        int result = 0;
        while (num>0){
            result+=num%10;
            num = num/10;
            if (num<1 && result>=10){
                num = result;
                result = 0;
            }
        }
        return result;
    }

    public static boolean isUgly(int n) {
        if (n <= 0) return false; // Musbat son bo'lishi kerak
        while (n % 2 == 0) n /= 2; // 2 ga bo'linadigan qismini olib tashlaymiz
        while (n % 3 == 0) n /= 3; // 3 ga bo'linadigan qismini olib tashlaymiz
        while (n % 5 == 0) n /= 5; // 5 ga bo'linadigan qismini olib tashlaymiz
        return n == 1; // Agar faqat 2, 3, 5 ga bo'linadigan bo'lsa, oxirida 1 qolishi kerak
    }


    public static String toHex(int num) {
        StringBuilder hex = new StringBuilder();

        if (num >= 0) {
            // Ijobiy sonlar uchun oddiy hex ga o'tkazish
            while (num > 0) {
                hex.append(numberToHex(num % 16));
                num = num / 16;
            }
        } else {
            // Manfiy sonlar uchun two's complement bilan ishlash
            String binary = toBinary(num);  // Manfiy sonni to'g'ridan-to'g'ri binary stringga o'tkazamiz
            hex.append(binaryToHex(binary)); // Binary ni hex ga o'zgartiramiz
            return hex.toString();
        }

        return hex.length() == 0 ? "0" : hex.reverse().toString(); // Hex ni qaytaramiz
    }

    public static String toBinary(int num) {
        if (num == 0) return "0";

        // Manfiy sonlar uchun avtomatik two's complement ishlaydi
        return String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0');
    }

    public static String binaryToHex(String binary) {
        int length = binary.length();
        int padding = (4 - (length % 4)) % 4; // 4-bit bloklar uchun padding nollar
        StringBuilder paddedBinary = new StringBuilder();

        for (int i = 0; i < padding; i++) {
            paddedBinary.append("0");
        }
        paddedBinary.append(binary);

        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < paddedBinary.length(); i += 4) {
            String fourBits = paddedBinary.substring(i, i + 4);
            hex.append(fourBitsToHex(fourBits)); // Binary 4-bit bloklarini hex ga o'zgartiramiz
        }

        return hex.toString();
    }

    public static char fourBitsToHex(String fourBits) {
        return switch (fourBits) {
            case "0000" -> '0';
            case "0001" -> '1';
            case "0010" -> '2';
            case "0011" -> '3';
            case "0100" -> '4';
            case "0101" -> '5';
            case "0110" -> '6';
            case "0111" -> '7';
            case "1000" -> '8';
            case "1001" -> '9';
            case "1010" -> 'a';
            case "1011" -> 'b';
            case "1100" -> 'c';
            case "1101" -> 'd';
            case "1110" -> 'e';
            case "1111" -> 'f';
            default -> throw new IllegalArgumentException("Noto'g'ri 4-bit binary: " + fourBits);
        };
    }

    public static String numberToHex(int num) {
        if (num < 10) return String.valueOf(num);
        return switch (num) {
            case 10 -> "a";
            case 11 -> "b";
            case 12 -> "c";
            case 13 -> "d";
            case 14 -> "e";
            default -> "f";
        };
    }



    public static String toBinaryNegative(int num) {
        // Agar son musbat bo'lsa, oddiy toBinary metodidan foydalanamiz
        if (num >= 0) {
            return toBinary(num);
        }

        // Manfiy son uchun, 32-bitli two's complement shaklini yaratamiz
        // num -2^31 bilan teng yoki undan kichik bo'lishi mumkin, shuning uchun biz
        // 32 bitli 2-lik sistemani olishimiz kerak.

        int bits = 32;
        char[] binary = new char[bits]; // 32 bitli char massiv

        // Two's complementni qo'llash
        for (int i = 0; i < bits; i++) {
            // Oxirgi bitni olish uchun (num & 1) ni ishlatamiz va uni binary massivga kiritamiz
            binary[bits - i - 1] = (num & 1) == 0 ? '0' : '1';
            num >>>= 1; // Raqamni unsigned shift (o'ngga surish) bilan bo'lamiz
        }

        return new String(binary);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = (1 + n)*n/2;
        int sum2 = 0;
        for (int num : nums) {
            sum2 += num;
        }

        return sum1 - sum2;
    }

    public static String multiply(String num1, String num2) {
        if(num1.length()>num2.length()) return multiply(num2,num1);
        StringBuilder result = new StringBuilder();
        StringBuilder row = new StringBuilder();
        result.append("0".repeat(Math.max(0, (num1.length() + num2.length()))));
        int carry,ind = 0;
        for (int i = num2.length() -1; i>=0;  i--) {
            int n1 = num1.charAt(i) - '0';  // Charni int ga aylantirish
            row.setLength(0);
            carry = 0;
            for (int j = num1.length() -1; j >= 0 ; j--) {
                int n2 = num2.charAt(j) - '0';  // Charni int ga aylantirish
                int multiple = n1 * n2;
                row.append((multiple%10 + carry)%10);
                carry = (multiple + carry)/10;
            }
            if (carry!=0) {
                row.append(carry);
                carry = 0;
            }
            int rowIndex = 0;


            for (int k = result.length()-1-ind; k >=0 ; k--) {
                if (rowIndex>row.length()-1){
                    if (carry>0){
                        result.replace(k,k+1, String.valueOf(carry));
                    }
                    break;
                }
                int x = result.charAt(k) - '0';
                int y = row.charAt(rowIndex) - '0';

                int sum = x + y + carry;
                result.replace(k,k+1,String.valueOf(sum%10));
                carry = sum/10;
                rowIndex++;
            }
            ind++;
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0); // 0-indeksdagi belgini o'chirib boradi
        }


        return result.toString();
    }

    public static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length()];

        // Raqamlarni ko'paytirish
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + result[i + j + 1];
                result[i + j + 1] = sum % 10; // Qoldiq, oxirgi raqam
                result[i + j] += sum / 10; // Carryni keyingi pozitsiyaga qo'shamiz
            }
        }

        // Natijani string ko'rinishga o'girish
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }



    public static int countPrimes(int n) {
        if(n<=2) return 0;
        int count = 0;
//        for (int i = 2; i < n; i++) {
//            boolean isPrime = true;
//            for (int j = 2; j <= Math.sqrt(i); j++) {
//                if (i%j==0){
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime) count++;
//        }

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
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

    public int countPrimesOrg(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // barcha sonlarni dastlab "prime" deb belgilaymiz

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // i ga bo'linadigan sonlarni chiqarib tashlaymiz
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

}
