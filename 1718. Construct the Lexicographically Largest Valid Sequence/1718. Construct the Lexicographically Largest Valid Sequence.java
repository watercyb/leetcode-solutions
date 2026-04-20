/*
 * Problem: 1718. Construct the Lexicographically Largest Valid Sequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[n * 2 - 1];
        dfs(new boolean[n + 1], res, 0);
        return res;
    }

    public boolean dfs(boolean[] seens, int[] res, int i) {
        if (i == res.length)
            return true;
        if (res[i] != 0) {
            return dfs(seens, res, i + 1);
        } else {
            for (int j = seens.length - 1; j > 1; j--) {
                if (!seens[j] && i + j < res.length && res[i + j] == 0) {
                    seens[j] = true;
                    res[i] = j;
                    res[i + j] = j;
                    if (dfs(seens, res, i + 1))
                        return true;
                    res[i] = 0;
                    res[i + j] = 0;
                    seens[j] = false;
                }
            }
            if (!seens[1]) {
                seens[1] = true;
                res[i] = 1;
                if (dfs(seens, res, i + 1))
                    return true;
                res[i] = 0;
                seens[1] = false;
            }
        }
        return false;
    }
}
