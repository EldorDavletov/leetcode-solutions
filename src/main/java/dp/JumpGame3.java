package dp;

public class JumpGame3 {
    public static void main(String[] args) {
        int[]arr = {4,2,3,0,3,1,2};
        System.out.println(canReach(arr,5));
    }

    public static boolean canReach(int[] arr, int start) {
        boolean[] seen = new boolean[arr.length];
//        return dfs(arr,seen,start);
        return dfs(arr,seen,start,0);
    }

    private static boolean dfs(int[] arr,boolean[] seen, int index){
        if (index < 0 || index >= arr.length) return false;
        if (arr[index] == 0) return true;
        if (seen[index]) return false;
        seen[index] = true;
        return dfs(arr,seen,index + arr[index]) || dfs(arr,seen,index - arr[index]);
    }

    private static boolean dfs(int[] arr, boolean[] seen, int index, int depth) {
        String indent = "  ".repeat(depth); // vizual indent
        System.out.println(indent + "→ ENTER: dfs(" + index + ")");

        if (index < 0 || index >= arr.length) {
            System.out.println(indent + "← EXIT : dfs(" + index + ") = false (out of bounds)");
            return false;
        }

        if (arr[index] == 0) {
            System.out.println(indent + "← EXIT : dfs(" + index + ") = true (found 0)");
            return true;
        }

        if (seen[index]) {
            System.out.println(indent + "← EXIT : dfs(" + index + ") = false (already seen)");
            return false;
        }

        seen[index] = true;

        boolean result = dfs(arr, seen, index + arr[index], depth + 1)
                || dfs(arr, seen, index - arr[index], depth + 1);

        System.out.println(indent + "← EXIT : dfs(" + index + ") = " + result);
        return result;
    }
}
