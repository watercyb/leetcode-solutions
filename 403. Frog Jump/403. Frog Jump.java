/*
 * Problem: 403. Frog Jump
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/frog-jump/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] - stones[0] > 1)
            return false;
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            HM.put(stones[i], i);
        }
        boolean[][] meme = new boolean[stones.length][stones.length];
        return dfs(stones, HM, meme, 0, 1);
    }

    public boolean dfs(int[] stones, HashMap<Integer, Integer> HM, boolean[][] meme, int i, int j) {
        if (j == stones.length - 1)
            return true;
        if (meme[i][j])
            return false;
        meme[i][j] = true;
        int step = stones[j] - stones[i];
        for (int k = Math.max(step - 1, 1); k <= step + 1; k++) {
            if (HM.containsKey(stones[j] + k) && dfs(stones, HM, meme, j, HM.get(stones[j] + k)))
                return true;
        }
        return false;
    }
}
