/*
 * Problem: 4077. Minimize Inversions in a Prefix Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-inversions-in-a-prefix-tree/
 * Language: java
 * Date: 2026-10-16
 */

class Solution {
    public int minInversions(String[] words, int[] target) {
        Node root = new Node('#');
        int res = 0;
        for (int i = 0; i < target.length; i++) {
            String word = words[target[i]];
            Node node = root;
            for (char chr : word.toCharArray()) {
                int idx = chr - 'a';
                for (Node n : node.nexts) {
                    if (n == null)
                        continue;
                    if (n.chrIdx != idx)
                        node.costs[idx][n.chrIdx] += n.count;
                }
                if (node.nexts[idx] == null)
                    node.nexts[idx] = new Node(idx);
                node = node.nexts[idx];
                node.count++;
            }
            node.idx = i;
            res += node.count - 1;
        }
        int cost = dfs(root);
        return res + cost;
    }

    public int dfs(Node node) {
        int res = getCost(node);
        for (Node next : node.nexts) {
            if (next != null)
                res += dfs(next);
        }
        return res;
    }

    public int getCost(Node node) {
        int count = 0;
        for (Node n : node.nexts) {
            if (n != null)
                count++;
        }
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            if (node.nexts[i] != null)
                arr[idx++] = i;
        }
        int len = 1 << arr.length;
        int[][] costs = new int[len][arr.length];
        int[] DP = new int[len];
        for (int i = 1; i < DP.length; i++) {
            int cost = Integer.MAX_VALUE;
            int h = i;
            while (h > 0) {
                int k = h & -h;
                h -= k;
                int j = 31 - Integer.numberOfLeadingZeros(k);
                int ii = i - k;
                if (ii != 0) {
                    int kk = ii & -ii;
                    costs[ii][j] = costs[ii - kk][j] + node.costs[arr[31 - Integer.numberOfLeadingZeros(kk)]][arr[j]];
                }
                cost = Math.min(cost, DP[i - k] + costs[i - k][j]);
            }
            DP[i] = cost;
        }
        return DP[len - 1];
    }

    public int getCost(List<Integer> list, Node[] arr, Node node, int i) {
        int cost = 0;
        int chrIdx = arr[i].chrIdx;
        for (int idx : list) {
            cost += node.costs[arr[idx].chrIdx][chrIdx];
        }
        return cost;
    }
}

class Node {
    Node[] nexts = new Node[10];
    int[][] costs = new int[10][10];
    int chrIdx;
    int idx = -1;
    int count = 0;

    public Node(int chrIdx) {
        this.chrIdx = chrIdx;
    }
}
