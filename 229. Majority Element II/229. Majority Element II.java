/*
 * Problem: 229. Majority Element II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/majority-element-ii/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MAX_VALUE;
        int c1 = 0;
        int c2 = 0;
        for (int num : nums) {
            if (r1 == num) {
                c1++;
            } else if (r2 == num) {
                c2++;
            } else if (c1 == 0) {
                r1 = num;
                c1++;
                continue;
            } else if (c2 == 0) {
                r2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (r1 == num) {
                c1++;
            } else if (r2 == num) {
                c2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (c1 > nums.length / 3)
            res.add(r1);
        if (c2 > nums.length / 3)
            res.add(r2);
        return res;
    }
}
