/*
 * Problem: 1381. Design a Stack With Increment Operation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-a-stack-with-increment-operation/
 * Language: java
 * Date: 2026-04-16
 */

class CustomStack {
    int[] arr;
    int[] offsets;
    int offset = 0;
    int idx = 0;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        offsets = new int[maxSize];
    }

    public void push(int x) {
        if (idx < arr.length) {
            arr[idx] = x;
            if (idx > 0)
                offsets[idx - 1] += offset;
            offset = 0;
            idx++;
        }
    }

    public int pop() {
        if (idx > 0) {
            offset += offsets[--idx];
            offsets[idx] = 0;
            return arr[idx] + offset;
        }
        return -1;
    }

    public void increment(int k, int val) {
        if (idx > 0)
            offsets[Math.min(k, idx) - 1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
