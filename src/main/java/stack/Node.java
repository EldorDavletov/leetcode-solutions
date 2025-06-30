package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Node {
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

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

// 3 ning bolalari
        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);

// 1 ning bolalari
        root.children = new ArrayList<>();
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        System.out.println(postorder2(root));
    }



    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val); // Rootni tashrif
            // Farzandlarni teskari tartibda stackga qo'shing
            Collections.reverse(current.children);
            for (Node child : current.children) {
                stack.push(child);
            }
        }

        return result;
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.addFirst(current.val);
            if (current.children!=null) {
                for (Node child : current.children) {
                    stack.push(child);
                }
            }
        }

        return result;
    }

    public static List<Integer> postorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs2(root, result);
        return result;
    }




    public static List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val); // Rootni tashrif
        for (Node child : node.children) { // Farzandlarni o'rganish
            dfs(child, result);
        }
    }
    private static void dfs2(Node node, List<Integer> result) {
        if(node == null) return;
        if (node.children == null){
            result.add(node.val);
            return;
        }
        for (Node child : node.children) { // Farzandlarni o'rganish
            dfs2(child, result);
        }
        result.add(node.val);
    }


}
