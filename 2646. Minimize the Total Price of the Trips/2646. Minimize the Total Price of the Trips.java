/*
 * Problem: 2646. Minimize the Total Price of the Trips
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-the-total-price-of-the-trips/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        int[][] paths = new int[n][];
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
        }
        int[] path = new int[n];
        dfs(paths, links, path, 1, 0, -1);
        int[] counts = new int[n];
        for (int[] trip : trips) {
            int i = 0;
            int[] a = paths[trip[0]];
            int[] b = paths[trip[1]];
            int lim = Math.min(a.length, b.length) - 1;
            while (i < lim && a[i + 1] == b[i + 1]) {
                i++;
            }
            for (int j = i; j < a.length; j++) {
                counts[a[j]]++;
            }
            for (int j = i+1; j < b.length; j++) {
                counts[b[j]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += counts[i] * price[i];
        }
        int[] max = dfs(links, price, counts, 0, -1);
        return res - Math.max(max[0], max[1]) / 2;
    }

    public int[] dfs(List<List<Integer>> links, int[] price, int[] counts, int i, int prv) {
        int[] res = new int[2];
        int[][] nextRes = prv >= 0 ? new int[links.get(i).size() - 1][2] : new int[links.get(i).size()][2];
        int idx = 0;
        for (int next : links.get(i)) {
            if (next == prv)
                continue;
            nextRes[idx++] = dfs(links, price, counts, next, i);
        }
        for (int j = 0; j < nextRes.length; j++) {
            res[0] += nextRes[j][1];
            res[1] += Math.max(nextRes[j][0], nextRes[j][1]);
        }
        res[0] += counts[i] * price[i];
        return res;
    }

    public void dfs(int[][] paths, List<List<Integer>> links, int[] path, int idx, int i, int prv) {
        paths[i] = Arrays.copyOfRange(path, 0, idx);
        for (int next : links.get(i)) {
            if (next == prv)
                continue;
            path[idx] = next;
            dfs(paths, links, path, idx + 1, next, i);
        }
    }
}
