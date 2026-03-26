/*
 * Problem: 131. Palindrome Partitioning
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/palindrome-partitioning/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> strs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            strs.add(new ArrayList<>());
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                strs.get(l).add(s.substring( l, r + 1));
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                strs.get(l).add(s.substring( l, r + 1));
                l--;
                r++;
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(res, strs, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(List<List<String>> res, List<List<String>> strs, List<String> Li, int i) {
        if (i == strs.size()) {
            res.add(new ArrayList<>(Li));
        } else {
            for (String str : strs.get(i)) {
                Li.add(str);
                dfs(res, strs, Li, i + str.length());
                Li.remove(Li.size() - 1);
            }
        }
    }
}
