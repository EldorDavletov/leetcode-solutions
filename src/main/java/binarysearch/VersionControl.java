package binarysearch;

public class VersionControl {
    public static void main(String[] args) {

        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        int left=1,right = n, mid, firstBadVersion = 0;
        while (left<=right){
            mid = left + (right-left)/2;
            if (isBadVersion(mid)){
                right = mid - 1;
                firstBadVersion = mid;
            }else {
                left = mid + 1;
            }
        }

        return firstBadVersion;
    }
    public static  boolean isBadVersion(int version){
        if (version >= 1702766719) return  true;
        else return false;
    }
}
