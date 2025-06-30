package monotonicStack;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums){
            TreeNode node = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num){
                node.left = stack.pop();
            }
            if (!stack.isEmpty()){
                stack.peek().right = node;
            }

            stack.push(node);
        }
        TreeNode root = null;
        while (!stack.isEmpty()) root = stack.pop();

        return root;

    }

}
