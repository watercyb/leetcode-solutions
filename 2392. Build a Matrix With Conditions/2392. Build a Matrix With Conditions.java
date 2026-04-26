/*
 * Problem: 2392. Build a Matrix With Conditions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/build-a-matrix-with-conditions/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowRanks = getRank(k, rowConditions);
        if (rowRanks == null)
            return new int[0][0];
        int[] colRanks = getRank(k, colConditions);
        if (colRanks == null)
            return new int[0][0];
        int[][] res = new int[k][k];
        for (int i = 1; i <= k; i++) {
            res[rowRanks[i]][colRanks[i]] = i;
        }
        return res;
    }

    public int[] getRank(int k, int[][] conditions) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            links.add(new ArrayList<>());
        }
        int[] counts = new int[k + 1];
        for (int[] condition : conditions) {
            links.get(condition[0]).add(condition[1]);
            counts[condition[1]]++;
        }
        int[] arr = new int[k];
        int l = 0;
        int r = 0;
        for (int i = 1; i <= k; i++) {
            if (counts[i] == 0)
                arr[r++] = i;
        }
        int[] res = new int[k + 1];
        int idx = 0;
        while (l < r) {
            int current = arr[l++];
            res[current] = idx++;
            for (int next : links.get(current)) {
                if (counts[next]-- == 1)
                    arr[r++] = next;
            }
        }
        if (idx != k)
            return null;
        return res;
    }
}
