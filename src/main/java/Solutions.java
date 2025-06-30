import org.checkerframework.checker.units.qual.A;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Solutions {

    public static void main(String[] args) {

//        int [] arr = twoSum(new int[]{7,11,15,3,6},9);
//        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        System.out.println(list);

//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));

//        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
        System.out.println(numWaterBottles(15,4));

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        list.add(1);
        result.add(list);

        if (numRows==1) {
            System.out.println("result="+result);
            return result;
        }else {
            for (int i = 0; i < numRows-1; i++) {
                tmp = result.get(i);
                list = new ArrayList<>();
                list.add(1);
                for (int j = 0; j < tmp.size(); j++) {
                    if(j+1<tmp.size()){
                        list.add(tmp.get(j)+tmp.get(j+1));
                    }
                }
                list.add(1);
                result.add(list);
            }
        }
        System.out.println(result);
        return result;
    }

    public static List<Integer> getRow(int rowIndex){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> tmp;
        list.add(1);
        result.add(list);


        for (int i = 0; i < rowIndex; i++) {
            tmp = result.get(i);
            list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < tmp.size(); j++) {
                if (j + 1 < tmp.size()) {
                    list.add(tmp.get(j) + tmp.get(j + 1));
                }
            }
            list.add(1);
            result.add(list);
        }

//        System.out.println(result);
        return result.get(result.size()-1);
    }
    public static List<Integer> getRow0(int rowIndex) {

        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return List.of(1,1);
        List<Integer> list = new ArrayList<>();
        BigInteger rowFactorial = factorial(rowIndex);
        for (int i = 0; i <= rowIndex; i++) {
            BigInteger number = rowFactorial.divide(factorial(i).multiply(factorial(rowIndex-i)));
            list.add(number.intValue());
        }

        return list;
    }

    public static BigInteger factorial(int n){
        if (n==0) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorial(n-1)) ;
    }

    public void nextPermutation(int[] nums) {
        // Step 1: Find the pivot
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) { // If no such element is found, skip steps 2 and 3
            // Step 2: Find the successor
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap pivot and successor
            swap(nums, i, j);
        }

        // Step 4: Reverse the sub-array
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }






    public static int[] twoSum(int[] nums, int target) {
        // Har bir elementni va uning indeksini saqlash uchun HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // Massiv elementlari bo'ylab iteratsiya qilish
        for (int i = 0; i < nums.length; i++) {
            // Joriy elementning complement'ini topish
            int complement = target - nums[i];

            // Agar complement map'da mavjud bo'lsa, natijani qaytarish
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Joriy elementni va uning indeksini map'ga qo'shish
            map.put(nums[i], i);
        }

        // Agar hech qanday yechim topilmasa, xatolik chiqarish
        throw new IllegalArgumentException("No two sum solution");
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Arrayni tartiblash
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Bir xil elementlarni o'tkazib yuborish
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // HashMap ishlatib Two Sum yechish
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j])) {
                    result.add(Arrays.asList(nums[i], target - nums[j], nums[j]));

                    // Bir xil elementlarni o'tkazib yuborish
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                }
                map.put(nums[j], j);
            }
        }

        return result;
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }

        return closestSum;
    }

    public List<List<Integer>> threeSum0(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int remainder = 0;

        while (numBottles>=numExchange){
            remainder = numBottles%numExchange;
            numBottles = numBottles/numExchange;
            count = count + numBottles;
            numBottles = numBottles + remainder;
        }

        return count;
    }
}
