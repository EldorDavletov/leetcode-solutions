package string;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s,i,i);
            count += expandAroundCenter(s,i,i+1);
        }

        return count;
    }

    public static int expandAroundCenter(String str, int left, int right){
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
