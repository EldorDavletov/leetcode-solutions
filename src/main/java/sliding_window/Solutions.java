package sliding_window;


public class Solutions {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240,2));
        System.out.println(divisorSubstrings(430043,2));
        System.out.println(divisorSubstrings(30003,3));
    }
    public static int divisorSubstrings0(int num, int k) {
        String numberStr = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            StringBuilder number = new StringBuilder();
            for (int j = i; j < i+k && j< numberStr.length(); j++) {
                number.append(numberStr.charAt(j));
            }
            if (number.length() == k && Integer.parseInt(number.toString())!= 0 && num % Integer.parseInt(number.toString()) == 0) count++;
        }
        return count;
    }
    public static int divisorSubstrings1(int num, int k) {
        String number = String.valueOf(num);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            sb.append(number.charAt(i));
            if(sb.length() == k){
                if (Integer.parseInt(sb.toString()) != 0 && num % Integer.parseInt(sb.toString()) == 0){
                    count++;
                }
                sb.delete(0,1);
            }
        }
        return count;
    }

    public static int divisorSubstrings(int num, int k) {
        String number = String.valueOf(num);
        int count = 0;

        for (int i = 0; i+k < number.length(); i++) {
//            if (i+k<=number.length()) {
                int subNum = Integer.parseInt(number.substring(i, i + k));
                if (subNum != 0 && num % subNum == 0) {
                    count++;
                }
//            }
        }

        return count;
    }

}
