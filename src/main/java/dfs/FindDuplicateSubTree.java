package dfs;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class FindDuplicateSubTree {
    public static void main0(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.left = new TreeNode(4);
        right.left = new TreeNode(2);
        right.right = new TreeNode(4);
        right.left.left = new TreeNode(4);
        root.left = left;
        root.right = right;

        FindDuplicateSubTree obj = new FindDuplicateSubTree();

        System.out.println(obj.findDuplicateSubtrees(root));
        System.out.println(obj.trees);
    }

    Map<String, Integer> trees = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }
    private String dfs(TreeNode node) {
        if (node == null) return "#";
        // Serialize the subtree
        String serial = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        // If we've seen this subtree before
        trees.put(serial, trees.getOrDefault(serial, 0) + 1);
        if (trees.get(serial) == 2) {
            // This is the second time we've seen this subtree, so it's a duplicate
            result.add(node);
        }
        return serial;
    }

    public static void main1(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out)) {
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            writer.write(a + b);
            writer.flush();
        }
    }
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(String.valueOf(b).length() == a){
            writer.println("yes");
        } else {
            writer.println("no");
        }
        writer.flush();
        writer.close();
    }

    public static void main3(String... args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
        if (n % 4 != 0) {
            n += (4 - n % 4);
        }

        int[] fronts = new int[n / 2];
        int[] backs = new int[n / 2];

        int i = 0, j = 0;
        while (i < n / 2) {
            fronts[j] = n - i;
            fronts[j + 1] = i + 1;
            backs[j] = i + 2;
            backs[j + 1] = n - (i + 1);
            i += 2;
            j += 2;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(n / 4).append("\n");

        for (int x : fronts) sb.append(x).append(" ");
        sb.setLength(sb.length() - 1); // Oxirgi bo'sh joyni olib tashlash
        sb.append("\n");

        for (int x : backs) sb.append(x).append(" ");
        sb.setLength(sb.length() - 1); // Oxirgi bo'sh joyni olib tashlash

        out.println(sb);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String n = in.nextLine();
        in.close();

        if (n.length() == 1) {
            out.println(n);
            out.flush();
            return;
        }

        BigInteger maxNum = new BigInteger(n);

        char[] digits = n.toCharArray();
        int maxSum = sumOfDigits(digits);



        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < '9') {
                digits[i] = '9';
                if (digits[i-1]>'0') {
                    digits[i - 1]--;
                }
                BigInteger newNum = new BigInteger(new String(digits));
                if(newNum.longValue()!=maxNum.longValue() && sumOfDigits(digits) > maxSum){
                    maxNum = newNum;
                    maxSum = sumOfDigits(digits);
                }
            }
        }
        out.println(maxNum);
        out.flush();
    }


    private static int sumOfDigits(char[] digits){
        int sum = 0;
        for (char digit : digits) {
            sum += digit - '0';
        }
        return sum;
    }

}
