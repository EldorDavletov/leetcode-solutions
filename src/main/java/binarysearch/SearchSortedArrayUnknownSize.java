package binarysearch;

interface ArrayReader{
    public int get (int index);
}
public class SearchSortedArrayUnknownSize {
    public static void main(String[] args) {
        int numKnives;
        System.out.print("""
                "# forks = " + numForks +
                               " # knives = " + numKnives +
                               # cups = 0""");

    }

    public int search(ArrayReader reader, int target) {

        int left = 0, right = 10_000, mid, index = -1;
        while (left <= right){
            mid = (left + right)/2;
            int number = reader.get(mid);
            if (number == Integer.MAX_VALUE){
                right = mid - 1;
            } else {
                if (number == target) return mid;
                if (number > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

        }
        return index;
    }
}
