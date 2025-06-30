package math;

public class NthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }

    public static int findNthDigit(int n) {
        int digitLen = 1;
        long count = 9;
        int start = 1;
        while (n > digitLen * count){
            n = (int) (n - (digitLen * count));
            digitLen++;
            count = count * 10;
            start = start * 10;
        }

        int number = start + (n-1) / digitLen;
        return String.valueOf(number).charAt((n - 1) % digitLen) - '0';
    }
}
