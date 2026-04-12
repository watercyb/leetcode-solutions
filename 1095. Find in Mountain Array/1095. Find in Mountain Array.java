/*
 * Problem: 1095. Find in Mountain Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-in-mountain-array/
 * Language: java
 * Date: 2026-04-12
 */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = mountainArr.get(0);
        int r = mountainArr.get(mountainArr.length() - 1);
        int[] max = max(mountainArr);
        if (target > max[1])
            return -1;
        if (target == max[1])
            return max[0];
        int res = -1;
        
        if (l == target) return 0;
        if (l < target) {
            res = BS1(mountainArr, target, max[0]);
            if (res != -1)
                return res;
        }
        if (r == target) return mountainArr.length() - 1;
        if (r < target) {
            res = BS2(mountainArr, target, max[0]);
        }
        return res;
    }

    public int BS1(MountainArray mountainArr, int target, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int tmp = mountainArr.get(mid);
            if (tmp > target) {
                r = mid;
            } else if (tmp < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int BS2(MountainArray mountainArr, int target, int l) {
        int r = mountainArr.length() - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int tmp = mountainArr.get(mid);
            if (tmp < target) {
                r = mid;
            } else if (tmp > target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int[] max(MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length() - 1;
        int max = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int tmp = mountainArr.get(mid);
            if (tmp > mountainArr.get(mid + 1)) {
                r = mid;
                max = tmp;
            } else {
                l = mid + 1;
            }
        }
        return new int[] { l, max };
    }
}
