/*
 * Problem: 1632. Rank Transform of a Matrix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/rank-transform-of-a-matrix/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] links = new int[r * c];
        for (int i = 0; i < r; i++) {
            int base = i * c;
            for (int j = 0; j < c; j++) {
                links[base + j] = base + j;
            }
        }
        for (int i = 0; i < r; i++) {
            HashMap<Integer, Integer> HM = new HashMap<>();
            int base = i * c;
            for (int j = 0; j < c; j++) {
                int idx = base + j;
                if (!HM.containsKey(matrix[i][j])) {
                    HM.put(matrix[i][j], idx);
                } else {
                    links[unionFind(links, idx)] = HM.get(matrix[i][j]);
                }
            }
        }
        for (int i = 0; i < c; i++) {
            HashMap<Integer, Integer> HM = new HashMap<>();
            int idx = i;
            for (int j = 0; j < r; j++) {
                if (!HM.containsKey(matrix[j][i])) {
                    HM.put(matrix[j][i], unionFind(links, idx));
                } else {
                    links[unionFind(links, idx)] = HM.get(matrix[j][i]);
                }
                idx += c;
            }
        }
        List<Integer>[] groups = new ArrayList[r * c];
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < links.length; i++) {
            if (links[i] != i) {
                int idx = unionFind(links, i);
                if (groups[idx] == null)
                    groups[idx] = new ArrayList<>();
                groups[idx].add(i);
            } else {
                if (groups[i] == null)
                    groups[i] = new ArrayList<>();
                groups[i].add(i);
                list.add(new Node(matrix[i / c][i % c], i));
            }
        }
        Node[] nodes = new Node[list.size()];
        list.toArray(nodes);
        Arrays.sort(nodes, (a, b) -> a.val - b.val);
        int[] rows = new int[r];
        int[] cols = new int[c];
        for (Node node : nodes) {
            int rank = 0;
            for (int idx : groups[node.idx]) {
                rank = Math.max(Math.max(rows[idx / c], cols[idx % c]), rank);
            }
            rank++;
            for (int idx : groups[node.idx]) {
                rows[idx / c] = rank;
                cols[idx % c] = rank;
                matrix[idx / c][idx % c] = rank;
            }
        }
        // System.out.println(Arrays.toString(links));
        return matrix;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}

class Node {
    int val;
    int idx;

    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
