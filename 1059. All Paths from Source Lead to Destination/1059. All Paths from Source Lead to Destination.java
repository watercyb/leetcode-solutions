/*
 * Problem: 1059. All Paths from Source Lead to Destination
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/all-paths-from-source-lead-to-destination/?envType=weekly-question&envId=2026-04-29
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
        }
        return dfs(links, new int[n], source, destination);
    }

    public boolean dfs(List<List<Integer>> links, int[] seens, int i, int destination) {
        for (int next : links.get(i)) {
            if (seens[next] != 0)
                return seens[next] == 2;
            seens[next] = 1;
            if (!dfs(links, seens, next, destination))
                return false;
            seens[next] = 2;
        }
        return links.get(i).size() != 0 || i == destination;
    }
}
