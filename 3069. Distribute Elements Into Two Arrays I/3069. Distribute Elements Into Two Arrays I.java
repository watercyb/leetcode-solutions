/*
 * Problem: 3069. Distribute Elements Into Two Arrays I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/distribute-elements-into-two-arrays-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int prv1 = nums[0];
        int prv2 = nums[1];
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (prv1 > prv2) {
                list1.add(nums[i]);
                prv1 = nums[i];
            } else {
                list2.add(nums[i]);
                prv2 = nums[i];
            }
        }
        int idx = 0;
        for (int num : list1) {
            nums[idx++] = num;
        }
        for (int num : list2) {
            nums[idx++] = num;
        }
        return nums;
    }
}
