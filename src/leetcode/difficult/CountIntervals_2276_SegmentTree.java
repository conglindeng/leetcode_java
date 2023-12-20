package leetcode.difficult;

class CountIntervals_2276_SegmentTree {

    CountIntervals_2276_SegmentTree lNode, rNode;
    int l, r;
    int cnt;

    public CountIntervals_2276_SegmentTree() {
        l = 1;
        r = (int) 1e9;
    }

    public CountIntervals_2276_SegmentTree(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public void add(int left, int right) {
        if (cnt == r - l + 1) {
            return;
        }
        if (l >= left && r <= right) {
            cnt = r - l + 1;
            return;
        }
        int mid = (r - l) / 2 + l;
        if (lNode == null) {
            lNode = new CountIntervals_2276_SegmentTree(l, mid);
        }
        if (rNode == null) {
            rNode = new CountIntervals_2276_SegmentTree(mid + 1, r);
        }
        if (left <= mid) {
            lNode.add(left, right);
        }
        if (right > mid) {
            rNode.add(left, right);
        }
        cnt = lNode.count() + rNode.count();
    }

    public int count() {
        return cnt;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such: CountIntervals obj = new CountIntervals();
 * obj.add(left,right); int param_2 = obj.count();
 */