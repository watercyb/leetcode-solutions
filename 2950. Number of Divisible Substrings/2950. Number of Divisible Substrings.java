/*
 * Problem: 2950. Number of Divisible Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-divisible-substrings/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int countDivisibleSubstrings(String word) {
        int[] nums = new int[word.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 9 - ('z' - word.charAt(i)) / 3;
        }
        int res = 0;
        for (int i = 1; i < 10; i++) {
            HashMap<Integer, Integer> HM = new HashMap<>();
            HM.put(0, 1);
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j] - i;
                int count = HM.getOrDefault(sum, 0);
                res += count++;
                HM.put(sum, count);
            }
        }
        return res;
    }
}
