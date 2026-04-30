/*
 * Problem: 2790. Maximum Number of Groups With Increasing Length
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-groups-with-increasing-length/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int[] arr = new int[usageLimits.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = usageLimits.get(i);
        }
        Arrays.sort(arr);
        int res = 1;
        long more = 0;
        int need = 1;
        for (int i = 0; i < arr.length; i++) {
            if (more + arr[i] >= need) {
                more = more + arr[i] - need;
                need = ++res;
            } else {
                need -= arr[i] + more;
                more = 0;
            }
        }
        return res - 1;
    }
}
