package dfs;

public class PathSum3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(-3);
        root.left = left;
        root.right = right;

        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(2);
        leftRight.right = new TreeNode(1);

        left.left = leftLeft;
        left.right = leftRight;

        leftLeft.left = new TreeNode(3);
        leftLeft.right = new TreeNode(-2);
        right.right = new TreeNode(11);

        System.out.println(pathSum(root,8));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int count = countPaths(root, targetSum);

        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);

        return  count;
    }

    public static int countPaths(TreeNode root, int targetSum){
        if (root == null) return 0;
        int count = 0;
        if (root.val == targetSum) count++; // Agar targetSum ga teng bo'lsa, yo'l topildi


        count += countPaths(root.left, targetSum-root.val);
        count += countPaths(root.right, targetSum-root.val);

        return count;
    }


}
