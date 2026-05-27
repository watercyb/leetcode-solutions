/*
 * Problem: 3944. Minimum Operations to Make Array Modulo Alternating II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-modulo-alternating-ii/
 * Language: java
 * Date: 2026-05-27
 */

class Solution {
    public long minOperations(int[] nums, int k) {
        if (nums.length == 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % k;
        }
        Min min1 = getMin(nums, k, 0);
        Min min2 = getMin(nums, k, 1);
        if (min1.num != min2.num)
            return min1.min1 + min2.min1;
        return Math.min(min1.min1 + min2.min2, min1.min2 + min2.min1);
    }

    public Min getMin(int[] nums, int k, int startIdx) {
        Min res = new Min();
        int n = (nums.length - startIdx + 1) / 2;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[startIdx];
            startIdx += 2;
        }
        Arrays.sort(arr);
        long[] sums = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sums[i + 1] = sums[i] + arr[i];
        }
        int l = 0;
        int r = arr.length - 1;
        int idx = 0;
        while (arr[r] - arr[0] > k - arr[r] + arr[0]) {
            r--;
        }
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            if (i > 0 && target == arr[i - 1])
                continue;
            while (arr[idx] < target) {
                idx++;
            }
            while (target - arr[l] > k - target + arr[l]) {
                l++;
            }
            while (r < arr.length - 1 && arr[r + 1] - target <= k - arr[r + 1] + target) {
                r++;
            }
            long sum = 0;
            if (l > 0) {
                sum += (long) k * l - ((long) target * l - (sums[l] - sums[0]));
            } else if (r < arr.length - 1) {
                sum += (long) k * (arr.length - 1 - r)
                        - (sums[arr.length] - sums[r + 1] - (long) target * (arr.length - 1 - r));
            }
            sum += (long) target * (idx - l) - (sums[idx] - sums[l]) + (sums[r + 1] - sums[idx])
                    - (long) target * (r - idx + 1);
            res.updateMin(sum, target);
        }
        getSum(arr, res, k, (res.num - 1 + k) % k);
        getSum(arr, res, k, (res.num + 1) % k);
        return res;
    }

    public void getSum(int[] arr, Min min, int k, int target) {
        int sum = 0;
        for (int num : arr) {
            int diff = Math.abs(target - num);
            sum += Math.min(diff, k - diff);
        }
        min.updateMin(sum, target);
    }
}

class Min {
    long min1 = Long.MAX_VALUE;
    int num = -1;
    long min2 = Long.MAX_VALUE;

    public void updateMin(long min, int num) {
        if (min < min1) {
            min2 = min1;
            min1 = min;
            this.num = num;
        } else if (min < min2) {
            min2 = min;
        }
    }
}
