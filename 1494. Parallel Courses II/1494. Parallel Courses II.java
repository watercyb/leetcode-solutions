/*
 * Problem: 1494. Parallel Courses II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/parallel-courses-ii/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        List<Integer>[] links = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        int[] counts = new int[n];
        int[] counts1 = new int[n];
        for (int[] relation : relations) {
            int a = relation[0] - 1;
            int b = relation[1] - 1;
            links[a].add(b);
            counts[b]++;
            counts1[a]++;
        }
        int singles = 0;
        for (int i = 0; i < n; i++) {
            if (counts1[i] == 0 && counts[i] == 0) {
                singles++;
                counts[i] = -1;
            }
        }
        Queue<Node> PQ = new LinkedList<>();
        PQ.offer(new Node(counts, singles, 0));
        int stp = 0;
        int res = Integer.MAX_VALUE;
        while (!PQ.isEmpty()) {
            int size = PQ.size();
            for (int i = 0; i < size; i++) {
                Node current = PQ.poll();
                List<Integer> list = new ArrayList<>();
                boolean isEmpty = true;
                for (int j = 0; j < current.counts.length; j++) {
                    if (current.counts[j] == 0) {
                        list.add(j);
                        isEmpty = false;
                    } else if (current.counts[j] != -1) {
                        isEmpty = false;
                    }
                }
                if (isEmpty)
                    return Math.min(stp + (current.n + k - 1) / k, res);
                if (list.isEmpty())
                    continue;
                if (list.size() <= k) {
                    for (int idx : list) {
                        current.counts[idx] = -1;
                        for (int next : links[idx]) {
                            current.counts[next]--;
                        }
                    }
                    current.n = Math.max(current.n - k + list.size(), 0);
                    PQ.offer(current);
                } else {
                    dfs(links, current, list, new int[k], 0, 0, k, PQ);
                }
            }
            stp++;
            if (stp >= res)
                return res;
        }
        return res;
    }

    boolean[] seens = new boolean[1 << 16];

    public void dfs(List<Integer>[] links, Node node, List<Integer> list, int[] arr, int i, int n, int k,
            Queue<Node> PQ) {
        if (list.size() - i < k - n)
            return;
        if (k == n) {
            int[] counts = node.counts.clone();
            int h = node.h;
            for (int idx : arr) {
                counts[idx] = -1;
                h |= 1 << idx;
                for (int next : links[idx]) {
                    counts[next]--;
                }
            }
            if (!seens[h]) {
                seens[h] = true;
                PQ.offer(new Node(counts, node.n, h));
            }
            return;
        }
        dfs(links, node, list, arr, i + 1, n, k, PQ);
        arr[n] = list.get(i);
        dfs(links, node, list, arr, i + 1, n + 1, k, PQ);
    }
}

class Node {
    int[] counts;
    int n;
    int h;

    public Node(int[] counts, int n, int h) {
        this.counts = counts;
        this.n = n;
        this.h = h;
    }
}
