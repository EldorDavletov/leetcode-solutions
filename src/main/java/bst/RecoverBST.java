package bst;





public class RecoverBST {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        printInOrderTraversal(root);

        RecoverBST obj = new RecoverBST();

        obj.recoverTree(root);

        System.out.println();

        printInOrderTraversal(root);

    }

    public void recoverTree(TreeNode root) {
        inorder(root);
       int temp = first.val;
       first.val = second.val;
       second.val = temp;
    }

    public void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);

        if (first == null && prev.val > root.val){
            first = prev;
        }
        if (first != null && prev.val > root.val){
            second = root;
        }

        prev = root;

        inorder(root.right);

    }


    public static void printInOrderTraversal(TreeNode root) {
        if (root != null) {
            printInOrderTraversal(root.left);
            System.out.print(root.val + " ");
            printInOrderTraversal(root.right);
        }
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }
}
