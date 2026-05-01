/*
 * Problem: 2855. Minimum Right Shifts to Sort the Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int l = nums.get(0);
        int i = 1;
        while (i < nums.size() && nums.get(i) >= nums.get(i - 1)) {
            i++;
        }
        if (i == nums.size())
            return 0;
        int idx = i;
        i++;
        while (i < nums.size() && nums.get(i) >= nums.get(i - 1)) {
            i++;
        }
        if (i != nums.size() || nums.getLast() > l)
            return -1;
        return nums.size() - idx;
    }
}
