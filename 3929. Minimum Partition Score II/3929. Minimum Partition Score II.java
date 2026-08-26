/*
 * Problem: 3929. Minimum Partition Score II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-partition-score-ii/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public long minPartitionScore(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int max = sums[nums.length];
        long l = 0;
        long r = (long) max * max;
        CHT cht = new CHT(nums.length + 1);
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (chk(cht, nums, sums, mid) <= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        Pair<Long, Integer> res = calc(cht, nums, sums, l);
        return res.getKey() - (long) l * k;
    }

    public int chk(CHT cht, int[] nums, int[] sums, long mid) {
        cht.reset();
        cht.insert(0, mid, 0);
        CHT.Node min = null;
        for (int i = 0; i < nums.length; i++) {
            min = cht.get(sums[i + 1]);
            long next = min.get(sums[i + 1]) + (long) sums[i + 1] * sums[i + 1] + mid;
            cht.insert(-sums[i + 1], next, min.count + 1);
        }
        return min.count + 1;
    }

    public Pair<Long, Integer> calc(CHT cht, int[] nums, int[] sums, long l) {
        cht.reset();
        cht.insert(0, l, 0);
        long res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            CHT.Node min = cht.get(sums[i + 1]);
            res = min.get(sums[i + 1]) + ((long) sums[i + 1] * sums[i + 1] + sums[i + 1]) / 2;
            long next = res + ((long) sums[i + 1] * sums[i + 1] - sums[i + 1]) / 2 + l;
            cht.insert(-sums[i + 1], next, min.count + 1);
            count = min.count + 1;
        }
        return new Pair<>(res, count);
    }
}

class CHT {
    Node[] nodes;
    int[] counts;
    int l = 0;
    int r = 0;

    public CHT(int n) {
        nodes = new Node[n];
    }

    public void insert(long m, long b, int count) {
        Node node = new Node(m, b, count);
        while (r - l >= 2 && nodes[r - 1].cmpInt(nodes[r - 2], node)) {
            r--;
        }
        nodes[r++] = node;
    }

    public Node get(long n) {
        while (l < r - 1 && (nodes[l].get(n) > nodes[l + 1].get(n)
                || (nodes[l].get(n) == nodes[l + 1].get(n) && nodes[l].count >= nodes[l + 1].count))) {
            l++;
        }
        return nodes[l];
    }

    public void reset() {
        l = r = 0;
    }

    class Node {
        long m;
        long b;
        int count;
        Node left;
        Node right;

        public Node(long m, long b, int count) {
            this.m = m;
            this.b = b;
            this.count = count;
        }

        public long get(long x) {
            return m * x + b;
        }

        public boolean cmpInt(Node before, Node after) {
            return (b - before.b) * (m - after.m) >= (b - after.b) * (m - before.m);
        }

        public String toString() {
            return "(" + m + ", " + b + ")";
        }
    }
}

