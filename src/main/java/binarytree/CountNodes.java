package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CountNodes {
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

        System.out.println(countNodes(root));
    }

    // rekursiv yondashuv
    public static int countNodes(TreeNode root) {
        if (root == null) return 0; // Base case
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);

        return count;
    }

//    public static int depth(TreeNode root){
//        if (root == null) return 0;
//
//    }


    // Stack (DFS - Depth First Search) bilan iterativ yondashuv
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++; // Har bir tugunni sanaymiz

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return count;
    }


    // Queue (BFS - Breadth First Search) bilan iterativ yondashuv
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++; // Tugunni sanaymiz

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return count;
    }
}
