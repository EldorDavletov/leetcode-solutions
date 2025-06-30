package dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);

        root.left = left;
        root.right = right;

        left.left = new TreeNode(11);
        left.left.left = new TreeNode(7);
        left.left.right = new TreeNode(2);

        right.left = new TreeNode(13);
        right.right = new TreeNode(4);
        right.right.left = new TreeNode(5);
        right.right.right = new TreeNode(1);

        System.out.println(pathSum(root,22));

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,result,new ArrayList<>(),targetSum);

        return result;
    }

    public static void dfs(TreeNode root, List<List<Integer>> result, List<Integer> list,int targetSum){
        if (root == null){
            return;
        }

        list.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        } else {
            dfs(root.left,result,list,targetSum - root.val);
            dfs(root.right,result,list,targetSum - root.val);
        }

        list.removeLast();
    }

}
