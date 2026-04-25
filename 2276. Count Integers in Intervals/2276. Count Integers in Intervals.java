/*
 * Problem: 2276. Count Integers in Intervals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-integers-in-intervals/
 * Language: java
 * Date: 2026-04-25
 */

class CountIntervals {
    int rangeRight = 1_000_000_000;
    Segment root = new Segment();
    int count = 0;

    public CountIntervals() {
    }

    public void add(int left, int right) {
        insert(root, 0, rangeRight, left, right);
    }

    public int insert(Segment node, int l, int r, int left, int right) {
        if (r < left || l > right||r - l + 1 == node.count)
            return 0;
        if (l >= left && r <= right) {
            int diff = r - l + 1 - node.count;
            count += diff;
            node.count += diff;
            return diff;
        } else {
            int mid = (l + r) >>> 1;
            if (node.left == null)
                node.left = new Segment();
            int res= insert(node.left, l, mid, left, right);
            if (node.right == null)
                node.right = new Segment();
            res += insert(node.right, mid + 1, r, left, right);
            node.count += res;
            return res;
        }
    }

    public int count() {
        return count;
    }
}

class Segment {
    Segment left;
    Segment right;
    int count = 0;

    public Segment() {
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
