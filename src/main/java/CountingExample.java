import java.util.*;

public class CountingExample {
    public static void main(String[] args) {
//        int[] time = {30,20,150,100,40};
//        System.out.println(numPairsDivisibleBy60(time));


//        System.out.println(nthUglyNumber(10));

//        System.out.println(beautySum("kcgdnprqxcmpcavjzjgvgekzsvoejxwrdsidzitpzcegxrrrnayndadtqwqswuinzyhdewzzvukqbzobylcporryqpurrzzmidrjcgtfoeyycrsbpbinbzweirmlamaajudtaermybbopxknkwalbnowfsevnodehzdalgailizfvnenmfuatxieorjaybxilmjsslalgeecmsbqwdjntfoaizbpmxekrtesrguepsevaymfwetnddblkbrirhrxrxvrpnqtazyurmwmlxtxczsypiycedwdgyzelbyapgfmedpzbfjfmbtydaqnshncgciqhatuzzpjklomxxqkdvrcwpotadandkwkfnrgiugpxyfjzzwkfdlvytfufxpsdwgmrqzufghuyq"));

        int[] arr = {1,2,3,4,5,10,6,7,8,9};

        System.out.println(canArrange(arr,5));

    }

    public static int numPairsDivisibleBy60_(int[] time) {
        int countPairs = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int j : time) {
            int remain = j % 60;
            int complement = remain == 0 ? 0 : 60 - remain;
            countPairs += map.getOrDefault(complement, 0);
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }

        return countPairs;
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] remainderCount = new int[60];
        int count = 0;

        for (int t : time) {
            int remainder = t % 60;
            int complement = (remainder == 0) ? 0 : 60 - remainder;
            count += remainderCount[complement];
            remainderCount[remainder]++;
        }
        return count;
    }


    public static long countCompleteDayPairs(int[] hours) {
        int[] remainderCount = new int[24];
        long count = 0;
        for(int hour : hours){
            int remain = hour % 24;
            int complement = remain == 0? 0 : 24-remain;
            count += remainderCount[complement];
            remainderCount[remain]++;
        }
        return count;
    }


    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            dp[i] = nextUgly;

            if (nextUgly == dp[p2] * 2) p2++;
            if (nextUgly == dp[p3] * 3) p3++;
            if (nextUgly == dp[p5] * 5) p5++;
        }

        return dp[n - 1];
    }
    public static int nthUglyNumber0(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (list.size()<n){
            if (isUgly(i)){
                list.add(i);
            }
            i++;
        }
        return list.getLast();
    }
    public static boolean isUgly(int n){
        if (n<7) return true;
        while (n%2==0) n=n/2;
        while (n%3==0) n=n/3;
        while (n%5==0) n=n/5;
        return n == 1;
    }

    public static int beautySum0(String s) {
        if (s.length()<3) return 0;
        int sum = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i+2; j <= s.length(); j++) {
                String str = s.substring(i,j);
                if (str.length()>2) {
                    map.clear();
                    for(char c: str.toCharArray()){
                        map.put(c, map.getOrDefault(c,0)+1);
                    }
                    int max = Collections.max(map.values());
                    int min = Collections.min(map.values());
                    sum += (max-min);
                }
            }
        }
        return sum;
    }


    public static int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n ; j++) {
                char c = s.charAt(j);
                freq[c -'a']++;
                int maxFreq = 0, minFreq = Integer.MAX_VALUE;
                for (int f : freq){
                    if (f>0){
                        maxFreq = Math.max(maxFreq,f);
                        minFreq = Math.min(minFreq,f);
                    }
                }

                sum += (maxFreq -minFreq);
            }
        }
        return sum;
    }

    public static boolean canArrange(int[] arr, int k) {
        if (k == 1) return true;
        int n = arr.length;
        int[] remainder = new int[k];
        int count = 0;
        for(int num : arr){
//            int remain = num % k;
            int remain = ((num % k) + k ) % k;
            int complement = remain == 0? 0: k-remain;
            if (remainder[complement] > 0){
                count += remainder[complement];
                remainder[complement]--;
            }else {
                remainder[remain]++;
            }
        }
        return n/2 == count;
    }
}
