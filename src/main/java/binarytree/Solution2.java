package binarytree;

import org.apache.commons.codec.BinaryDecoder;

import java.util.*;
import java.util.stream.Stream;

public class Solution2 {

    public static void main0(String[] args) {
        int[][] desc = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        int[][] desc2 = {{85,82,1},{74,85,1},{39,70,0},{82,38,1},{74,39,0},{39,13,1}};
        TreeNode root = createBinaryTree(desc2);
        System.out.println(root);
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(int[] arr : descriptions){
            int val = arr[0];
            int childVal = arr[1];
            map.putIfAbsent(val,new TreeNode(val));
            TreeNode parent = map.get(val);

            map.putIfAbsent(childVal,new TreeNode(childVal));
            TreeNode child = map.get(childVal);

            if (arr[2] == 1){
                parent.left = child;
            }else {
                parent.right = child;
            }

            children.add(childVal);
        }

        for(int key: map.keySet()){
            if (!children.contains(key)){
                return map.get(key);
            }
        }

        return null;
    }


    public static int[] findMode0(TreeNode root) {
        if(root.left == null && root.right ==null) return new int[]{root.val};
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                map.put(node.val, map.getOrDefault(node.val,0)+1);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        // Maksimal uchrash sonini topish
        int maxCount = map.values().stream().max(Integer::compare).orElse(0);

        // Mode qiymatlarni yig'ish
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                list.add(key);
            }
        }

        // Natijani massivga aylantirish
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void dfs (List<Integer> list, TreeNode root){
        if (root == null){
            return;
        }

        dfs(list,root.left);
        list.add(root.val);
        dfs(list,root.right);
    }





    public static void main2(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        append(sb,"shoptoli");
//        System.out.println(sb);


        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(4);
        root.left = left;
        root.right = right;
//        left.right = leftLeft;
        left.right = leftRight;

        System.out.println(tree2str(root));
    }
    public static void append(StringBuilder sb,String str){
        sb.append(str);
    }

    public static String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root,stringBuilder);
        return stringBuilder.toString();
    }

    public static void dfs(TreeNode root, StringBuilder result){
        if (root == null){
            return;
        }
        result.append(root.val);
        // Agar chap bola bo'lsa, unga qavslar qo'shish
        if (root.left != null) {
            result.append("(");
            dfs(root.left, result);
            result.append(")");
        }
        // Agar chap bola bo'lmasa, lekin o'ng bola bo'lsa, "()" qo'shish
        else if (root.right != null){
            result.append("()");

        }

        if(root.right != null) {
            result.append("(");
            dfs(root.right, result);
            result.append(")");
        }

    }

    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return dfs(map,preorder,0,preorder.length-1);
    }

    public  TreeNode dfs(Map<Integer,Integer> map, int[] pre, int left, int right){
        if (left > right){
            return null;
        }
        int rootValue = pre[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = map.get(rootValue);

        root.left = dfs(map,pre,left,rootIndex-1);
        root.right = dfs(map,pre,rootIndex+1,right);

        return root;
    }


    private int postIndex = 0;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return dfs2(map,postorder,postIndex,inorder.length-1);
    }


    public  TreeNode dfs2(Map<Integer,Integer> map, int[] postOrder, int left, int right){
        if (left > right){
            return null;
        }
        int rootValue = postOrder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = map.get(rootValue);

        root.right = dfs2(map,postOrder,rootIndex+1,right);
        root.left = dfs2(map,postOrder,left,rootIndex-1);

        return root;
    }



    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        int sum = 0;
        StringBuilder current = new StringBuilder();
        dfs(list,current, root);
        for (String number : list){
            sum += Integer.parseInt(number,2);
        }

        return sum;
    }

    public static void dfs(List<String> list, StringBuilder current,  TreeNode root){
        if (root == null){
           return;
        }
        current.append(root.val);
        if (root.left == null && root.right == null){
            list.add(current.toString());
        }else {
            dfs(list, current, root.left);
            dfs(list, current, root.right);
        }
        current.deleteCharAt(current.length() - 1);
    }

    private int dfs(TreeNode root, int currentSum) {
        if (root == null) return 0;

        // Ikkilik son hosil qilish: oldingi qiymatni 2 ga ko‘paytirib, hozirgi raqamni qo‘shamiz
        currentSum = (currentSum << 1) | root.val;

        // Agar leaf tugunga yetgan bo‘lsak, natijani qaytaramiz
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        // Chap va o‘ng bolalar uchun DFS chaqiramiz va natijalarni qo‘shamiz
        return dfs(root.left, currentSum) + dfs(root.right, currentSum);
    }


    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0,depthX = 0, depthY = 0;
        TreeNode parentX = null,parentY = null;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                    if (node.left.val == x){
                        parentX = node;
                        depthX = depth;
                    }
                    if (node.left.val == y){
                        parentY = node;
                        depthY = depth;
                    }
                }
                if (node.right!=null){
                    queue.add(node.right);
                    if (node.right.val == x){
                        parentX = node;
                        depthX = depth;
                    }
                    if (node.right.val == y){
                        parentY = node;
                        depthY = depth;
                    }
                }
            }
            depth++;
            if (parentX != null && parentY != null){
                return depthX == depthY && parentX != parentY;
            }
        }

        return false;
    }


    public static void main3(String[] args) {
        // Original daraxtni yaratamiz
        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);

        // Klonlangan daraxtni yaratamiz (xuddi shu tuzilishda)
        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);

        // Target node - originaldagi biror tugunni tanlaymiz
        TreeNode target = original.right; // 3 ni topish kerak

        getTargetCopy(original,cloned,target);

    }


    public final TreeNode getTargetCopyBFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queueOrig = new LinkedList<>();
        Queue<TreeNode> queueClone = new LinkedList<>();

        queueOrig.add(original);
        queueClone.add(cloned);

        while (!queueOrig.isEmpty()) {
            TreeNode nodeOrig = queueOrig.poll();
            TreeNode nodeClone = queueClone.poll();

            if (nodeOrig == target) return nodeClone;

            if (nodeOrig.left != null) {
                queueOrig.add(nodeOrig.left);
                queueClone.add(nodeClone.left);
            }
            if (nodeOrig.right != null) {
                queueOrig.add(nodeOrig.right);
                queueClone.add(nodeClone.right);
            }
        }

        return null;
    }

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        System.out.println(original.val);
        if (original == target) return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;

        return getTargetCopy(original.right, cloned.right, target);
    }



    public boolean evaluateTree(TreeNode root) {
        if (root.val == 1 || root.val == 0){
            return root.val == 1 ? true: false;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2){
            return left||right;
        }else {
            return left && right;
        }
    }
}
