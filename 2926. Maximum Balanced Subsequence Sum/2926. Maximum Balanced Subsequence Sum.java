/*
 * Problem: 2926. Maximum Balanced Subsequence Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-balanced-subsequence-sum/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - i;
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        for (int num : arr) {
            if (!HM.containsKey(num))
                HM.put(num, HM.size());
        }
        long min = Long.MIN_VALUE / 2;
        BIT = new long[HM.size() + 1];
        Arrays.fill(BIT, min);
        long res = min;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int idx = HM.get(num - i);
            res = Math.max(num, res);
            long max = get(idx);
            if (max + num > 0) {
                insert(idx, max + num);
                res = Math.max(max + num, res);
            } else if (num > 0) {
                insert(idx, num);
            }
        }
        return res;
    }

    long[] BIT;

    public void insert(int i, long num) {
        i++;
        while (i < BIT.length) {
            BIT[i] = Math.max(num, BIT[i]);
            i += i & -i;
        }
    }

    public long get(int i) {
        i++;
        long res = BIT[0];
        while (i > 0) {
            res = Math.max(BIT[i], res);
            i -= i & -i;
        }
        return res;
    }
}
