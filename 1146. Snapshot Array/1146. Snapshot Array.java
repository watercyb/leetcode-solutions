/*
 * Problem: 1146. Snapshot Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/snapshot-array/
 * Language: java
 * Date: 2026-04-14
 */

class SnapshotArray {
    HashMap<Integer, Node> HM = new HashMap<>();
    int n = 0;

    public SnapshotArray(int length) {

    }

    public void set(int index, int val) {
        if (!HM.containsKey(index)) {
            Node node = new Node(val, n);
            HM.put(index, node);
        } else {
            Node node = HM.get(index);
            if (node.val != val) {
                if (node.order < n)
                    node.snapshot.add(new int[] { node.order, node.val });
                node.val = val;
                node.order = n;
            }
        }
    }

    public int snap() {
        return n++;
    }

    public int get(int index, int snap_id) {
        if (HM.containsKey(index))
            return HM.get(index).get(snap_id);
        return 0;
    }
}

class Node {
    List<int[]> snapshot = new ArrayList<>();
    int val;
    int order;

    public Node(int val, int order) {
        this.val = val;
        this.order = order;
        snapshot.add(new int[] { 0, 0 });
    }

    public int get(int snap_id) {
        if (order <= snap_id)
            return val;
        int l = 0;
        int r = snapshot.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (snapshot.get(mid)[0] > snap_id) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return snapshot.get(l)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
