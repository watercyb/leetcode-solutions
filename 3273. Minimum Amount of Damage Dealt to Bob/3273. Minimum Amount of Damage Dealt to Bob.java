/*
 * Problem: 3273. Minimum Amount of Damage Dealt to Bob
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-amount-of-damage-dealt-to-bob/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        Node[] nodes = new Node[damage.length];
        for (int i = 0; i < damage.length; i++) {
            nodes[i] = new Node(damage[i], (health[i] + power - 1) / power);
        }
        Arrays.sort(nodes);
        long res = 0;
        long count = 0;
        for (int i = 0; i < nodes.length; i++) {
            count += nodes[i].count;
            res += count * nodes[i].damage;
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    int damage;
    int count;

    public Node(int damage, int count) {
        this.damage = damage;
        this.count = count;
    }

    @Override
    public int compareTo(Node node) {
        return node.damage * count - damage * node.count;
    }
}
