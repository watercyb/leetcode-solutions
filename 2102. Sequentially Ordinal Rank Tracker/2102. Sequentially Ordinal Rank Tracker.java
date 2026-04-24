/*
 * Problem: 2102. Sequentially Ordinal Rank Tracker
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sequentially-ordinal-rank-tracker/
 * Language: java
 * Date: 2026-04-24
 */

class SORTracker {
    PriorityQueue<Node> PQBefore = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Node> PQAfter = new PriorityQueue<>();

    public SORTracker() {

    }

    public void add(String name, int score) {
        Node tmp = new Node(name, score);
        if (PQBefore.size() == 0) {
            PQAfter.offer(tmp);
        } else {
            Node tmp1 = PQBefore.peek();
            if (tmp.compareTo(tmp1) > 0) {
                PQAfter.offer(tmp);
            } else {
                PQBefore.poll();
                PQBefore.offer(tmp);
                PQAfter.offer(tmp1);
            }
        }
    }

    public String get() {
        Node tmp = PQAfter.poll();
        PQBefore.offer(tmp);
        return tmp.name;
    }
}

class Node implements Comparable<Node> {
    String name;
    int score;

    public Node(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Node node) {
        if (score == node.score)
            return name.compareTo(node.name);
        return node.score - score;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
