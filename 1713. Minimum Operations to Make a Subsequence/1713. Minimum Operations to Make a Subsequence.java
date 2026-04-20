/*
 * Problem: 1713. Minimum Operations to Make a Subsequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            HM.put(target[i], i);
        }
        int[] DP = new int[target.length];
        int idx = 0;
        for (int i = 0; i < arr.length && idx < target.length; i++) {
            if (!HM.containsKey(arr[i]))
                continue;
            int num = HM.get(arr[i]);
            int j = binarySearch(DP, idx, num);
            DP[j] = num;
            if (j == idx)
                idx++;
        }
        return target.length - idx;
    }

    public int binarySearch(int[] DP, int r, int target) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (DP[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
