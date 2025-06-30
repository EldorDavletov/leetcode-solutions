package binarysearch;

public class GuessSolution extends GuessGame{
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    public static int guessNumber(int n) {

        int left = 1, right = n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int number = guess(mid);
            if (number == 0) {
                return mid;
            }
            if (number == 1) {
                left = mid + 1;
            } else {

                right = mid - 1;
            }
        }
        return left;

    }
}
