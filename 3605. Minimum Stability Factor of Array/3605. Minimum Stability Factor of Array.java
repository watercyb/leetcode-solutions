/*
 * Problem: 3605. Minimum Stability Factor of Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-stability-factor-of-array/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minStable(int[] nums, int maxC) {
        if (chkZero(nums, maxC))
            return 0;
        long[] Qu = new long[nums.length];
        int lim = 0;
        int[] arr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                arr[i] = 0;
                lim = 0;
            } else {
                HashSet<Integer> HS = new HashSet<>();
                int max = i;
                int l = 0;
                for (int r = 0; r < lim; r++) {
                    int idx = (int) (Qu[r] % nums.length);
                    int num = (int) (Qu[r] / nums.length);
                    int gcd = GCD(num, nums[i]);
                    if (gcd == 1)
                        continue;
                    if (HS.add(gcd)) {
                        max = Math.max(idx, max);
                        Qu[l++] = (long) gcd * nums.length + idx;
                    }
                }
                if (HS.add(nums[i]))
                    Qu[l++] = (long) nums[i] * nums.length + i;
                arr[i] = max + 1;
                lim = l;
            }
        }
        int l = 1;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(arr, maxC, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] arr, int maxC, int mid) {
        int lim = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            int len = Math.min(arr[i], lim) - i;
            if (len > mid) {
                lim = len - mid - 1 + i;
                if (maxC == 0)
                    return false;
                maxC--;
            }
        }
        return true;
    }

    public boolean chkZero(int[] nums, int maxC) {
        int count = 0;
        for (int num : nums) {
            if (num == 1)
                count++;
        }
        return maxC + count >= nums.length;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
