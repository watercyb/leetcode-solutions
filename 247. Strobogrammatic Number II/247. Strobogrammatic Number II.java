/*
 * Problem: 247. Strobogrammatic Number II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/strobogrammatic-number-ii/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public List<String> findStrobogrammatic(int n) {
        if (n == 1)
            return Arrays.asList("0", "1", "8");
        char[] chrs = new char[n];
        if (n % 2 == 1) {
            int mid = n / 2;
            for (int i = 0; i <= 2; i++) {
                chrs[mid] = chrs3[i];
                dfs(chrs, mid - 1, mid + 1);
            }
        } else {
            dfs(chrs, n / 2 - 1, n / 2);
        }
        return res;
    }

    char[] chrs1 = { '0', '1', '6', '8', '9' };
    char[] chrs2 = { '0', '1', '9', '8', '6' };
    char[] chrs3 = { '0', '1', '8' };
    List<String> res = new ArrayList<>();

    public void dfs(char[] chrs, int l, int r) {
        if (l == -1) {
            res.add(new String(chrs));
            return;
        }
        int lim = l == 0 ? 1 : 0;
        for (int i = lim; i < 5; i++) {
            chrs[l] = chrs1[i];
            chrs[r] = chrs2[i];
            dfs(chrs, l - 1, r + 1);
        }
    }
}
