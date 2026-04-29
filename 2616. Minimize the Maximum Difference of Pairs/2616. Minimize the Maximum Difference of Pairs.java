/*
 * Problem: 2616. Minimize the Maximum Difference of Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, p, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int p, int mid) {
        for (int i=0;i < nums.length - 1;i++) {
            if (nums[i+1]-nums[i]<=mid) {
                p--;
                i++;
                if (p<=0) return true;
            }
        }
        return p<=0;
    }
}
