/*
 * Problem: 2502. Design Memory Allocator
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-memory-allocator/
 * Language: java
 * Date: 2026-04-28
 */

class Allocator {
    Node head;
    Node tail;
    HashMap<Integer, List<Node>> HM = new HashMap<>();

    public Allocator(int n) {
        head = new Node(-1, -1, null, null);
        tail = new Node(n, n, head, null);
        head.next = tail;
    }

    public int allocate(int size, int mID) {
        Node node = head;
        while (node.next != null) {
            if (node.next.start - node.end > size) {
                Node newNode = new Node(node.end + 1, node.end + size, node, node.next);
                node.next.prv = newNode;
                node.next = newNode;
                if (!HM.containsKey(mID)) {
                    List<Node> list = new ArrayList<>();
                    list.add(newNode);
                    HM.put(mID, list);
                } else {
                    HM.get(mID).add(newNode);
                }
                return newNode.start;
            }
            node = node.next;
        }
        return -1;
    }

    public int free(int mID) {
        if (!HM.containsKey(mID))
            return 0;
        int res = 0;
        List<Node> list = HM.get(mID);
        for (Node node : list) {
            res += node.end - node.start + 1;
            node.prv.next = node.next;
            node.next.prv = node.prv;
        }
        HM.remove(mID);
        return res;
    }
}

class Node {
    Node prv;
    Node next;
    int start = 0;
    int end = 0;

    public Node(int start, int end, Node prv, Node next) {
        this.prv = prv;
        this.next = next;
        this.start = start;
        this.end = end;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
