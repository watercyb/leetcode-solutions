/*
 * Problem: 1366. Rank Teams by Votes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rank-teams-by-votes/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] ranks = new int[26][n + 1];
        for (int i = 0; i < 26; i++) {
            ranks[i][n] = i + 'A';
        }
        for (int i = 0; i < votes.length; i++) {
            char[] chrs = votes[i].toCharArray();
            for (int j = 0; j < chrs.length; j++) {
                ranks[chrs[j] - 'A'][j]++;
            }
        }
        Arrays.sort(ranks, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                for (int i = 0; i < n; i++) {
                    if (a[i] != b[i])
                        return b[i] - a[i];
                }
                return a[n] - b[n];
            }
        });
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append((char) ranks[i][n]);
        }
        return res.toString();
    }
}
