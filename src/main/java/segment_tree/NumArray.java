package segment_tree;

import java.util.Arrays;

public class NumArray {
    private int n;
    private int[] tree;

    public NumArray(int[] arr){
        n = arr.length;
        tree = new int[4*n];
        build(arr,0,0,n-1);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,5,-2,3};
        NumArray obj = new NumArray(nums);
        System.out.println(Arrays.toString(obj.tree));
        obj.update(1,5);
        System.out.println(Arrays.toString(obj.tree));
    }


    private void build(int[] arr,int node,int left, int right){
        if (left == right){
            tree[node] = arr[left];
        }else {
            int mid = (left + right)/2;
            build(arr,2 * node + 1,left,mid);
            build(arr,2 * node + 2,mid + 1,right);
            tree[node] = tree[2*node+1]+tree[2*node+2];
        }
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }

    public int sumRange(int left, int right) {
       return query(0,0,n-1,left,right);
    }

    private void update(int node, int left, int right, int index, int val) {
        if (left == right) {
            tree[node] = val;
        } else {
            int mid = (left + right) / 2;
            if (index <= mid) {
                update(2 * node + 1, left, mid, index, val);
            } else {
                update(2 * node + 2, mid + 1, right, index, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }



    private int query(int node, int left, int right, int ql, int qr) {
        if (qr < left || ql > right) return 0; // No overlap
        if (ql <= left && right <= qr) return tree[node]; // Total overlap
        int mid = (left + right) / 2;
        return query(2 * node + 1, left, mid, ql, qr)
                + query(2 * node + 2, mid + 1, right, ql, qr);
    }

}
