/*
 * Problem: 1733. Minimum Number of People to Teach
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-people-to-teach/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        boolean[][] knows = new boolean[languages.length][n];
        for (int i = 0; i < languages.length; i++) {
            for (int l : languages[i]) {
                knows[i][l - 1] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < friendships.length; i++) {
            int a = friendships[i][0] - 1;
            int b = friendships[i][1] - 1;
            boolean same = false;
            for (int j = 0; j < n; j++) {
                if (knows[a][j] && knows[b][j]) {
                    same = true;
                    break;
                }
            }
            if (!same)
                list.add(i);
        }
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = friendships[list.get(i)];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean[] learns = new boolean[languages.length];
            int count = 0;
            for (int[] friendship : arr) {
                int a = friendship[0] - 1;
                int b = friendship[1] - 1;
                if (!knows[a][i] && !learns[a]) {
                    learns[a] = true;
                    count++;
                }
                if (!knows[b][i] && !learns[b]) {
                    learns[b] = true;
                    count++;
                }
            }
            res = Math.min(res, count);
        }
        return res;
    }
}
