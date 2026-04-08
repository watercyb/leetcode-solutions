/*
 * Problem: 731. My Calendar II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/my-calendar-ii/
 * Language: java
 * Date: 2026-04-08
 */

class MyCalendarTwo {
    Node head = new Node(-1, 0);

    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        Node node = head;
        int count = 1;
        while (node.next != null && node.next.idx < start) {
            node = node.next;
            count += node.val;
        }
        if (node.next == null) {
            node.next = new Node(start, 1);
            node.next.next = new Node(end, -1);
        } else {
            Node l = node;
            if (node.next.idx != start && count == 3) {
                return false;
            }
            while (node.next != null && node.next.idx < end) {
                node = node.next;
                count += node.val;
                if (count == 3) {
                    return false;
                }
            }
            if (l.next.idx == start) {
                l.next.val++;
            } else {
                Node newNode = new Node(start, 1);
                newNode.next = l.next;
                l.next = newNode;
                if (node == l)
                    node = node.next;
            }
            if (node.next == null) {
                node.next = new Node(end, -1);
            } else if (node.next.idx == end) {
                node.next.val--;
            } else {
                Node newNode = new Node(end, -1);
                newNode.next = node.next;
                node.next = newNode;
            }
        }
        //node = head;
        // while (node != null) {
        // System.out.print(node.idx + "(" + node.val + ") ");
        // node = node.next;
        // }
        // System.out.println();
        return true;
    }
}

class Node {
    int idx;
    int val;
    Node next;

    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
