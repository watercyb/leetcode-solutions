/*
 * Problem: 347. Top K Frequent Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] counts = new int[max - min + 1];
        int maxCount = Integer.MIN_VALUE;
        for (int num : nums) {
            maxCount = Math.max(maxCount, ++counts[num - min]);
        }
        int[] freqs = new int[maxCount + 1];
        for (int count : counts) {
            freqs[count]++;
        }
        int idx = maxCount;
        int[] res=new int[k];
        while (k > 0) {
            if (freqs[idx] >= k) {
                k = 0;
            } else {
                k -= freqs[idx];
                idx--;
            }
        }
        int idx1=0;
        for (int i=0;i<counts.length;i++) {
            if (counts[i]>=idx) res[idx1++]=i+min;
        }
        return res;
    }
}
