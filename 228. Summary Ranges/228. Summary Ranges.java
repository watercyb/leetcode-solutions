/*
 * Problem: 228. Summary Ranges
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/summary-ranges/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        StringBuilder SB = new StringBuilder();
        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != right + 1) {
                if (left == right) {
                    res.add(SB.append(String.valueOf(left)).toString());
                    SB.setLength(0);
                    left = nums[i];
                } else {
                    res.add(SB.append(String.valueOf(left)).append("->").append(String.valueOf(right)).toString());
                    SB.setLength(0);
                    left = nums[i];
                }
            }
            right = nums[i];
        }
        if (left == right) {
            res.add(SB.append(String.valueOf(left)).toString());
        } else {
            res.add(SB.append(String.valueOf(left)).append("->").append(String.valueOf(right)).toString());
        }
        return res;
    }
}
