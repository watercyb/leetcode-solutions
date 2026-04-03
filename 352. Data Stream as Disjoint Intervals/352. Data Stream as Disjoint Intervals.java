/*
 * Problem: 352. Data Stream as Disjoint Intervals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * Language: java
 * Date: 2026-04-03
 */

class SummaryRanges {
    Node root = new Node(-1, -1);
    TreeSet<Node> TS = new TreeSet<>((a, b) -> a.l - b.l);

    public SummaryRanges() {
        TS.add(root);
    }

    public void addNum(int value) {
        Node node = TS.floor(new Node(value, value));
        if (node.l == -1) {
            if (node.next == null) {
                node.next = new Node(value, value);
                TS.add(node.next);
                node.next.prv = node;
            } else {
                node = node.next;
                if (node.l == value + 1) {
                    TS.remove(node);
                    node.l--;
                    TS.add(node);
                } else {
                    Node newNode = new Node(value, value);
                    TS.add(newNode);
                    node.prv.next = newNode;
                    newNode.prv = node.prv;
                    node.prv = newNode;
                    newNode.next = node;
                }
            }
        } else if (node.r < value) {
            Node next = node.next;
            if (next == null) {
                if (node.r == value - 1) {
                    node.r++;
                } else {
                    Node newNode = new Node(value, value);
                    TS.add(newNode);
                    newNode.prv = node;
                    node.next = newNode;
                }
            } else {
                if (next.l > value + 1) {
                    if (node.r == value - 1) {
                        node.r++;
                    } else {
                        Node newNode = new Node(value, value);
                        TS.add(newNode);
                        newNode.prv = node;
                        node.next = newNode;
                        newNode.next = next;
                        next.prv = newNode;
                    }
                } else if (next.l == value + 1) {
                    if (node.r == value - 1) {
                        TS.remove(next);
                        node.r = next.r;
                        node.next = next.next;
                        if (next.next != null)
                            next.next.prv = node;
                    } else {
                        TS.remove(next);
                        next.l--;
                        TS.add(next);
                    }
                }
            }
        }
    }

    public int[][] getIntervals() {
        int count = 0;
        Node node = root.next;
        while (node != null) {
            count++;
            node = node.next;
        }
        int[][] res = new int[count][];
        int idx = 0;
        node = root.next;
        while (node != null) {
            res[idx++] = new int[] { node.l, node.r };
            node = node.next;
        }
        return res;
    }
}

class Node {
    Node prv;
    Node next;
    int l;
    int r;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
