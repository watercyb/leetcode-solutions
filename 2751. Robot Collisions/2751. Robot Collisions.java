/*
 * Problem: 2751. Robot Collisions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/robot-collisions/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        char[] chrs = directions.toCharArray();
        Integer[] idx = new Integer[positions.length];
        for (int i = 0; i < positions.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);
        int[] St = new int[positions.length];
        int StIdx = 0;
        for (int i = 0; i < positions.length; i++) {
            if (chrs[idx[i]] == 'R') {
                St[StIdx++] = idx[i];
            } else {
                while (StIdx > 0 && chrs[St[StIdx - 1]] == 'R' && healths[idx[i]] > 0) {
                    int last = St[StIdx - 1];
                    if (healths[last] < healths[idx[i]]) {
                        StIdx--;
                        healths[last] = 0;
                        healths[idx[i]]--;
                    } else if (healths[last] == healths[idx[i]]) {
                        StIdx--;
                        healths[last] = 0;
                        healths[idx[i]] = 0;
                    } else {
                        healths[idx[i]] = 0;
                        if (--healths[last] == 0)
                            StIdx--;
                    }
                }
                if (healths[idx[i]] > 0)
                    St[StIdx++] = idx[i];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < healths.length; i++) {
            if (healths[i] > 0)
                res.add(healths[i]);
        }
        return res;
    }
}
