/*
 * Problem: 830. Positions of Large Groups
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/positions-of-large-groups/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char prv = '#';
        int count = 0;
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr != prv) {
                if (count >= 3)
                    res.add(List.of(idx, i - 1));
                prv = chr;
                idx = i;
                count = 1;
            } else {
                count++;
            }
        }
        if (count >= 3)
            res.add(List.of(idx, s.length() - 1));
        return res;
    }
}
