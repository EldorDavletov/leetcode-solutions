package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class MaxDepthNaryTree {
    static int depth = 0;
    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println(maxDepth(root));
    }

    public static int maxDepth0(Node root) {
        if (root == null) return 0;
        if(root.children == null) return 1;
        Queue<Node> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.children != null){
                    for(Node child: node.children){
                        queue.offer(child);
                    }
                }
            }
        }
        return maxDepth;
    }


    public static int maxDepth(Node root) {
        if (root == null) return 0; // Daraxt bo'sh bo'lsa
        if (root.children == null || root.children.isEmpty()) return 1; // Barg tugun bo'lsa

        int maxDepth = 0;

        for (Node child : root.children) {
            int depth = maxDepth(child);
            maxDepth = Math.max(maxDepth, depth); // Rekursiv bolalarni tekshirish
        }

        return maxDepth + 1; // Joriy tugunni hisobga olish
    }
    public static Node buildTree() {
        // Creating all the nodes
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);

        // Connecting the children to their parents
        root.children = new ArrayList<>();
        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);
        root.children.add(node5);

        node3.children = new ArrayList<>();
        node3.children.add(node6);
        node3.children.add(node7);

        node4.children = new ArrayList<>();
        node4.children.add(node8);

        node5.children = new ArrayList<>();
        node5.children.add(node9);
        node5.children.add(node10);

        node7.children = new ArrayList<>();
        node7.children.add(node11);

        node8.children = new ArrayList<>();
        node8.children.add(node12);

        node9.children = new ArrayList<>();
        node9.children.add(node13);

        node11.children = new ArrayList<>();
        node11.children.add(node14);

        return root;
    }
}
