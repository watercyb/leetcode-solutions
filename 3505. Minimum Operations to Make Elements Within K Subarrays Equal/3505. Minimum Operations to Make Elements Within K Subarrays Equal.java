/*
 * Problem: 3505. Minimum Operations to Make Elements Within K Subarrays Equal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        pos = new int[nums.length];
        for (int i = 0; i < x; i++) {
            insert(nums[i], i);
        }
        long[] points = new long[nums.length];
        points[x - 1] = l - r;
        for (int i = x; i < nums.length; i++) {
            remove(nums[i - x], i - x);
            insert(nums[i], i);
            points[i] = l - r;
        }
        long[] DP = new long[nums.length + 1];
        long[] DPNext = new long[nums.length + 1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(DPNext, Long.MAX_VALUE / 2);
            long min = Long.MAX_VALUE;
            for (int j = x - 1; j < nums.length; j++) {
                int idx = j - x;
                min = Math.min(DP[idx + 1], min);
                DPNext[j + 1] = min + points[j];
            }
            long[] temp = DP;
            DP = DPNext;
            DPNext = temp;
        }
        long res = Long.MAX_VALUE;
        for (long num : DP) {
            res = Math.min(num, res);
        }
        return res;
    }

    PriorityQueue<Node> left = new PriorityQueue<>((a, b) -> a.val - b.val);
    PriorityQueue<Node> right = new PriorityQueue<>((a, b) -> b.val - a.val);
    long l = 0;
    long r = 0;
    Node mid = null;
    int[] pos;

    public void remove(int num, int i) {
        if (pos[i] == 0) {
            mid = null;
        } else if (pos[i] == -1) {
            if (mid != null) {
                left.offer(mid);
                l += mid.val - num;
                pos[mid.idx] = -1;
                mid = null;
            } else {
                l -= num;
                mid = right.poll();
                r -= mid.val;
                pos[mid.idx] = 0;
            }
        } else {
            if (mid != null) {
                right.offer(mid);
                r += mid.val - num;
                pos[mid.idx] = 1;
                mid = null;
            } else {
                mid = left.poll();
                l -= mid.val;
                r -= num;
                pos[mid.idx] = 0;
            }
        }
        clean(left, i);
        clean(right, i);
    }

    public void clean(PriorityQueue<Node> PQ, int i) {
        while (!PQ.isEmpty() && PQ.peek().idx <= i) {
            PQ.poll();
        }
    }

    public void insert(int num, int i) {
        if (mid == null) {
            if (left.isEmpty() || (num <= left.peek().val && num >= right.peek().val)) {
                mid = new Node(num, i);
                pos[i] = 0;
            } else if (num >= left.peek().val) {
                mid = left.poll();
                left.offer(new Node(num, i));
                l += num - mid.val;
                pos[mid.idx] = 0;
                pos[i] = -1;
            } else {
                mid = right.poll();
                right.offer(new Node(num, i));
                r += num - mid.val;
                pos[mid.idx] = 0;
                pos[i] = 1;
            }
        } else {
            if (num >= mid.val) {
                left.offer(new Node(num, i));
                l += num;
                pos[i] = -1;
                right.offer(mid);
                r += mid.val;
                pos[mid.idx] = 1;
                mid = null;
            } else {
                left.offer(mid);
                l += mid.val;
                pos[mid.idx] = -1;
                mid = null;
                right.offer(new Node(num, i));
                r += num;
                pos[i] = 1;
            }
        }
    }
}

class Node {
    int val;
    int idx;

    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
