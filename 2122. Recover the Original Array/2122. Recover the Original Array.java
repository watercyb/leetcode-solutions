/*
 * Problem: 2122. Recover the Original Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/recover-the-original-array/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (chk(nums, i))
                return getArr(nums, i);
        }
        return null;
    }

    public boolean chk(int[] nums, int dist) {
        int i = 0;
        int j = dist;
        int diff = nums[j] - nums[i];
        if ((diff & 1) == 1 || diff == 0)
            return false;
        boolean[] used = new boolean[nums.length];
        for (int k = 0; k < nums.length / 2; k++) {
            while (used[i]) {
                i++;
            }
            while (j < nums.length && nums[j] - nums[i] != diff) {
                j++;
            }
            if (j == nums.length)
                return false;
            i++;
            used[j] = true;
            j++;
        }
        return true;
    }

    public int[] getArr(int[] nums, int dist) {
        int i = 0;
        int j = dist;
        int diff = nums[j] - nums[i];
        int[] res = new int[nums.length / 2];
        boolean[] used = new boolean[nums.length];
        for (int k = 0; k < nums.length / 2; k++) {
            while (used[i]) {
                i++;
            }
            while (j < nums.length && nums[j] - nums[i] != diff) {
                j++;
            }
            res[k] = nums[i] + diff / 2;
            i++;
            used[j] = true;
            j++;
        }
        return res;
    }
}
