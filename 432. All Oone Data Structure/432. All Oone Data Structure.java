/*
 * Problem: 432. All O`one Data Structure
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/all-oone-data-structure/
 * Language: java
 * Date: 2026-04-03
 */

class AllOne {
    HashMap<String, Integer> HM = new HashMap<>();
    HashMap<Integer, Node> HM1 = new HashMap<>();
    Node head = new Node(Integer.MIN_VALUE);
    Node tail = head;

    public AllOne() {

    }

    public void inc(String key) {
        if (HM.containsKey(key)) {
            int count = HM.get(key);
            HM.put(key, count + 1);
            Node node = HM1.get(count);
            if (node.stringCount == 1) {
                if (node.next == null || node.next.count != count + 1) {
                    node.count++;
                    HM1.remove(count);
                    HM1.put(count + 1, node);
                } else {
                    node.prv.next = node.next;
                    node.next.prv = node.prv;
                    node.next.stringCount++;
                    node.next.HS.add(key);
                    HM1.remove(count);
                }
            } else {
                if (node.next == null || node.next.count != count + 1) {
                    Node newNode = new Node(count + 1);
                    if (node.next != null) {
                        newNode.next = node.next;
                        node.next.prv = newNode;
                    } else {
                        tail = newNode;
                    }
                    node.next = newNode;
                    newNode.prv = node;
                    HM1.put(count + 1, newNode);
                    node.stringCount--;
                    node.HS.remove(key);
                    newNode.HS.add(key);
                } else {
                    node.stringCount--;
                    node.next.stringCount++;
                    node.HS.remove(key);
                    node.next.HS.add(key);
                }
            }
        } else {
            HM.put(key, 1);
            if (HM1.containsKey(1)) {
                Node node = HM1.get(1);
                node.stringCount++;
                node.HS.add(key);
            } else {
                Node newNode = new Node(1);
                HM1.put(1, newNode);
                if (head.next != null) {
                    newNode.next = head.next;
                    head.next.prv = newNode;
                } else {
                    tail = newNode;
                }
                head.next = newNode;
                newNode.prv = head;
                newNode.HS.add(key);
            }
        }
    }

    public void dec(String key) {
        int count = HM.get(key);
        Node node = HM1.get(count);
        if (count > 1) {
            HM.put(key, count - 1);
            if (node.stringCount == 1) {
                if (node.prv.count != count - 1) {
                    node.count--;
                    HM1.remove(count);
                    HM1.put(count - 1, node);
                } else {
                    if (node.next != null) {
                        node.next.prv = node.prv;
                        node.prv.next = node.next;
                    } else {
                        tail = node.prv;
                        node.prv.next = null;
                    }
                    node.prv.stringCount++;
                    node.prv.HS.add(key);
                    HM1.remove(count);
                }
            } else {
                if (node.prv.count != count - 1) {
                    Node newNode = new Node(count - 1);
                    newNode.prv = node.prv;
                    node.prv.next = newNode;
                    node.prv = newNode;
                    newNode.next = node;
                    HM1.put(count - 1, newNode);
                    node.stringCount--;
                    node.HS.remove(key);
                    newNode.HS.add(key);
                } else {
                    node.stringCount--;
                    node.prv.stringCount++;
                    node.HS.remove(key);
                    node.prv.HS.add(key);
                }
            }
        } else {
            HM.remove(key);
            if (node.stringCount == 1) {
                if (node.next != null) {
                    node.next.prv = node.prv;
                    node.prv.next = node.next;
                } else {
                    tail = head;
                    head.next = null;
                }
                HM1.remove(count);
            } else {
                node.stringCount--;
                node.HS.remove(key);
            }
        }
    }

    public String getMaxKey() {
        if (head == tail)
            return "";
        for (String str : tail.HS) {
            return str;
        }
        return "";
    }

    public String getMinKey() {
        if (head == tail)
            return "";
        for (String str : head.next.HS) {
            return str;
        }
        return "";
    }
}

class Node {
    Node prv;
    Node next;
    int stringCount = 1;
    int count = 1;
    HashSet<String> HS = new HashSet<>();

    public Node() {

    }

    public Node(int count) {
        this.count = count;
    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
