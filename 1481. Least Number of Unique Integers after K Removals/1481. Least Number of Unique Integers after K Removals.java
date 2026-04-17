/*
 * Problem: 1481. Least Number of Unique Integers after K Removals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int in : arr) {
            HM.put(in, HM.getOrDefault(in, 0) + 1);
        }
        int count = HM.size();
        int[] freq = new int[arr.length + 1];
        for (int in : HM.values()) {
            freq[in]++;
        }
        for (int i = 0; i < freq.length; i++) {
            for (int j=0;j<freq[i];j++) {
                k -= i;
                if (k < 0)
                    return count;
                count--;
            }
        }
        return 0;
    }
}
