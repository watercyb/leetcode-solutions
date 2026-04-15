/*
 * Problem: 1206. Design Skiplist
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-skiplist/
 * Language: java
 * Date: 2026-04-15
 */

class Skiplist {
    Node head = new Node(-1);
    Node tail = new Node(Integer.MAX_VALUE);
    int max = 1;
    int count = 0;

    public Skiplist() {
        head.next = tail;
        tail.prv = head;
    }

    public void addLevel() {
        Node node = head;
        while (node.nextLevel != null) {
            node = node.nextLevel;
        }
        Node prv = new Node(-1);
        node.nextLevel = prv;
        node = node.next;
        while (node != null) {
            Node newNode = new Node(node.val);
            node.nextLevel = newNode;
            prv.next = newNode;
            newNode.prv = prv;
            prv = newNode;
            node = node.next;
        }
    }

    public boolean search(int target) {
        Node node = head;
        while (node.val < target) {
            if (node.next.val <= target) {
                node = node.next;
            } else if (node.nextLevel != null) {
                node = node.nextLevel;
            } else {
                break;
            }
        }
        return node.val == target;
    }

    public void add(int num) {
        Node node = head;
        while (node.val < num) {
            if (node.next.val <= num) {
                node = node.next;
            } else if (node.nextLevel != null) {
                node = node.nextLevel;
            } else {
                break;
            }
        }
        if (node.val < num) {
            Node newNode = new Node(num);
            newNode.next = node.next;
            node.next.prv = newNode;
            node.next = newNode;
            newNode.prv = node;
            count++;
            if (count == max) {
                addLevel();
                max *= 2;
                count = 0;
            }
        } else {
            node.count++;
        }
    }

    public boolean erase(int num) {
        Node node = head;
        while (node.val < num) {
            if (node.next != null && node.next.val <= num) {
                node = node.next;
            } else if ((node.next == null || node.next.val > num) && node.nextLevel != null) {
                node = node.nextLevel;
            } else {
                break;
            }
        }
        if (node.val < num) {
            return false;
        } else {
            node.count--;
            if (node.count == 0) {
                while (node != null) {
                    node.prv.next = node.next;
                    node.next.prv = node.prv;
                    node = node.nextLevel;
                }
            }
            return true;
        }
    }
}

class Node {
    Node prv;
    Node next;
    Node nextLevel;
    int val = 0;
    int count = 1;

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
