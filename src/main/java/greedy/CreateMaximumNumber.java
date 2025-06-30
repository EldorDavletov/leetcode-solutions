package greedy;

import java.util.Arrays;

public class CreateMaximumNumber {
    public static void main(String[] args) {
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};

//        CreateMaximumNumber obj = new CreateMaximumNumber();
//        System.out.println(Arrays.toString(obj.maxNumber(nums1, nums2, 5)));

        System.out.println(minimumOperations("224510471326"));
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[k];

        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] seq1 = pickMax(nums1, i);
            int[] seq2 = pickMax(nums2, k - i);
            int[] candidate = merge(seq1, seq2);

            if (isGreater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }

        return result;
    }

    // Step 1: pick max subsequence of length k using monotonic stack
    private int[] pickMax(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int drop = nums.length - k;

        for (int num : nums) {
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                drop--; // even if we don’t push, we consume one "drop"
            }
        }

        return stack;
    }

    // Step 2: merge two sequences to form the max one
    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, r = 0;

        while (i < n || j < m) {
            if (isGreater(nums1, i, nums2, j)) {
                merged[r++] = nums1[i++];
            } else {
                merged[r++] = nums2[j++];
            }
        }

        return merged;
    }

    // Step 3: lexicographic comparison starting from i and j
    private boolean isGreater(int[] a, int i, int[] b, int j) {
        int n = a.length, m = b.length;
        while (i < n && j < m) {
            if (a[i] != b[j]) return a[i] > b[j];
            i++;
            j++;
        }
        return (n - i) > (m - j);
    }

    public static int minimumOperations(String num) {
        int n = num.length() ;
        boolean found0 = false;
        boolean found5 = false;

        for(int i=n-1 ; i>=0 ; i--) {
            if((num.charAt(i) == '0' || num.charAt(i) == '5') && found0) return n-2-i;
            if((num.charAt(i) == '2' || num.charAt(i)=='7') && found5) return n-2-i;

            if(num.charAt(i)=='0')  found0 = true;
            if(num.charAt(i)=='5')  found5 = true;
        }

        if(found0) return n-1 ;

        return n ;
    }

    public void wiggleSort(int[] nums) {
        int[] nums1 = nums.clone();
        Arrays.sort(nums1);
        int no = (int) Math.ceil(nums.length/2.0) ;

        int n = nums.length;
        int left = no - 1;
        int right = n - 1;
        int j = 0;

        while (j < n) {
            nums[j++] = nums1[left--];
            if (j < n) nums[j++] = nums1[right--];
        }
    }
}
