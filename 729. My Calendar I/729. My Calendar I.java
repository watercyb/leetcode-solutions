/*
 * Problem: 729. My Calendar I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/my-calendar-i/
 * Language: java
 * Date: 2026-04-08
 */

class MyCalendar {
    Node head;

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        if (head == null) {
            head = new Node(start, end);
            return true;
        }
        Node node = head;
        while (node != null) {
            if (node.start >= end) {
                if (node.left == null) {
                    node.left = new Node(start, end);
                    return true;
                }
                node = node.left;
            } else if (node.end <= start) {
                if (node.right == null) {
                    node.right = new Node(start, end);
                    return true;
                }
                node = node.right;
            } else {
                return false;
            }
        }
        return false;
    }
}

class Node {
    int start;
    int end;
    Node left;
    Node right;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
