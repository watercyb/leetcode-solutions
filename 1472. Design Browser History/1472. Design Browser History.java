/*
 * Problem: 1472. Design Browser History
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-browser-history/
 * Language: java
 * Date: 2026-04-17
 */

class BrowserHistory {
    LinkedNode node;

    public BrowserHistory(String homepage) {
        node = new LinkedNode(homepage);
    }

    public void visit(String url) {
        node.next = new LinkedNode(url, node);
        node = node.next;
    }

    public String back(int steps) {
        while (steps > 0 && node.prv != null) {
            steps--;
            node = node.prv;
        }
        return node.url;
    }

    public String forward(int steps) {
        while (steps > 0 && node.next != null) {
            steps--;
            node = node.next;
        }
        return node.url;
    }
}

class LinkedNode {
    String url;
    LinkedNode prv;
    LinkedNode next;

    public LinkedNode(String url) {
        this.url = url;
    }

    public LinkedNode(String url, LinkedNode prv) {
        this.url = url;
        this.prv = prv;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
