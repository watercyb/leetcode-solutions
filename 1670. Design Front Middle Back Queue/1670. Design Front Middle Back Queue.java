/*
 * Problem: 1670. Design Front Middle Back Queue
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-front-middle-back-queue/
 * Language: java
 * Date: 2026-04-19
 */

class FrontMiddleBackQueue {
    Node head = new Node(-1);
    Node tail = new Node(-1);
    Node mid;
    int n = 0;

    public FrontMiddleBackQueue() {
        head.next = tail;
        tail.prev = head;
    }

    public void pushFront(int val) {
        n++;
        if (n == 1) {
            mid = insert(head, tail, val);
        } else {
            insert(head, head.next, val);
            if (n % 2 == 0)
                mid = mid.prev;
        }
    }

    public void pushMiddle(int val) {
        n++;
        if (n == 1) {
            mid = insert(head, tail, val);
        } else if (n % 2 == 0) {
            mid = insert(mid.prev, mid, val);
        } else {
            mid = insert(mid, mid.next, val);
        }
    }

    public void pushBack(int val) {
        n++;
        if (n == 1) {
            mid = insert(head, tail, val);
        } else {
            insert(tail.prev, tail, val);
            if (n % 2 == 1)
                mid = mid.next;
        }
    }

    public int popFront() {
        if (n == 0) {
            return -1;
        } else {
            if ((--n) % 2 == 1)
                mid = mid.next;
            return delete(head.next);
        }
    }

    public int popMiddle() {
        if (n == 0) {
            return -1;
        } else if ((--n) % 2 == 0) {
            mid = mid.prev;
            return delete(mid.next);
        } else {
            mid = mid.next;
            return delete(mid.prev);
        }
    }

    public int popBack() {
        if (n == 0) {
            return -1;
        } else {
            if ((--n) % 2 == 0)
                mid = mid.prev;
            return delete(tail.prev);
        }
    }

    public int delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node.val;
    }

    public Node insert(Node a, Node b, int val) {
        Node newNode = new Node(val);
        newNode.next = b;
        b.prev = newNode;
        newNode.prev = a;
        a.next = newNode;
        return newNode;
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
