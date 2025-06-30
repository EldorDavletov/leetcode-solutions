public class Test {
    public static void main(String[] args) {

//        int arr [] ={0,1,2,2,3,0,4,2};
//        System.out.println(removeElement(arr,2));
        System.out.println(isPalindrome(11));
        System.out.println(juggle(true, true, true));
        System.out.println(juggle(true, new boolean[2]));
        System.out.println(juggle(true));
        String query = "select\n" +
                "    a.uncod_id,\n" +
                "    p.part_no,\n" +
                "    p.idnumbers,\n" +
                "    p.post_enter,\n" +
                "    a.g29,\n" +
                "    a.checkintime\n" +
                "from\n" +
                "    etranzit.autodecl a\n" +
                "join\n" +
                "    etranzit.partyinf p\n" +
                "on\n" +
                "    p.autodecl_id=a.id\n" +
                "and p.isdeleted=0\n" +
                "where\n" +
                "    a.isdeleted=0\n" +
                "and p.idnumbers='AT20240235856'\n" +
                "and date(a.checkintime)+60 day>=date(current_timestamp)\n" +
                "and a.state in (180,\n" +
                "                181,\n" +
                "                182,\n" +
                "                183,\n" +
                "                184,\n" +
                "                185,\n" +
                "                188,\n" +
                "                910,\n" +
                "                911,\n" +
                "                912,\n" +
                "                913,\n" +
                "                920,\n" +
                "                930)\n" +
                "and a.systems='E'\n" +
                "order by\n" +
                "    a.uncod_id,\n" +
                "    p.part_no";

        System.out.println(query);
    }

    public static Long factorial(int n){
        if (n==0 || n==1) return 1L;
        return n*factorial(n-1);
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        int k = 0;
        for(int i = len-1; i>=0; i--){
            if(s.charAt(i)==' '){
                break;
            }
            k++;
        }

        return k;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j - 1]) {
                nums[j++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }

        System.out.println();
        return j;
    }

    public static int[] removeElement1(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, arr.length - 1);
        return result;
    }


    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }

        System.out.println();
        return j;
    }

    public static boolean isPalindrome(int x) {

        if (x<0) return false;
        int reversed =0, tmp = x;
        while (tmp!=0){
            reversed = reversed * 10 + tmp%10;
            tmp=tmp/10;
        }
        System.out.println("rev = "+reversed);

        return reversed == x;
    }

    public static int juggle(boolean b, boolean... b2) {
        return b2.length;
    }


}
