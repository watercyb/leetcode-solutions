/*
 * Problem: 220. Contains Duplicate III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/contains-duplicate-iii/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        int div = valueDiff + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff)
                HM.remove(getDiv(nums[i - indexDiff - 1], div));
            int idx = getDiv(nums[i], div);
            if (HM.containsKey(idx))
                return true;
            if (HM.containsKey(idx - 1) && HM.get(idx - 1) + valueDiff >= nums[i])
                return true;
            if (HM.containsKey(idx + 1) && HM.get(idx + 1) - valueDiff <= nums[i])
                return true;
            HM.put(idx, nums[i]);
        }
        return false;
    }

    public int getDiv(int num, int div) {
        int res = num / div;
        if (num < 0)
            res--;
        return res;
    }
}
