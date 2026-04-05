/*
 * Problem: 622. Design Circular Queue
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-circular-queue/
 * Language: java
 * Date: 2026-04-05
 */

class MyCircularQueue {
    int[] arr;
    int l = 0;
    int r = 0;

    public MyCircularQueue(int k) {
        arr = new int[k + 1];

    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        arr[r] = value;
        if (++r == arr.length)
            r = 0;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        l = (l + 1) % arr.length;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return arr[l];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return arr[(r - 1 + arr.length) % arr.length];
    }

    public boolean isEmpty() {
        return l == r;
    }

    public boolean isFull() {
        return (r + 1) % arr.length == l;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
