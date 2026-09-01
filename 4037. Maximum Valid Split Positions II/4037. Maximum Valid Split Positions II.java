/*
 * Problem: 4037. Maximum Valid Split Positions II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-valid-split-positions-ii/
 * Language: java
 * Date: 2026-09-01
 */

class Solution {
    public int maxValidSplits(int[] nums) {
        int[] lefts = getArr(nums, false);
        int[] rights = getArr(nums, true);
        List<int[]> list = new ArrayList<>();
        int gcd = GCD(nums[0], nums[1]);
        if (nums[0] != nums[1]) {
            list.add(new int[] { nums[1], 0 });
            list.add(new int[] { nums[0], 1 });
        }
        int[] counts = new int[nums.length];
        int[] lineRight = new int[nums.length];
        int res = rights[1] == nums[0] ? 1 : 0;
        for (int i = 2; i < nums.length; i++) {
            if (rights[i] == gcd) {
                lineRight[0]++;
                lineRight[i]--;
                for (int[] pair : list) {
                    counts[pair[1]]--;
                }
                res++;
            }
            List<int[]> next = new ArrayList<>();
            int gcdNext = GCD(gcd, nums[i]);
            if (gcdNext != gcd)
                next.add(new int[] { gcd, i });
            gcd = gcdNext;
            for (int[] pair : list) {
                int k = pair[0];
                int v = pair[1];
                if (k == rights[i])
                    counts[v]++;
                k = GCD(k, nums[i]);
                if (k != gcd)
                    next.add(new int[] { k, v });
            }
            list = next;
        }
        int[] lineLeft = new int[nums.length + 1];
        list.clear();
        gcd = GCD(nums[nums.length - 1], nums[nums.length - 2]);
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            list.add(new int[] { nums[nums.length - 1], nums.length - 2 });
            list.add(new int[] { nums[nums.length - 2], nums.length - 1 });
        }
        for (int i = nums.length - 3; i >= 0; i--) {
            if (lefts[i] == gcd) {
                lineLeft[i + 1]++;
                lineLeft[nums.length]--;
                for (int[] pair : list) {
                    counts[pair[1]]--;
                }
            }
            List<int[]> next = new ArrayList<>();
            int gcdNext = GCD(gcd, nums[i]);
            if (gcdNext != gcd)
                next.add(new int[] { gcd, i });
            gcd = gcdNext;
            for (int[] pair : list) {
                int k = pair[0];
                int v = pair[1];
                if (k == lefts[i] && v != i + 1)
                    counts[v]++;
                k = GCD(k, nums[i]);
                if (k != gcd)
                    next.add(new int[] { k, v });
            }
            list = next;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += lineRight[i] + lineLeft[i];
            res = Math.max(res, sum + counts[i]);
        }
        return res;
    }

    public int[] getArr(int[] nums, boolean rev) {
        int[] res = new int[nums.length];
        if (!rev) {
            int gcd = nums[0];
            for (int i = 0; i < nums.length; i++) {
                gcd = GCD(gcd, nums[i]);
                res[i] = gcd;
            }
        } else {
            int gcd = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                gcd = GCD(gcd, nums[i]);
                res[i] = gcd;
            }
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
