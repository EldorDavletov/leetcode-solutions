package mock;

import java.util.HashSet;
import java.util.Set;

public class Solutions {
    public static void main(String[] args) {

    }

    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String bs = Integer.toBinaryString(i);
            if (!s.contains(bs)) return false;
        }

        return true;
    }

    public boolean queryString1(String s, int n) {
        Set<Integer> seen = new HashSet<>();

        int len = s.length();
        int maxLen = Integer.toBinaryString(n).length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') continue;

            int val = 0;
            for (int j = i; j < Math.min(i + maxLen, len); j++) {
                char ch = s.charAt(j);
                int bit = ch - '0';
                val = val * 2 + bit;

                if (val > n) break;
                if (val >= 1) seen.add(val);
            }

        }

        return seen.size() == n;
    }

}


