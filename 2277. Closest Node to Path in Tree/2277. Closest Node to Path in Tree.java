/*
 * Problem: 2277. Closest Node to Path in Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/closest-node-to-path-in-tree/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        int[] counts = new int[n];
        HashSet<Integer>[] HS = new HashSet[n];
        HashSet<Integer>[] HS1 = new HashSet[n];
        List<List<Integer>> Links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HS[i] = new HashSet<>();
            HS1[i] = new HashSet<>();
            Links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
            HS[edge[0]].add(edge[1]);
            HS[edge[1]].add(edge[0]);
        }
        Queue<Integer> Qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1) {
                Qu.offer(i);
            }
        }
        while (!Qu.isEmpty()) {
            int tmp = Qu.poll();
            if (HS[tmp].size() > 0) {
                int next = 0;
                for (int in : HS[tmp]) {
                    next = in;
                }
                HS[next].remove(tmp);
                Links.get(tmp).add(next);
                if (HS[next].size() == 1) {
                    Qu.offer(next);
                }
            }
        }
        System.out.println(Arrays.toString(counts));
        for (List<Integer> tmp : Links) {
            System.out.println(tmp);
        }
        for (HashSet<Integer> tmp : HS) {
            System.out.println(tmp);
        }
        for (int i = 0; i < n; i++) {
            int j = i;
            HS1[i].add(j);
            while (Links.get(j).size() != 0) {
                j = Links.get(j).get(0);
                HS1[i].add(j);
            }
        }
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            if (query[i][0] != query[i][1]) {
                int[] a = getLCP(Links, HS1, query[i][0], query[i][1]);
                int[] b = getLCP(Links, HS1, query[i][2], query[i][1]);
                int[] c = getLCP(Links, HS1, query[i][2], query[i][0]);
                if (b[0] != c[0]) {
                    if (b[1] < c[1]) {
                        res[i] = b[0];
                    } else {
                        res[i] = c[0];
                    }
                } else if (a[0] != b[0]) {
                    res[i]=a[0];
                } else {
                    res[i] = b[0];
                }
            } else {
                res[i] = query[i][0];
            }
        }
        return res;
    }

    public int[] getLCP(List<List<Integer>> Links, HashSet<Integer>[] HS1, int i, int j) {
        System.out.println(i + " " + j);
        int[] res = { i, 0 };
        while (!HS1[j].contains(res[0])) {
            res[0] = Links.get(res[0]).get(0);
            res[1]++;
        }
        return res;
    }
}
