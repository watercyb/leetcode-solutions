/*
 * Problem: 705. Design HashSet
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/design-hashset/
 * Language: java
 * Date: 2026-04-08
 */

class MyHashSet {
    Node[] nodes = new Node[1001];

    public MyHashSet() {

    }

    public void add(int key) {
        int k1 = key % 1000;
        int k2 = key / 1000;
        if (nodes[k1] == null)
            nodes[k1] = new Node(-1);
        Node node = nodes[k1];
        while (node.next != null && node.next.key <= k2) {
            node = node.next;
        }
        if (node.key < k2) {
            Node newNode = new Node(k2);
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    public void remove(int key) {
        int k1 = key % 1000;
        int k2 = key / 1000;
        if (nodes[k1] != null) {
            Node node = nodes[k1];
            while (node.next != null && node.next.key < k2) {
                node = node.next;
            }
            if (node.next != null && node.next.key == k2)
                node.next = node.next.next;
        }
    }

    public boolean contains(int key) {
        int k1 = key % 1000;
        int k2 = key / 1000;
        if (nodes[k1] == null)
            return false;
        Node node = nodes[k1];
        while (node.next != null && node.next.key <= k2) {
            node = node.next;
        }
        if (node.key == k2)
            return true;
        return false;
    }
}

class Node {
    Node next;
    int key = 0;

    public Node(int key) {
        this.key = key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
