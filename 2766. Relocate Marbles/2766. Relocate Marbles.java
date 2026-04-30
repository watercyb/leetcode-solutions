/*
 * Problem: 2766. Relocate Marbles
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/relocate-marbles/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> HS = new HashSet<>(nums.length, 0.99f);
        for (int num : nums) {
            HS.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            if (moveTo[i] == moveFrom[i])
                continue;
            HS.add(moveTo[i]);
            HS.remove(moveFrom[i]);
        }
        Integer[] res = new Integer[HS.size()];
        int idx = 0;
        for (int num : HS) {
            res[idx++] = num;
        }
        Arrays.sort(res);
        return Arrays.asList(res);
    }
}
