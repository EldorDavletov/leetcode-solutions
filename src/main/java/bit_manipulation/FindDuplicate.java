package bit_manipulation;

public class FindDuplicate {
    public static void main(String[] args) {
        int num = 0;
        int[] nums = new int[]{5,1,4,3,3};
        for(int n : nums){
            num = num ^ n;
        }
        System.out.println(num);
    }


    public int findDuplicate(int[] nums) {
        return 0;
    }
}
