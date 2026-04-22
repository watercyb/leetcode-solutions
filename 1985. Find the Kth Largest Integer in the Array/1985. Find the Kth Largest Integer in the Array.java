/*
 * Problem: 1985. Find the Kth Largest Integer in the Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        return sep(nums, 0, nums.length - 1, k - 1);
    }

    public String sep(String[] nums, int i, int j, int k) {
        if (i == j)
            return nums[i];
        int idx = 0;
        switch (j % 3) {
            case 0:
                idx = i;
                break;
            case 1:
                idx = j;
                break;
            default:
                idx = (i + j) >>> 1;
        }
        String p = nums[idx];
        swap(nums, idx, j);
        int r = j;
        int l = i;
        int count = 0;
        while (l <= r) {
            int diff = compare(nums[l], p);
            if (diff > 0) {
                l++;
            } else if (diff == 0) {
                count++;
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }
        if (r == k) {
            return p;
        } else if (r > k) {
            if (r - k < count)
                return p;
            while (r > k && nums[r] == p) {
                r--;
            }
            return sep(nums, i, r, k);
        } else {
            return sep(nums, r + 1, j, k);
        }
    }

    public void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int compare(String a, String b) {
        if (a.length() != b.length())
            return a.length() - b.length();
        return a.compareTo(b);
    }
}
