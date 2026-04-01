/*
 * Problem: 321. Create Maximum Number
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/create-maximum-number/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        res = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            int[] resTemp = getRes(nums1, nums2, k, i);
            if (larger(resTemp, res, 0, 0))
                res = resTemp;
        }
        return res;
    }

    int[] res;

    public int[] getMQ(int[] nums, int n) {
        int[] MQ = new int[n];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && nums[i] > MQ[idx - 1] && idx + nums.length - i > n) {
                idx--;
            }
            if (idx < n)
                MQ[idx++] = nums[i];
        }
        return MQ;
    }

    public int[] getRes(int[] nums1, int[] nums2, int k, int n) {
        int[] res = new int[k];
        int[] MQ1 = getMQ(nums1, n);
        int[] MQ2 = getMQ(nums2, k - n);
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < MQ1.length && j < MQ2.length) {
            if (larger(MQ1, MQ2, i, j)) {
                res[idx++] = MQ1[i++];
            } else {
                res[idx++] = MQ2[j++];
            }
        }
        while (i < MQ1.length) {
            res[idx++] = MQ1[i++];
        }
        while (j < MQ2.length) {
            res[idx++] = MQ2[j++];
        }
        return res;
    }

    public boolean larger(int[] arr1, int[] arr2, int i, int j) {
        while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
            i++;
            j++;
        }
        return (j == arr2.length || (i != arr1.length && arr1[i] > arr2[j]));
    }
}
