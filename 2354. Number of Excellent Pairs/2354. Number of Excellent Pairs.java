/*
 * Problem: 2354. Number of Excellent Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-excellent-pairs/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> HS = new HashSet<>(nums.length, 0.99f);
        for (int num : nums) {
            HS.add(num);
        }
        int[] arr = new int[HS.size()];
        int idx = 0;
        for (int num : HS) {
            arr[idx++] = Integer.bitCount(num);
        }
        Arrays.sort(arr);
        int j = arr.length - 1;
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (j >= 0 && arr[j] + arr[i] >= k) {
                j--;
            }
            res += arr.length - 1 - j;
        }
        return res;
    }
}
