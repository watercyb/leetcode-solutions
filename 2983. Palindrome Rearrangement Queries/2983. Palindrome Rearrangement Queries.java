/*
 * Problem: 2983. Palindrome Rearrangement Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindrome-rearrangement-queries/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        int l = -1;
        int r = 0;
        int n = chrs.length / 2;
        int[] diffs = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (chrs[i] != chrs[chrs.length - 1 - i]) {
                if (l == -1)
                    l = i;
                r = i;
                diffs[i + 1] = diffs[i] + 1;
                counts[chrs[i] - 'a']++;
                counts[chrs[chrs.length - 1 - i] - 'a']--;
            }
        }
        for (int count : counts) {
            if (count != 0)
                return new boolean[queries.length];
        }
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int[] leftRev = new int[n + 1];
        int[] rightRev = new int[n + 1];
        int count = 0;
        int j = chrs.length - 1;
        for (int i = 0; i < n; i++) {
            if (counts[chrs[i] - 'a'] == 0)
                count++;
            counts[chrs[i] - 'a']++;
            while (count > 0) {
                if (counts[chrs[j] - 'a'] == 1)
                    count--;
                counts[chrs[j] - 'a']--;
                j--;
            }
            left[i + 1] = chrs.length - 1 - j;
        }
        j = 0;
        for (int i = chrs.length - 1; i >= n; i--) {
            if (counts[chrs[i] - 'a'] == 0)
                count++;
            counts[chrs[i] - 'a']++;
            while (count > 0) {
                if (counts[chrs[j] - 'a'] == 1)
                    count--;
                counts[chrs[j] - 'a']--;
                j++;
            }
            right[chrs.length - 1 - i + 1] = j;
        }
        j = n;
        for (int i = n - 1; i >= 0; i--) {
            if (counts[chrs[i] - 'a'] == 0)
                count++;
            counts[chrs[i] - 'a']++;
            while (count > 0) {
                if (counts[chrs[j] - 'a'] == 1)
                    count--;
                counts[chrs[j] - 'a']--;
                j++;
            }
            leftRev[i] = chrs.length - 1 - j;
        }
        j = n - 1;
        for (int i = n; i < chrs.length; i++) {
            if (counts[chrs[i] - 'a'] == 0)
                count++;
            counts[chrs[i] - 'a']++;
            while (count > 0) {
                if (counts[chrs[j] - 'a'] == 1)
                    count--;
                counts[chrs[j] - 'a']--;
                j--;
            }
            rightRev[chrs.length - 1 - i] = j;
        }
        boolean[] res = new boolean[queries.length];
        if (l == -1) {
            Arrays.fill(res, true);
            return res;
        }
        for (int i = 0; i < queries.length; i++) {
            int l1 = queries[i][0];
            int l2 = queries[i][1];
            int r1 = chrs.length - 1 - queries[i][3];
            int r2 = chrs.length - 1 - queries[i][2];
            if (Math.min(l1, r1) > l || Math.max(l2, r2) < r)
                continue;
            if ((l1 <= l && l2 >= r) || (r1 <= l && r2 >= r)) {
                res[i] = true;
                continue;
            }
            if (l2 < r1 || r2 < l1) {
                if (diffs[Math.max(l1, r1)] - diffs[Math.min(l2, r2) + 1] > 0)
                    continue;
                if (l2 < r1) {
                    if (right[l2] - 1 != l2 || leftRev[r1] + 1 != r1)
                        continue;
                } else if (left[r2] - 1 != r2 || rightRev[l1] + 1 != l1) {
                    continue;
                }
            } else if (l1 < r1) {
                if (right[r1] - 1 > l2 || leftRev[l2 + 1] + 1 < r1)
                    continue;
            } else if (left[l1] - 1 > r2 || rightRev[r2 + 1] + 1 < l1) {
                continue;
            }
            res[i] = true;
        }
        return res;
    }
}
