/*
 * Problem: 464. Can I Win
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/can-i-win/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0)
            return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false;
        return dfs(new Boolean[1 << maxChoosableInteger], 0, 0, maxChoosableInteger, desiredTotal);
    }

    public boolean dfs(Boolean[] meme, int h, int sum, int max, int target) {
        if (sum >= target)
            return false;
        if (meme[h] != null)
            return meme[h];
        int mask = h ^ (meme.length - 1);
        while (mask > 0) {
            int h1 = mask & -mask;
            mask -= h1;
            if (!dfs(meme, h + h1, sum + 32 - Integer.numberOfLeadingZeros(h1), max, target))
                return meme[h] = true;
        }
        return meme[h] = false;
    }
}
