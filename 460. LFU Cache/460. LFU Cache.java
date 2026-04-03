/*
 * Problem: 460. LFU Cache
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lfu-cache/
 * Language: java
 * Date: 2026-04-03
 */

class LFUCache {
    HashMap<Integer, ListedNode> HM = new HashMap<>();
    Node[] nodes = new Node[100001];
    int capacity;
    int min = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (nodes[key] != null) {
            Node node = nodes[key];
            if (node.prv.key == -1 && node.next.key == -2) {
                HM.remove(node.freq);
                if (min == node.freq)
                    min++;
            } else {
                node.remove();
            }
            node.freq++;
            if (!HM.containsKey(node.freq)) {
                HM.put(node.freq, new ListedNode(node));
            } else {
                HM.get(node.freq).insert(node);
            }
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodes[key] != null) {
            Node node = nodes[key];
            node.val = value;
            if (node.prv.key == -1 && node.next.key == -2) {
                HM.remove(node.freq);
                if (min == node.freq)
                    min++;
            } else {
                node.remove();
            }
            node.freq++;
            if (!HM.containsKey(node.freq)) {
                HM.put(node.freq, new ListedNode(node));
            } else {
                HM.get(node.freq).insert(node);
            }
        } else {
            Node node = new Node(key, value);
            nodes[key] = node;
            if (capacity == 0) {
                int tmp = HM.get(min).head.next.key;
                if (nodes[tmp].next.key == -2) {
                    HM.remove(min);
                } else {
                    nodes[tmp].remove();
                }
                nodes[tmp] = null;
            } else {
                capacity--;
            }
            if (!HM.containsKey(1)) {
                HM.put(1, new ListedNode(node));
            } else {
                HM.get(1).insert(node);
            }
            min = 1;
        }
    }
}

class Node {
    int key;
    int val;
    int freq = 1;
    Node prv;
    Node next;

    public Node(int key) {
        this.key = key;
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public void remove() {
        prv.next = next;
        if (next != null)
            next.prv = prv;
    }
}

class ListedNode {
    Node head = new Node(-1);
    Node tail = new Node(-2);

    public ListedNode(Node node) {
        head.next = node;
        node.prv = head;
        tail.prv = node;
        node.next = tail;
    }

    public void insert(Node node) {
        tail.prv.next = node;
        node.prv = tail.prv;
        tail.prv = node;
        node.next = tail;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
