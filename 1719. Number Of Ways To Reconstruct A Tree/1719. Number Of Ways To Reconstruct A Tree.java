/*
 * Problem: 1719. Number Of Ways To Reconstruct A Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int checkWays(int[][] pairs) {
        int[] counts = new int[500];
        int count = 0;
        for (int[] pair : pairs) {
            pair[0]--;
            pair[1]--;
            if (counts[pair[0]]++ == 0)
                count++;
            if (counts[pair[1]]++ == 0)
                count++;
        }
        List<Integer>[] links = new ArrayList[500];
        for (int i = 0; i < links.length; i++) {
            links[i] = new ArrayList<>();
        }
        boolean canSwitch = false;
        for (int[] pair : pairs) {
            if (counts[pair[0]] > counts[pair[1]]) {
                links[pair[0]].add(pair[1]);
            } else if (counts[pair[0]] < counts[pair[1]]) {
                links[pair[1]].add(pair[0]);
            } else {
                links[pair[0]].add(pair[1]);
                links[pair[1]].add(pair[0]);
                canSwitch = true;
            }
        }
        int root = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == count - 1)
                root = i;
        }
        if (root == -1 || !dfs(links, counts, new boolean[500], root, 0))
            return 0;
        if (canSwitch)
            return 2;
        return 1;
    }

    public boolean dfs(List<Integer>[] links, int[] counts, boolean[] seens, int i, int lv) {
        seens[i] = true;
        int count = 0;
        Collections.sort(links[i], (a, b) -> counts[b] - counts[a]);
        for (int next : links[i]) {
            if (seens[next])
                continue;
            count += counts[next] - lv;
            if (count > counts[i] + lv || !dfs(links, counts, seens, next, lv + 1))
                return false;
        }
        return count + lv == counts[i];
    }
}
