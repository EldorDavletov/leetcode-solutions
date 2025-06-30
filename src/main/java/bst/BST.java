package bst;

import java.util.*;

public class BST {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){val = x;}
    }


    public static  TreeNode sortedArrayToBST0(int[] nums){
        if (nums.length==0) return null;
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        // Navbat (queue) orqali rekursiyasiz BST yaratish
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<int[]> ranges = new LinkedList<>();

        nodes.add(root);
        ranges.add(new int[]{0, nums.length - 1});

        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
            int[] range = ranges.poll();

            int leftIndex = range[0];
            int rightIndex = range[1];
            int midIndex = (leftIndex + rightIndex) / 2;

            if (leftIndex < midIndex) {
                int leftMid = (leftIndex + midIndex - 1) / 2;
                currentNode.left = new TreeNode(nums[leftMid]);
                nodes.add(currentNode.left);
                ranges.add(new int[]{leftIndex, midIndex - 1});
            }

            if (midIndex < rightIndex) {
                int rightMid = (midIndex + 1 + rightIndex) / 2;
                currentNode.right = new TreeNode(nums[rightMid]);
                nodes.add(currentNode.right);
                ranges.add(new int[]{midIndex + 1, rightIndex});
            }
        }

        return root;
    }

    public static void preorder(TreeNode root){
        if (root==null) return;
        System.out.println(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main0(String...args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode bst = sortedArrayToBST(nums);
        preorder(bst);

        for (String a:args){
            System.out.println(a);
        }
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return bstRec(nums,0,nums.length-1);
    }

    public static TreeNode bstRec(int[] nums, int left, int right){
        if (left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode node =new TreeNode(nums[mid]);
        node.left = bstRec(nums,left,mid-1);
        node.right = bstRec(nums,mid+1,right);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        TreeNode leftLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(4);
        TreeNode leftLeftLeft = new TreeNode(1);

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;
        leftLeft.left = leftLeftLeft;

        System.out.println(kthSmallest(root,3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root,k);
        return list.get(k-1);
    }

    public static void dfs(List<Integer> list, TreeNode root, int k){
        if (list.size()>=k || root == null){
            return;
        }
        dfs(list, root.left,k);
        list.add(root.val);
        dfs(list, root.right,k);
    }

    public int findSecondMinimumValue(TreeNode root) {
//        Set<Integer> set = new HashSet<>();
//        dfs(set, root);
//
//        if (set.size() < 2) {
//            return -1;
//        }
//
//        List<Integer> sortedList = new ArrayList<>(set);
//        Collections.sort(sortedList);
//
//        return sortedList.get(1);

        Set<Integer> set = new TreeSet<>();
        dfs(set, root);
        if (set.size() < 2) return -1;
        Iterator<Integer> iterator = set.iterator();
        iterator.next(); // Eng kichik elementni o'tkazib yuborish
        return iterator.next(); // Ikkinchi eng kichik elementni qaytarish
    }

    public static void dfs(Set<Integer> set, TreeNode root){
        if (root == null){
            return;
        }
        dfs(set, root.left);
        set.add(root.val);
        dfs(set, root.right);
    }
}
