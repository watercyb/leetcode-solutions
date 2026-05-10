/*
 * Problem: 3768. Minimum Inversion Count in Subarrays of Fixed Length
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-inversion-count-in-subarrays-of-fixed-length/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long minInversionCount(int[] nums, int k) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        int prv = 0;
        for (int num : arr) {
            if (num != prv) {
                HM.put(num, HM.size());
                prv = num;
            }
        }
        BIT = new int[HM.size() + 1];
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int num = HM.get(nums[i]);
            sum += total - get(num);
            insert(num, 1);
        }
        long res = sum;
        for (int i = k; i < nums.length; i++) {
            int l = HM.get(nums[i - k]);
            int r = HM.get(nums[i]);
            sum -= get(l - 1);
            insert(l, -1);
            sum += total - get(r);
            insert(r, 1);
            res = Math.min(res, sum);
        }
        return res;
    }

    int[] BIT;
    int total = 0;

    public void insert(int i, int num) {
        i++;
        total += num;
        while (i < BIT.length) {
            BIT[i] += num;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
