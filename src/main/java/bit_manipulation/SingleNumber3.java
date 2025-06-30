package bit_manipulation;

import java.util.*;

public class SingleNumber3 {
    public static void main(String[] args) {
        int[] nums = {7,3,5,3,7,10};
        int[] nums2 = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums2)));
        List list = new ArrayList();
        list.add("val1"); //1
        list.add(2, "val2"); //2
        list.add(1, "val3"); //3
        System.out.println(list);
    }
    public static int[] singleNumber(int[] nums){
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        System.out.println("xor = "+xor + "  "+Integer.toBinaryString(xor));
        int[] result = new int[2];
        int diff = xor & -xor;
        System.out.println("diff = "+ diff+ "  "+Integer.toBinaryString(diff));

        for(int num : nums){
            if ((num & diff) == 0){
                result[0] ^= num;
            }else {
                result[1] ^= num;
            }
        }


        return result;
    }

    public static int[] singleNumber0(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(seen.contains(num)){
                seen.remove(num);
            }else {
                seen.add(num);
            }
        }
        return seen.stream().mapToInt(Integer::intValue).toArray();
    }



}
