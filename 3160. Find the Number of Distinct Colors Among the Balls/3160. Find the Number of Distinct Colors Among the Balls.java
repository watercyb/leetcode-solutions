/*
 * Problem: 3160. Find the Number of Distinct Colors Among the Balls
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        HashMap<Integer, Integer> HM1 = new HashMap<>();
        int[] res = new int[queries.length];
        int count = 0;
        for (int i = 0; i < queries.length; i++) {
            int color = HM.getOrDefault(queries[i][0], 0);
            if (color != 0) {
                int n = HM1.get(color);
                if (n == 1)
                    count--;
                HM1.put(color, n - 1);
            }
            int n = HM1.getOrDefault(queries[i][1], 0) + 1;
            if (n == 1)
                count++;
            HM1.put(queries[i][1], n);
            res[i] = count;
            HM.put(queries[i][0], queries[i][1]);
        }
        return res;
    }
}
