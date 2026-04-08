/*
 * Problem: 707. Design Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-linked-list/
 * Language: java
 * Date: 2026-04-08
 */

class MyLinkedList {
    Node head = new Node(-1);
    Node tail = head;
    int size = 0;

    public MyLinkedList() {
        head.next = tail;
    }

    public int get(int index) {
        if (index >= size)
            return -1;
        Node node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        if (size++ == 0)
            tail = node;
    }

    public void addAtTail(int val) {
        tail.next = new Node(val);
        tail = tail.next;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            Node newNode = new Node(val);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size)
            return;
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        size--;
        if (index == size)
            tail = node;
    }
}

class Node {
    Node next;
    int val = 0;

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
