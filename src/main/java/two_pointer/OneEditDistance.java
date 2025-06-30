package two_pointer;

public class OneEditDistance {
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ba","a"));
//        System.out.println(isOneEditDistance("",""));
    }

    public static boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (Math.abs(len1 - len2) > 1 || s.equals(t)) return false;
        if (len1 == len2){
            int k = 0;
            for (int i = 0; i < len1; i++) {
                if (s.charAt(i) != t.charAt(i)){
                    k++;
                }
            }
            return k == 1;
        }else if (len1 < len2){
            StringBuilder sb1 = new StringBuilder(s);
            StringBuilder sb2 = new StringBuilder(t);

            for (int i = 0; i < len2; i++) {
                if (i<len2-1){
                    if (sb1.charAt(i) != sb2.charAt(i)) {
                        sb1.insert(i, sb2.charAt(i));
                        break;
                    }
                }else {
                    sb1.append(sb2.charAt(i));
                }
            }
            return sb1.compareTo(sb2) == 0;
        }else {
            StringBuilder sb1 = new StringBuilder(s);
            StringBuilder sb2 = new StringBuilder(t);

            for (int i = 0; i < len1; i++) {
                if (i<len1-1){
                    if (sb1.charAt(i) != sb2.charAt(i)) {
                        sb1.delete(i, i+1);
                        break;
                    }
                }else {
                    sb1.delete(i,i+1);
                }
            }
            return sb1.compareTo(sb2) == 0;
        }

    }
}
