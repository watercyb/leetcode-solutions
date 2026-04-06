/*
 * Problem: 641. Design Circular Deque
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-circular-deque/
 * Language: java
 * Date: 2026-04-06
 */

class MyCircularDeque {
    int[] arr;
    int l = 1;
    int r = 0;
    int n = 0;

    public MyCircularDeque(int k) {
        arr = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        l = (l - 1 + arr.length) % arr.length;
        arr[l] = value;
        n++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        r = (r + 1) % arr.length;
        arr[r] = value;
        n++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        l = (l + 1) % arr.length;
        n--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        r = (r - 1 + arr.length) % arr.length;
        n--;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return arr[l];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return arr[r];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == arr.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
