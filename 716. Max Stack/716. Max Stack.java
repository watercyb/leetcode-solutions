/*
 * Problem: 716. Max Stack
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/max-stack/
 * Language: java
 * Date: 2026-04-08
 */

class MaxStack {
    PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
    Deque<int[]> Dq = new ArrayDeque<>();
    int n = 0;

    public MaxStack() {

    }

    public void push(int x) {
        int[] tmp = { x, n++ };
        PQ.offer(tmp);
        Dq.offerFirst(tmp);
    }

    public int pop() {
        while (Dq.peekFirst()[1] < 0) {
            Dq.pollFirst();
        }
        int[] tmp = Dq.pollFirst();
        tmp[1] = -1;
        return tmp[0];
    }

    public int top() {
        while (Dq.peekFirst()[1] < 0) {
            Dq.pollFirst();
        }
        return Dq.peekFirst()[0];
    }

    public int peekMax() {
        while (PQ.peek()[1] < 0) {
            PQ.poll();
        }
        return PQ.peek()[0];
    }

    public int popMax() {
        while (PQ.peek()[1] < 0) {
            PQ.poll();
        }
        int[] tmp = PQ.poll();
        tmp[1] = -1;
        return tmp[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
