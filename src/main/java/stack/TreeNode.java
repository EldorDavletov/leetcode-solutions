package stack;

import org.apache.poi.ss.formula.functions.T;

import java.util.Stack;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = null;
        TreeNode rightRight = new TreeNode(6);

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;
        right.left = null;
        right.right = rightRight;

        flatten(root);

    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode current = stack.pop();
            if (current.right != null){
                stack.push(current.right);
            }
            if (current.left != null){
                stack.push(current.left);
            }
            if (!stack.isEmpty()){
                current.right = stack.peek();
            }
            current.left = null;
        }
    }
}
