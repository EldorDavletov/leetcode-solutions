package greedy;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }

    public static int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        for (int i = 0; i < digits.length - 1; i++) {
            int max = digits[i], maxIdx = i;
            for (int j = i+1; j < digits.length; j++) {
                if (max <= digits[j]){
                    max = digits[j];
                    maxIdx = j;
                }
            }
            if (maxIdx != i && digits[i] != digits[maxIdx]){
                char tmp = digits[i];
                digits[i] = digits[maxIdx];
                digits[maxIdx] = tmp;
                break;
            }
        }
        StringBuilder number = new StringBuilder();
        for (char digit : digits) {
            number.append(digit);
        }
        return Integer.parseInt(number.toString());
    }
}
