/*
 * Problem: 1726. Tuple with Same Product
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/tuple-with-same-product/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pro = nums[i] * nums[j];
                int count = HM.getOrDefault(pro, 0);
                res += count;
                count++;
                HM.put(pro, count);
            }
        }
        return res * 8;
    }
}
