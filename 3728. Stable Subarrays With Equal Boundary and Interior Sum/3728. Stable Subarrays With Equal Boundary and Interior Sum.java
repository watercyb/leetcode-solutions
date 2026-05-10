/*
 * Problem: 3728. Stable Subarrays With Equal Boundary and Interior Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/stable-subarrays-with-equal-boundary-and-interior-sum/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long countStableSubarrays(int[] capacity) {
        HashMap<Integer, HashMap<Long, Integer>> HM = new HashMap<>(capacity.length, 0.99f);
        long sum = 0;
        long res = 0;
        int prv = -1;
        for (int cap : capacity) {
            sum += cap;
            if (!HM.containsKey(cap)) {
                HashMap<Long, Integer> temp = new HashMap<>();
                temp.put(sum, 1);
                HM.put(cap, temp);
            } else {
                HashMap<Long, Integer> temp = HM.get(cap);
                int count = temp.getOrDefault(sum - 2 * cap, 0);
                res += count;
                if (cap == 0 && cap == prv)
                    res--;
                temp.put(sum, temp.getOrDefault(sum, 0) + 1);
            }
            prv = cap;
        }
        return res;
    }
}
