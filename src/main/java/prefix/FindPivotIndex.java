package prefix;

public class FindPivotIndex {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int totalSum = prefix[n];

        for (int i = 0; i < n; i++) {
            int leftSum = prefix[i];
            int rightSum = totalSum - prefix[i + 1];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

}
