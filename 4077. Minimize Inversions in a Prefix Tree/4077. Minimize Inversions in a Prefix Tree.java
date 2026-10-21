/*
 * Problem: 4077. Minimize Inversions in a Prefix Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-inversions-in-a-prefix-tree/
 * Language: java
 * Date: 2026-10-21
 */

class Solution {
    public int minInversions(String[] words, int[] target) {
        Node root = new Node();

        // Build the trie structure in target order.
        for (int i = 0; i < target.length; i++) {
            String word = words[target[i]];
            Node node = root;

            for (char chr : word.toCharArray()) {
                int idx = chr - 'a';
                if (node.nexts[idx] == null) {
                    node.nexts[idx] = new Node();
                }
                node = node.nexts[idx];
            }
        }

        // First DFS: count children and build the compact index map.
        prepare(root);

        // Second DFS: allocate compact cost matrices.
        allocateCosts(root);

        int res = 0;

        // Replay insertion order to calculate counts and inversion costs.
        for (int i = 0; i < target.length; i++) {
            String word = words[target[i]];
            Node node = root;

            for (char chr : word.toCharArray()) {
                int idx = chr - 'a';

                for (int j = 0; j < 10; j++) {
                    Node next = node.nexts[j];
                    if (next == null || j == idx) {
                        continue;
                    }

                    node.costs[node.indexes[idx]][node.indexes[j]] += next.count;
                }

                node = node.nexts[idx];
                node.count++;
            }

            res += node.count - 1;
        }

        return res + dfs(root);
    }

    private void prepare(Node node) {
        Arrays.fill(node.indexes, -1);
        node.childCount = 0;

        for (int i = 0; i < 10; i++) {
            if (node.nexts[i] != null) {
                node.indexes[i] = node.childCount++;
            }
        }

        for (Node next : node.nexts) {
            if (next != null) {
                prepare(next);
            }
        }
    }

    private void allocateCosts(Node node) {
        node.costs = new int[node.childCount][node.childCount];

        for (Node next : node.nexts) {
            if (next != null) {
                allocateCosts(next);
            }
        }
    }

    private int dfs(Node node) {
        int res = getCost(node);

        for (Node next : node.nexts) {
            if (next != null) {
                res += dfs(next);
            }
        }

        return res;
    }

    private int getCost(Node node) {
        int count = node.childCount;

        if (count <= 1) {
            return 0;
        }

        int len = 1 << count;
        int[][] costs = new int[len][count];
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            int best = Integer.MAX_VALUE;
            int h = i;

            while (h > 0) {
                int bit = h & -h;
                h -= bit;

                int j = Integer.numberOfTrailingZeros(bit);
                int prev = i - bit;

                if (prev != 0) {
                    int prevBit = prev & -prev;
                    int prevIdx = Integer.numberOfTrailingZeros(prevBit);

                    costs[prev][j] = costs[prev - prevBit][j]
                            + node.costs[prevIdx][j];
                }

                best = Math.min(best, dp[prev] + costs[prev][j]);
            }

            dp[i] = best;
        }

        return dp[len - 1];
    }
}

class Node {
    Node[] nexts = new Node[10];
    int[] indexes = new int[10];
    int count = 0;
    int childCount = 0;
    int[][] costs;
}
