package two_pointer;

public class ReverseWords2 {
    public static void main(String[] args) {
        char[] s = {'t','h','e',' ' ,'s','k','y',' ','i','s',' ','b','l','u','e'};

        reverseWords(s);

        System.out.println(s);
    }

    public static void reverseWords(char[] s) {
        int left = 0, right = s.length - 1;
        while (left<right){
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
        for (left = 0,right = 0; right < s.length; right++){
            if ( right == s.length-1 || s[right] == ' ' ){
                int k = right + 1;
                if(right != s.length-1) {
                    right--;
                }
                while (left<right){
                    char tmp = s[left];
                    s[left++] = s[right];
                    s[right--] = tmp;
                }
                right = k;
                left = k;
            }
        }
    }
}

