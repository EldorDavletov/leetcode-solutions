package two_pointer;

public class ValidPalindrome {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome(",."));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length()-1;
        while (left<right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){left++;}
            while (right>left && !Character.isLetterOrDigit(s.charAt(right))){right--;}
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
