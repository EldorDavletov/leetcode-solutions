package binarytree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solutions {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(17);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(root));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(6);

//        System.out.println(countNodes(root2));

        System.out.println(increasingBST(root2));
    }


    public static int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null){
            return 0;
        }
        int sum = 0;

        if (root.left!=null) {
            if (root.left.left == null && root.left.right==null) {
                sum = sum + root.left.val;
            } else {
                sum = sum + sumOfLeftLeaves(root.left);
            }
        }
        if (root.right!=null){
            sum = sum + sumOfLeftLeaves(root.right);
        }

        return sum;
    }


    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        int max_left=maxDepth(root.left)+1;
        int max_right=maxDepth(root.right)+1;
        return Math.max(max_left,max_right);

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = len(root.left);
        int rightDepth = len(root.right);

        return Math.abs(leftDepth-rightDepth)<2  && isBalanced(root.left) && isBalanced(root.right);
    }
    public static int len(TreeNode root){
        if (root==null) return 0;
        int len1 = 1 + len(root.left);
        int len2 = 1 + len(root.right);
        return Math.max(len1,len2);
    }


    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        System.out.println("leftHeight = " +leftHeight);
        System.out.println("rightHeight = " +rightHeight);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;  // 2^leftHeight - 1
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public static int findLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public static int findRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }


    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Chap va o'ng daraxtlarning chuqurligini topamiz
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Har bir tugun uchun diametrni yangilaymiz
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Bu tugunning balandligini qaytaramiz
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }




    public static TreeNode current;
    public static TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        current = dummy;
        inOrderTraversal(root);
        return dummy.right;
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        node.left = null;
        current.right = node;
        current = node;
        inOrderTraversal(node.right);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root!=null){
            constructPath(root,"", paths);
        }
        return paths;
    }

    private void constructPath(TreeNode current, String path,List<String> paths){
       if(current!=null){
           path += current.val;
           if (current.left == null && current.right == null){
               paths.add(path);
           }else {
               path += "->";
               constructPath(current.left,path,paths);
               constructPath(current.right,path,paths);
           }
       }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                size--;
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }

            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                size--;
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }

            result.addFirst(list);
        }
        return result;
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(sum/size);
        }

        return result;
    }
}


