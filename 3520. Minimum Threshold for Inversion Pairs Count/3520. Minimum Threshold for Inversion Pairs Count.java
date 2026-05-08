/*
 * Problem: 3520. Minimum Threshold for Inversion Pairs Count
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-threshold-for-inversion-pairs-count/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minThreshold(int[] nums, int k) {
        long[] sort = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sort[i] = ((long) nums[i] << 15) + i;
        }
        Arrays.sort(sort);
        int[][] arr = new int[nums.length][];
        int mask = (1 << 15) - 1;
        for (int i = 0; i < nums.length; i++) {
            long num = sort[nums.length - 1 - i];
            arr[i] = new int[] { (int) (num >> 15), (int) (num & mask) };
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        bit = new BIT(nums.length);
        int l = 0;
        int r = max + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(arr, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == max + 1)
            return -1;
        return l;
    }

    BIT bit;

    public boolean chk(int[][] arr, int k, int mid) {
        bit.reset();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[j][0] - arr[i][0] > mid) {
                bit.insert(arr[j++][1], -1);
            }
            k -= bit.get(arr[i][1]);
            if (k <= 0)
                return true;
            bit.insert(arr[i][1], 1);
        }
        return false;
    }
}

class BIT {
    int[] BIT;

    public BIT(int n) {
        BIT = new int[n + 1];
    }

    public void reset() {
        Arrays.fill(BIT, 0);
    }

    public void insert(int i, int num) {
        i++;
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
