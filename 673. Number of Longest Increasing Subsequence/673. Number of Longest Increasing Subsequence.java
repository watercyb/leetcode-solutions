/*
 * Problem: 673. Number of Longest Increasing Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        List<List<int[]>> DP = new ArrayList<>();
        int[] min = new int[nums.length + 1];
        DP.add(Arrays.asList(new int[][] { { Integer.MIN_VALUE, 1 } }));
        min[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int lastAvailable = findLastAvailable(DP, min, nums[i]);
            int count = findCount(DP.get(lastAvailable - 1), nums[i]);
            if (lastAvailable < DP.size()) {
                List<int[]> tmp = DP.get(lastAvailable);
                tmp.add(new int[] { nums[i], tmp.get(tmp.size() - 1)[1] + count });
                min[lastAvailable] = nums[i];
            } else {
                List<int[]> tmp = new ArrayList<>();
                tmp.add(new int[] { nums[i], count });
                DP.add(tmp);
                min[lastAvailable] = nums[i];
            }
        }
        List<int[]> tmp = DP.get(DP.size() - 1);
        return tmp.get(tmp.size() - 1)[1];
    }

    public int findLastAvailable(List<List<int[]>> DP, int[] min, int num) {
        int l = 0;
        int r = DP.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (num <= min[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int findCount(List<int[]> Li, int num) {
        int lim=Li.size();
        int l = 0;
        int r = lim;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (Li.get(mid)[0] < num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == 0) {
            return Li.get(lim - 1)[1];
        } else {
            return Li.get(lim - 1)[1] - Li.get(l - 1)[1];
        }
    }
}
