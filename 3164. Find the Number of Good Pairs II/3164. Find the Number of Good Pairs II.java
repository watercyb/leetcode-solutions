/*
 * Problem: 3164. Find the Number of Good Pairs II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-number-of-good-pairs-ii/?envType=problem-list-v2&envId=hash-table
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % k == 0) {
                nums1[i] = nums1[i] / k;
                max = Math.max(max, nums1[i]);
            } else {
                nums1[i] = -1;
            }
        }
        int[] counts = new int[max + 1];
        for (int num : nums1) {
            if (num >= 0)
                counts[num]++;
        }
        int[] memes = new int[max + 1];
        Arrays.fill(memes, -1);
        long res = 0;
        for (int num : nums2) {
            if (num > max)
                continue;
            if (memes[num] >= 0) {
                res += memes[num];
            } else {
                int count = 0;
                for (int i = num; i <= max; i += num) {
                    count += counts[i];
                }
                res += count;
                memes[num] = count;
            }
        }
        return res;
    }
}
