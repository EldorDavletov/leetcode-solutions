package binarysearch;

interface ArrayReader2 {
    // Compares the sum of arr[l..r] with the sum of arr[x..y]
              // return 1 if sum(arr[l..r]) > sum(arr[x..y])
             // return 0 if sum(arr[l..r]) == sum(arr[x..y])
             // return -1 if sum(arr[l..r]) < sum(arr[x..y])
              public int compareSub(int l, int r, int x, int y);

              // Returns the length of the array
              public int length() ;
  }

public class FindIndex {
    public static void main(String[] args) {

    }

    public int getIndex(ArrayReader2 reader) {
        int left = 0, right = reader.length() - 1;


        while (left < right) {
            int size = right - left + 1;
            int mid = left + (right - left) / 2;

            if (size % 2 == 0) {
                int half = size / 2;
                int res = reader.compareSub(left, left + half - 1, mid + 1, mid + half);
                if (res == 0) return mid;
                else if (res == 1) right = mid;
                else left = mid + 1;
            } else {
                int half = size / 2;
                int res = reader.compareSub(left, left + half - 1, mid + 1, mid + half);
                if (res == 0) return mid;
                else if (res == 1) right = mid - 1;
                else left = mid + 1;
            }
        }
        return left;
    }
}
