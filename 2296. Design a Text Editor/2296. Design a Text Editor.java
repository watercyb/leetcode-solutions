/*
 * Problem: 2296. Design a Text Editor
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-a-text-editor/
 * Language: java
 * Date: 2026-04-25
 */

class TextEditor {
    Node tail = new Node('@');
    Node node = tail;

    public TextEditor() {
        tail.next = new Node('#');
        tail.next.prv = tail;
    }

    public void addText(String text) {
        for (char chr : text.toCharArray()) {
            Node tmp = new Node(chr);
            if (node.prv != null) {
                node.prv.next = tmp;
                tmp.prv = node.prv;
            }
            node.prv = tmp;
            tmp.next = node;
        }
    }

    public int deleteText(int k) {
        int res = 0;
        while (node.prv != null && k > 0) {
            node.prv.val = node.val;
            node = node.prv;
            node.next = node.next.next;
            node.next.prv = node;
            res++;
            k--;
        }
        return res;
    }

    public String cursorLeft(int k) {
        while (node.prv != null && k > 0) {
            node = node.prv;
            k--;
        }
        StringBuilder res = new StringBuilder();
        Node tmp = node.prv;
        for (int i = 0; i < 10 && tmp != null; i++) {
            res.append(tmp.val);
            tmp = tmp.prv;
        }
        return res.reverse().toString();
    }

    public String cursorRight(int k) {
        while (node.val != '@' && k > 0) {
            node = node.next;
            k--;
        }
        StringBuilder res = new StringBuilder();
        Node tmp = node.prv;
        for (int i = 0; i < 10 && tmp != null; i++) {
            res.append(tmp.val);
            tmp = tmp.prv;
        }
        return res.reverse().toString();
    }
}

class Node {
    Node prv;
    Node next;
    char val = 0;

    public Node(char val) {
        this.val = val;
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
