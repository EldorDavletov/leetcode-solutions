package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReference {
    public static void main0(String[] args) {
        List<List<Integer>> list =  new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list.add(new ArrayList<>(list1));
        System.out.println(list);
        list1.add(5);
//        list1.clear();
        System.out.println(list);
    }

    public static void main(String[] args) {
//        System.out.println(isArmstrong(153));
        System.out.println(reverse(-2147483648));
    }

    public static boolean isArmstrong(int n) {
        int len = String.valueOf(n).length();
        int sum = 0;
        int num = n;
        while (num>0){
            int rem = num%10;
            sum += (int) Math.pow(rem,len);
            num /= 10;
        }
        System.out.println("sum = "+sum);
        return n == sum;
    }

    public static int reverse(int x) {
        if (x == 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) return 0;
        long num = Math.abs(x);
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.reverse();
        while (sb.length()>1 && sb.charAt(0) == '0'){
            sb.delete(0,1);
        }
        if (Long.parseLong(sb.toString())>Integer.MAX_VALUE) return 0;
        if(x < 0) {
            return -1 * Integer.parseInt(sb.toString());
        } else {
            return Integer.parseInt(sb.toString());
        }
    }
}
