/*
 * Problem: 2127. Maximum Employees to Be Invited to a Meeting
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int maximumInvitations(int[] favorite) {
        int[] linkCounts = new int[favorite.length];
        for (int i = 0; i < favorite.length; i++) {
            linkCounts[favorite[i]]++;
        }
        int[] Qu = new int[favorite.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < favorite.length; i++) {
            if (linkCounts[i] == 0)
                Qu[r++] = i;
        }
        int[] counts = new int[favorite.length];
        while (l < r) {
            int current = Qu[l++];
            counts[favorite[current]] = Math.max(counts[current] + 1, counts[favorite[current]]);
            if (linkCounts[favorite[current]]-- == 1)
                Qu[r++] = favorite[current];
            favorite[current] = -1;
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < favorite.length; i++) {
            if (favorite[i] >= 0) {
                groupCount = 0;
                int count = dfs(favorite, counts, i);
                if (count == 2) {
                    sum += groupCount + 2;
                } else {
                    max = Math.max(count, max);
                }
            }
        }
        return Math.max(sum, max);
    }

    int groupCount = 0;

    public int dfs(int[] favorite, int[] counts, int i) {
        if (favorite[i] == -1)
            return 0;
        groupCount += counts[i];
        int next = favorite[i];
        favorite[i] = -1;
        return dfs(favorite, counts, next) + 1;
    }
}
