package quickselect;

public class KthLargestInteger {
    public static void main(String[] args) {

    }

    public String kthLargestNumber(String[] nums, int k) {
        return quickSelect(nums,0, nums.length-1, nums.length - k);
    }
    private static String quickSelect(String[] nums, int left, int right, int k){
        if (left == right){
            return nums[left];
        }
        int pivotIndex = partition(nums,left,right);
        if (k == pivotIndex){
            return nums[pivotIndex];
        } else if (pivotIndex > k){
            return quickSelect(nums,left, pivotIndex - 1, k);
        }else {
            return quickSelect(nums,pivotIndex + 1, right, k);
        }
    }

    private static int partition(String[] nums, int left, int right){
        String pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (compare(nums[j], pivot) <= 0){
                swap(nums,i++,j);
            }
        }
        swap(nums,i,right);
        return i;
    }

    private static void swap (String[] nums, int i, int j){
        String tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int compare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        return a.compareTo(b);
    }
}
