/*
 * Problem: 855. Exam Room
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/exam-room/
 * Language: java
 * Date: 2026-04-09
 */

class ExamRoom {
    PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : b[2] - a[2]);
    HashMap<Integer, int[]> left = new HashMap<>();
    HashMap<Integer, int[]> right = new HashMap<>();
    int n = 0;

    public ExamRoom(int n) {
        this.n = n;
        PQ.offer(new int[] { -1, n, n });
    }

    public int seat() {
        while (PQ.peek()[1] == Integer.MIN_VALUE) {
            PQ.poll();
        }
        int[] max = PQ.poll();
        if (max[0] == -1) {
            int[] node = new int[] { 0, max[1], max[1] / 2 };
            left.put(0, node);
            right.put(max[1], node);
            PQ.offer(new int[] { 0, max[1], max[1] / 2 });
            return 0;
        } else if (max[1] == n) {
            int[] node = (new int[] { max[0], n - 1, (n - 1 - max[0]) / 2 });
            left.put(max[0], node);
            right.put(n - 1, node);
            PQ.offer(node);
            return n - 1;
        } else {
            int res = (max[0] + max[1]) >>> 1;
            int[] l = (new int[] { max[0], res, (res - max[0]) / 2 });
            left.put(max[0], l);
            right.put(res, l);
            int[] r = (new int[] { res, max[1], (max[1] - res) / 2 });
            left.put(res, r);
            right.put(max[1], r);
            PQ.offer(l);
            PQ.offer(r);
            return res;
        }
    }

    public void leave(int p) {
        int[] r = left.get(p);
        int[] l = right.get(p);
        if (l == null) {
            int[] node = new int[] { -1, r[1], r[1] };
            left.put(-1, node);
            right.put(r[1], node);
            PQ.offer(node);
            r[1] = Integer.MIN_VALUE;
        } else if (r == null) {
            int[] node = (new int[] { l[0], n, n - 1 - l[0] });
            left.put(l[0], node);
            right.put(n, node);
            PQ.offer(node);
            l[1] = Integer.MIN_VALUE;
        } else {
            int[] node = new int[] { l[0], r[1], (r[1] - l[0]) / 2 };
            left.put(l[0], node);
            right.put(r[1], node);
            PQ.offer(node);
            l[1] = Integer.MIN_VALUE;
            r[1] = Integer.MIN_VALUE;
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
