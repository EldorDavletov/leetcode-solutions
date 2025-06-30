package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestValue {
    public static void main(String[] args) {
        System.out.println(smallestNumber(310));
    }

    public static long smallestNumber(long num) {

        StringBuilder sb = new StringBuilder();
        if (num < 0){
            num = num * -1;
            char[] digits = String.valueOf(num).toCharArray();
            Arrays.sort(digits);
            for (int i = digits.length-1; i >= 0; i--) {
                sb.append(digits[i]);
            }
            return -1 * Long.parseLong(sb.toString());

        }else {
            char[] digits = String.valueOf(num).toCharArray();
            Arrays.sort(digits);
            StringBuilder zeros = new StringBuilder();
            int firstIdx = 0;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] > '0'){
                   firstIdx = i;
                   break;
                }
            }
            sb.append(digits[firstIdx]);
            for (int i = 0; i < digits.length; i++) {
                if (i != firstIdx) sb.append(digits[i]);
            }
            return Long.parseLong(sb.toString());
        }
    }
}
