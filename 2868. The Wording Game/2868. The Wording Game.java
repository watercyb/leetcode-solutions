/*
 * Problem: 2868. The Wording Game
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-wording-game/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public boolean canAliceWin(String[] a, String[] b) {
        String[][] strs = new String[2][27];
        String min = "}";
        for (String str : a) {
            int idx = str.charAt(0) - 'a' + 1;
            if (strs[0][idx] == null || strs[0][idx].compareTo(str) < 0)
                strs[0][idx] = str;
            if (min.compareTo(str) > 0)
                min = str;
        }
        int minIdx = min.charAt(0) - 'a';
        strs[0][minIdx] = min;
        for (String str : b) {
            int idx = str.charAt(0) - 'a' + 1;
            if (strs[1][idx] == null || strs[1][idx].compareTo(str) < 0)
                strs[1][idx] = str;
        }
        return !dfs(strs, minIdx + 1, 1, minIdx);
    }

    public boolean dfs(String[][] strs, int i, int j, int prv) {
        if ((strs[j][i] != null && strs[j][i].compareTo(strs[1 - j][prv]) > 0 && !dfs(strs, i, 1 - j, i))
                || (i < 25 && strs[j][i + 1] != null && !dfs(strs, i + 1, 1 - j, i + 1)))
            return true;
        return false;
    }
}
