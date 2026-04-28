/*
 * Problem: 2508. Add Edges to Make Degrees of All Nodes Even
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/add-edges-to-make-degrees-of-all-nodes-even/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            links.add(new ArrayList<>());
        }
        boolean[] odds = new boolean[n + 1];
        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            links.get(a).add(b);
            links.get(b).add(a);
            odds[a] = !odds[a];
            odds[b] = !odds[b];
        }
        List<Integer> oddList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (odds[i]) {
                oddList.add(i);
                if (oddList.size() > 4)
                    return false;
            }
        }
        if (oddList.size() == 0)
            return true;
        if (oddList.size() == 2) {
            int a = oddList.get(0);
            int b = oddList.get(1);
            for (int idx : links.get(a)) {
                if (idx == b) {
                    boolean[] connected = new boolean[n + 1];
                    for (int idxA : links.get(a)) {
                        connected[idxA] = true;
                    }
                    for (int idxB : links.get(b)) {
                        connected[idxB] = true;
                    }
                    for (int i = 1; i <= n; i++) {
                        if (!connected[i])
                            return true;
                    }
                    return false;
                }
            }
            return true;
        }
        if (oddList.size() == 4) {
            int a = oddList.get(0);
            int b = oddList.get(1);
            int c = oddList.get(2);
            int d = oddList.get(3);
            if ((!isConnected(links, a, b) && !isConnected(links, c, d))
                    || (!isConnected(links, a, c) && !isConnected(links, b, d))
                    || (!isConnected(links, a, d) && !isConnected(links, b, c)))
                return true;
        }
        return false;
    }

    public boolean isConnected(List<List<Integer>> links, int a, int b) {
        for (int idx : links.get(a)) {
            if (idx == b)
                return true;
        }
        return false;
    }
}
