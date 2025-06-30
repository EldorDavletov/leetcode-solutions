package leetcodesolutions;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class Solution{
      public static void main(String[] args) {
          TreeNode left = new TreeNode(2);
          TreeNode right = new TreeNode(3);
          TreeNode p = new TreeNode(1, left, right);
          TreeNode q = new TreeNode(1, left, right);
          System.out.println(isSameTree(p, q));

          TreeNode tmp = new TreeNode(1);
          tmp.right = new TreeNode(2);
          tmp.right.right = new TreeNode(3);
          tmp.right.right.right = new TreeNode(4);
          tmp.right.right.right.right = new TreeNode(5);

          inOrderTraversal(p);
          System.out.println();
          preOrderTraversal(p);
          System.out.println();
          postOrderTraversal(p);

          System.out.println();
          System.out.println(minDepth(tmp));

          TreeNode tree = new TreeNode(3);
          tree.left = new TreeNode(9);
          tree.right = new TreeNode(20);
          tree.right.left = new TreeNode(15);
          tree.right.right = new TreeNode(7);

          System.out.println(minDepth(tree));


      }

      public static boolean isSameTree(TreeNode p, TreeNode q) {
          if (p==null && q==null) return true;
          if (p == null || q == null) return false;
          if (q.val==p.val) {
              return isSameTree(p.left,q.left) && isSameTree(q.right,p.right);
          } else return false;
      }

      public static void inOrderTraversal(TreeNode root) {
          if (root != null) {
              inOrderTraversal(root.left);
              System.out.print(root.val + " ");
              inOrderTraversal(root.right);
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

      public static int minDepth(TreeNode root) {
          // Agar daraxt bo'sh bo'lsa, chuqurlik 0
          if (root == null) {
              return 0;
          }

          // Agar barg tugun bo'lsa, chuqurlik 1
          if (root.left == null && root.right == null) {
              return 1;
          }

          // Agar chap bola yo'q bo'lsa, o'ng bolasi bo'yicha rekursiv chaqiriq
          if (root.left == null) {
              return minDepth(root.right) + 1;
          }

          // Agar o'ng bola yo'q bo'lsa, chap bolasi bo'yicha rekursiv chaqiriq
          if (root.right == null) {
              return minDepth(root.left) + 1;
          }

          // Har ikkala bola mavjud bo'lsa, eng kichik chuqurlikni topish
          return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
      }

      public int minDepth2(TreeNode root) {
          // Agar daraxt bo'sh bo'lsa, chuqurlik 0
          if (root == null) {
              return 0;
          }

          // BFS uchun navbat yaratamiz
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          int depth = 1;

          while (!queue.isEmpty()) {
              int size = queue.size();

              for (int i = 0; i < size; i++) {
                  TreeNode currentNode = queue.poll();

                  // Agar currentNode barg tugun bo'lsa, minimal chuqurlik topildi
                  if (currentNode.left == null && currentNode.right == null) {
                      return depth;
                  }

                  // Chap bolani navbatga qo'shish
                  if (currentNode.left != null) {
                      queue.add(currentNode.left);
                  }

                  // O'ng bolani navbatga qo'shish
                  if (currentNode.right != null) {
                      queue.add(currentNode.right);
                  }
              }

              // Navbatdagi barcha elementlar qayta ishlangandan keyin chuqurlikni oshirish
              depth++;
          }

          return depth;
      }



  }
