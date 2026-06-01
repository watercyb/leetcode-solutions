/*
 * Problem: 3948. Lexicographically Maximum MEX Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lexicographically-maximum-mex-array/
 * Language: java
 * Date: 2026-06-01
 */

class Solution {
    public int[] maximumMEX(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 2];
        for (int num : nums) {
            counts[num]++;
        }
        List<Integer> list = new ArrayList<>();
        int lim = 0;
        int[] used = new int[max + 1];
        while (lim < nums.length) {
            int count = 0;
            int idx = 0;
            while (counts[idx] != 0) {
                count++;
                used[idx]++;
                idx++;
            }
            if (idx == 0)
                break;
            list.add(idx);
            while (count > 0) {
                int num = nums[lim++];
                if (used[num] > 0) {
                    used[num]--;
                    count--;
                }
                counts[num]--;
            }
        }
        while (lim < nums.length) {
            list.add(0);
            lim++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
