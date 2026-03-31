/*
 * Problem: 294. Flip Game II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flip-game-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean canWin(String currentState) {
        int[] counts = new int[60];
        int count = 0;
        for (char chr : currentState.toCharArray()) {
            if (chr == '-') {
                counts[count]++;
                count = 0;
            } else {
                count++;
            }
        }
        counts[count]++;
        return dfs(counts);
    }

    static HashMap<String, Boolean> HM = new HashMap<>();

    public boolean dfs(int[] counts) {
        boolean res = false;
        String h = getH(counts);
        if (HM.containsKey(h))
            return HM.get(h);
        for (int i = 2; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j <= i - 2; j++) {
                    counts[j]++;
                    counts[i - 2 - j]++;
                    counts[i]--;
                    if (!dfs(counts))
                        res = true;
                    counts[j]--;
                    counts[i - 2 - j]--;
                    counts[i]++;
                }
            }
        }
        HM.put(h, res);
        return res;
    }

    public String getH(int[] counts) {
        StringBuilder SB = new StringBuilder();
        for (int i = 2; i < counts.length; i++) {
            if (counts[i] > 0)
                SB.append(i).append('_').append(counts[i]).append('_');
        }
        return SB.toString();
    }
}
