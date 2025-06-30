package dfs;

import java.util.ArrayList;
import java.util.List;

public class DFSExample {
    public static void main0(String[] args) {

//        System.out.println(lexicalOrder(13));
//        System.out.println(16>>4);
//        System.out.println(5&2);

        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;

        System.out.println(minDiffInBST(root));

    }


    public static List<Integer> lexicalOrder(int n) {
//        return IntStream.rangeClosed(1, n)
//                .boxed()
//                .sorted((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)))
//                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10 ; i++) {
            dfs(i,n,result);
        }

        return result;

    }

    public static void dfs(int current, int n, List<Integer> result){
        if (current>n){
            return;
        }

        result.add(current);
        for (int i = 0; i < 10; i++) {
            if (current*10+i>n){
                return;
            }
            dfs(current*10+i,n,result);
        }
    }

    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root);
        int minDiff = Integer.MAX_VALUE; // Minimal farq uchun boshlang'ich qiymat

        for (int i = 1; i < list.size(); i++) {
            // Ketma-ket juftliklarning farqini hisoblaymiz
            minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
        }

        return minDiff;
    }

    public static void dfs(List<Integer> list,TreeNode node){
        if (node == null) {
            return;
        }
        dfs(list,node.left);
        list.add(node.val);
        dfs(list,node.right);
    }


    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root);

        int min =Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, Math.abs(list.get(i)- list.get(i-1)));
        }

        return min;
    }

    public static void main1(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(9);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightRight = new TreeNode(7);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.right = rightRight;
        System.out.println(findTilt(root));
    }

    private static int sum = 0;
    public static int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    public static int dfs(TreeNode root){
        if (root == null) {
            return 0; // Bo'sh tugun uchun yig'indi 0
        }

        // Chap va o'ng farzandlar uchun rekursiv yig'indini hisoblash
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        // Joriy tugunning og'ishini hisoblash
        int tilt = Math.abs(leftSum - rightSum);
        sum += tilt;

        // Joriy tugunning yig'indisini qaytarish
        return root.val + leftSum + rightSum;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Agar subRoot bo'sh bo'lsa, har doim true, chunki bo'sh daraxt har qanday daraxtning qismi hisoblanadi
        if (subRoot == null) {
            return true;
        }
        // Agar root bo'sh bo'lsa, lekin subRoot bo'sh bo'lmasa, false
        if (root == null) {
            return false;
        }

        // Agar root va subRoot bir xil bo'lsa, true qaytariladi
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Rekursiv tarzda rootning chap va o'ng farzandlarini tekshiramiz
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return root.val == subRoot.val && isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }

    public static void main2(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        System.out.println(leafSimilar(root1,root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2,leaves2);
        return leaves1.equals(leaves2);
    }

    public static void dfs(TreeNode root,List<Integer> leaves){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            leaves.add(root.val);
        }
        dfs(root.left,leaves);
        dfs(root.right,leaves);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);


        System.out.println(rangeSumBST(root1,7,15));
    }


    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;

        // Agar qiymat `low` va `high` oralig'ida bo'lsa, qo'shamiz
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // Faqat kerakli tomonga chaqiramiz
        if (root.val > low) sum += rangeSumBST(root.left, low, high);
        if (root.val < high) sum += rangeSumBST(root.right, low, high);

        return sum;
    }


    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        int rootVal = root.val;
        return isEqual(root,rootVal);
    }

    private boolean isEqual (TreeNode root,int rootVal){
        if (root == null) return true;
        if (root.val != rootVal){
            return false;
        }
        return isEqual(root.left,rootVal) && isEqual(root.right,rootVal);
    }
}


