package string;

import java.time.Duration;

public class MakeThreeStringsEqual {
    public static void main(String[] args) {
        String s1 = "luso";
        String s2 = "lu";
        String s3 = "lu";
        System.out.println(findMinimumOperations(s1,s2,s3));

    }

    public static int findMinimumOperations(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int minLen = Math.min(Math.min(len1, len2), len3);
        int commonPrefixLen = 0;

        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                commonPrefixLen++;
            } else {
                break;
            }
        }

        if (commonPrefixLen == 0) return -1;

        return (len1 + len2 + len3) - (3 * commonPrefixLen);
    }
}
