/*
 * Problem: 1838. Frequency of the Most Frequent Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - min]++;
        }
        int l = counts.length - 1;
        while (counts[l] == 0) {
            l--;
        }
        int res = 0;
        long sum = 0;
        int count = 0;
        count += counts[l];
        sum += (long) counts[l] * l;
        l--;
        for (int r = l + 1; r >= 0; r--) {
            if (counts[r] == 0)
                continue;
            while (l >= 0 && (counts[l] == 0 || (long) count * r < sum + k)) {
                count += counts[l];
                sum += (long) counts[l] * l;
                l--;
            }
            long diff = (long) count * r - sum - k;
            int c = 0;
            if (diff > 0) {
                c = (int) (diff / (r - l - 1));
                if (diff % (r - l - 1) != 0)
                    c++;
            }
            res = Math.max(count - c, res);
            sum -= counts[r] * r;
            count -= counts[r];
        }
        return res;
    }
}
