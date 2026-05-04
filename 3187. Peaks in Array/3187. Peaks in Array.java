/*
 * Problem: 3187. Peaks in Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/peaks-in-array/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    int[] BIT;

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        BIT = new int[nums.length];
        int[] isPeaks = new int[nums.length];
        Arrays.fill(isPeaks, -1);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                insert(i, 1);
                isPeaks[i] = 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 2) {
                nums[query[1]] = query[2];
                if (query[1] > 0)
                    cal(nums, isPeaks, query[1] - 1);
                cal(nums, isPeaks, query[1]);
                if (query[1] < nums.length - 1)
                    cal(nums, isPeaks, query[1] + 1);
            } else {
                if (query[2] - query[1] < 2) {
                    res.add(0);
                } else {
                    res.add(get(query[2] - 1) - get(query[1]));
                }
            }
        }
        return res;
    }

    public void cal(int[] nums, int[] isPeaks, int i) {
        int current = isPeak(nums, i);
        if (isPeaks[i] != current)
            insert(i, current);
        isPeaks[i] = current;
    }

    public int isPeak(int[] nums, int i) {
        if (i == 0 || i == nums.length - 1 || nums[i] <= nums[i - 1] || nums[i] <= nums[i + 1])
            return -1;
        return 1;
    }

    public void insert(int i, int num) {
        while (i < BIT.length) {
            BIT[i] += num;
            i += i & -i;
        }
    }

    public int get(int i) {
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
