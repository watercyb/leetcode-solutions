/*
 * Problem: 179. Largest Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-number/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> new StringBuilder(b).append(a).toString()
                .compareTo(new StringBuilder(a).append(b).toString()));
        StringBuilder SB = new StringBuilder();
        boolean beginning = true;
        for (String str : strs) {
            if (beginning) {
                if (str.equals("0")) {
                    continue;
                } else {
                    beginning = false;
                }
            }
            SB.append(str);
        }
        if (SB.length() == 0)
            return "0";
        return SB.toString();
    }
}
