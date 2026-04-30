/*
 * Problem: 2791. Count Paths That Can Form a Palindrome in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-paths-that-can-form-a-palindrome-in-a-tree/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public long countPalindromePaths(List<Integer> parent, String s) {
        char[] chrs = s.toCharArray();
        int base = 1;
        for (int i = 'a'; i <= 'z'; i++) {
            masks[i] = base;
            base *= 2;
        }
        HashMap<Integer, Integer> HM = new HashMap<>();
        int[] mems = new int[chrs.length];
        for (int i = 1; i < chrs.length; i++) {
            int tmp = dfs(mems, parent, chrs, i);
            HM.put(tmp, HM.getOrDefault(tmp, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (k == 0 || k == (k & -k))
                res += 2 * v;
            for (int i = 'a'; i <= 'z'; i++) {
                res += (long) HM.getOrDefault(k ^ masks[i], 0) * v;
            }
            res += (long) v * (v - 1);
        }
        return res / 2;
    }

    int[] masks = new int['z' + 1];
    long res = 0;

    public int dfs(int[] mems, List<Integer> parent, char[] chrs, int i) {
        if (i == 0||mems[i] != 0)
            return mems[i];
        int tmp = parent.get(i);
        return mems[i] = dfs(mems, parent, chrs, tmp) ^ masks[chrs[i]];
    }
}
