/*
 * Problem: 706. Design HashMap
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/design-hashmap/
 * Language: java
 * Date: 2026-04-08
 */

class MyHashMap {
    Node[] nodes = new Node[1001];

    public MyHashMap() {

    }

    public void put(int key, int value) {
        int k1 = key % 1000;
        int k2 = key / 1000;
        if (nodes[k1] == null)
            nodes[k1] = new Node(-1, -1);
        Node node = nodes[k1];
        while (node.next != null && node.next.key <= k2) {
            node = node.next;
        }
        if (node.key < k2) {
            Node newNode = new Node(k2, value);
            newNode.next = node.next;
            node.next = newNode;
        } else {
            node.val = value;
        }
    }

    public int get(int key) {
        int k1 = key % 1000;
        int k2 = key / 1000;
        if (nodes[k1] == null)
            return -1;
        Node node = nodes[k1];
        while (node.next != null && node.next.key <= k2) {
            node = node.next;
        }
        if (node.key == k2)
            return node.val;
        return -1;
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
}

class Node {
    Node next;
    int key = 0;
    int val = 0;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
