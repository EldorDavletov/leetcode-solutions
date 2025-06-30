package two_pointer;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("eceec"));
    }

    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                if (helper(s,left,right-1) || helper(s,left+1,right)){
                    return true;
                }
                return false;
            }

        }
        return true;
    }

    public static boolean helper(String s,int left, int right){
        while (left<right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
