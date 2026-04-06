/*
 * Problem: 682. Baseball Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/baseball-game/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int calPoints(String[] operations) {
        int[] nums = new int[operations.length];
        int idx = 0;
        for (String str : operations) {
            if (str.equals("C")) {
                idx--;
            } else if (str.equals("D")) {
                nums[idx] = 2 * nums[idx - 1];
                idx++;
            } else if (str.equals("+")) {
                nums[idx] = nums[idx - 1] + nums[idx - 2];
                idx++;
            } else {
                nums[idx++] = Integer.parseInt(str);
            }
        }
        int res = 0;
        for (int i = 0; i < idx; i++) {
            res += nums[i];
        }
        return res;
    }
}
