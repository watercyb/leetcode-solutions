/*
 * Problem: 732. My Calendar III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/my-calendar-iii/
 * Language: java
 * Date: 2026-04-08
 */

class MyCalendarThree {
    Node root = new Node(0, 1_000_000_000);

    public MyCalendarThree() {
    }

    public int book(int startTime, int endTime) {
        return insert(root, startTime, endTime - 1, 0);
    }

    public int insert(Node node, int l, int r, int cache) {
        if (node.l > r || node.r < l) {
            node.val += cache;
            node.cache += cache;
            return 0;
        }
        if (l <= node.l && r >= node.r) {
            node.val += cache + 1;
            node.cache += cache + 1;
            return node.val;
        }
        cache += node.cache;
        node.cache = 0;
        if (node.left == null) {
            if (l > node.l) {
                node.left = new Node(node.l, l - 1, cache, cache);
                node.right = new Node(l, node.r);
                node.val = Math.max(insert(node.right, l, r, cache), node.val);
            } else {
                node.left = new Node(node.l, r);
                node.right = new Node(r + 1, node.r, cache, cache);
                node.val = Math.max(insert(node.left, l, r, cache), node.val);
            }
        } else {
            node.val = Math.max(Math.max(insert(node.left, l, r, cache), insert(node.right, l, r, cache)), node.val);
        }
        return node.val;
    }
}

class Node {
    int l;
    int r;
    int val = 0;
    int cache = 0;
    Node left, right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public Node(int l, int r, int val, int cache) {
        this.l = l;
        this.r = r;
        this.val = val;
        this.cache = cache;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
