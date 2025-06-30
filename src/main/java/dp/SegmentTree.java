package dp;

class SegmentTree {
    int[] tree;
    int size;

    public SegmentTree(int size) {
        this.size = size;
        tree = new int[4 * size];
    }

    public void update(int index, int value, int node, int left, int right) {
        if (left == right) {
            tree[node] = Math.max(tree[node], value);
            return;
        }

        int mid = (left + right) / 2;
        if (index <= mid)
            update(index, value, 2 * node, left, mid);
        else
            update(index, value, 2 * node + 1, mid + 1, right);

        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    public int query(int l, int r, int node, int left, int right) {
        if (r < left || right < l) return 0;
        if (l <= left && right <= r) return tree[node];

        int mid = (left + right) / 2;
        return Math.max(
                query(l, r, 2 * node, left, mid),
                query(l, r, 2 * node + 1, mid + 1, right)
        );
    }


}
