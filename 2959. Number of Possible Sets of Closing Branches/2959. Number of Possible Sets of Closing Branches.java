/*
 * Problem: 2959. Number of Possible Sets of Closing Branches
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-possible-sets-of-closing-branches/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        HashMap<Integer, Integer>[] links = new HashMap[n];
        for (int i = 0; i < n; i++) {
            links[i] = new HashMap<>();
        }
        for (int[] road : roads) {
            if (links[road[0]].getOrDefault(road[1], Integer.MAX_VALUE) > road[2]) {
                links[road[0]].put(road[1], road[2]);
                links[road[1]].put(road[0], road[2]);
            }
        }
        dfs(links, new boolean[n], 0, 0, maxDistance);
        return res;
    }

    int res = 0;

    public void dfs(HashMap<Integer, Integer>[] links, boolean[] removed, int i, int n, int maxDistance) {
        if (i == links.length) {
            if (chk(links, removed, n, maxDistance))
                res++;
            return;
        }
        dfs(links, removed, i + 1, n + 1, maxDistance);
        int[][] arr = new int[10][];
        int idx = 0;
        removed[i] = true;
        for (Map.Entry<Integer, Integer> entry : links[i].entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            arr[idx++] = new int[] { k, v };
            links[k].remove(i);
        }
        dfs(links, removed, i + 1, n, maxDistance);
        for (int j = 0; j < idx; j++) {
            links[arr[j][0]].put(i, arr[j][1]);
        }
        removed[i] = false;
    }

    public boolean chk(HashMap<Integer, Integer>[] links, boolean[] removed, int n, int maxDistance) {
        for (int i = 0; i < removed.length; i++) {
            if (!removed[i] && !bfs(links, i, n, maxDistance))
                return false;
        }
        return true;
    }

    public boolean bfs(HashMap<Integer, Integer>[] links, int i, int n, int maxDistance) {
        int[] stps = new int[links.length];
        Arrays.fill(stps, Integer.MAX_VALUE);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { i, 0 });
        stps[i] = 0;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            if (current[1] > maxDistance)
                break;
            if (stps[current[0]] != current[1])
                continue;
            n--;
            for (Map.Entry<Integer, Integer> entry : links[current[0]].entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue() + current[1];
                if (v < stps[k]) {
                    stps[k] = v;
                    PQ.offer(new int[] { k, v });
                }
            }
        }
        return n == 0;
    }
}
