/*
 * Problem: 1192. Critical Connections in a Network
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/critical-connections-in-a-network/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(01);
            lists[a].add(b);
            lists[b].add(a);
        }
        int[][] links = new int[n][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        dfs(links, new int[n], 0, -1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    int stp = 1;

    public int dfs(int[][] links, int[] stps, int i, int prv) {
        stps[i] = stp++;
        int min = Integer.MAX_VALUE;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            if (stps[next] == 0) {
                stps[next] = dfs(links, stps, next, i);
                if (stps[next] > stps[i])
                    res.add(Arrays.asList(new Integer[] { i, next }));
            }
            min = Math.min(stps[next], min);
        }
        return min;
    }
}
