/*
 * Problem: 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int[][] arr1 = getArr(nums1);
        int[][] arr2 = getArr(nums2);
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            res += getCount(arr2, (long) arr1[i][0] * arr1[i][0]) * arr1[i][1];
        }
        System.out.println(res);
        for (int i = 0; i < arr2.length; i++) {
            res += getCount(arr1, (long) arr2[i][0] * arr2[i][0]) * arr2[i][1];
        }
        return res;
    }

    public int[][] getArr(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int prv = -1;
        for (int num : nums) {
            if (num != prv)
                count++;
            prv = num;
        }
        int[][] res = new int[count][];
        int idx = 0;
        prv = nums[0];
        count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prv) {
                res[idx++] = new int[] { prv, count };
                prv = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        res[idx] = new int[] { prv, count };
        return res;
    }

    public int getCount(int[][] arr, long target) {
        int res = 0;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            long pro = (long) arr[l][0] * arr[r][0];
            if (pro < target) {
                l++;
            } else if (pro > target) {
                r--;
            } else {
                res += arr[l][1] * arr[r][1];
                l++;
                r--;
            }
        }
        if (l == r && (long) arr[l][0] * arr[r][0] == target)
            res += (arr[l][1]) * (arr[l][1] - 1) / 2;
        return res;
    }
}
