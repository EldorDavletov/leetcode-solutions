package kadane;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,-4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i],min * nums[i]);
            result = Math.max(result, max);
        }

        return result;
    }
    public static int maxProduct2(int[] nums) {
        int result = nums[0]; // Hozirgacha topilgan eng katta ko‘paytma
        int maxProduct = nums[0]; // Hozirgacha davom etgan eng katta ko‘paytma
        int minProduct = nums[0]; // Hozirgacha davom etgan eng kichik ko‘paytma

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i]; // Hozirgi elementni olish

            int newMax = Math.max(current, Math.max(maxProduct * current, minProduct * current));
            int newMin = Math.min(current, Math.min(maxProduct * current, minProduct * current));

            maxProduct = newMax;
            minProduct = newMin;

            result = Math.max(result, maxProduct);
        }

        return result;
    }

}
