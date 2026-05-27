/*
 * Problem: Unknown Problem
 * Difficulty: Medium
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
        long[] min1 = getMin(nums, k, 0);
        long[] min2 = getMin(nums, k, 1);
        if (min1[1] != min2[1])
            return min1[0] + min2[0];
        return Math.min(min1[0] + min2[2], min1[2] + min2[0]);
    }

    private long[] getMin(int[] nums, int k, int startIdx) {
        int n = (nums.length - startIdx + 1) / 2;
        int[] arr = new int[2 * n];
        int idx = startIdx;
        int l = 0;
        int r = n;
        while (idx < nums.length) {
            arr[l] = nums[idx];
            arr[r] = nums[idx] + k;
            idx += 2;
            l++;
            r++;
        }
        Arrays.sort(arr);
        l = 0;
        r = 0;
        long sumL = 0;
        long sumR = 0;
        while (r < n) {
            sumR += arr[r++];
        }
        long sum = sumR - (long) arr[0] * n;
        long min1 = sum;
        long num1 = arr[0] % k;
        long min2 = sum + n;
        idx = 0;
        while (r < arr.length) {
            long min = (long) arr[idx] * (idx - l) - sumL + sumR - (long) arr[idx] * (r - idx);
            if (min < min1) {
                if (arr[idx] % k != num1)
                    min2 = min1;
                min1 = min;
                num1 = arr[idx] % k;
            } else if (min < min2 && num1 != arr[idx] % k) {
                min2 = min;
            }
            if (idx > 0 && arr[idx] % k - arr[idx - 1] % k > 1) {
                long minL = min - (idx - l) + (r - idx);
                min2 = Math.min(min2, minL);
            }
            if (idx < arr.length - 1 && arr[idx + 1] % k - arr[idx] % k > 1) {
                long minR = min + (idx - l) - (r - idx) + 2;
                min2 = Math.min(min2, minR);
            }
            while (idx < r - 1) {
                long minNext = (long) arr[idx + 1] * (idx + 1 - l) - (sumL + arr[idx]) + (sumR - arr[idx])
                        - (long) arr[idx + 1] * (r - idx - 1);
                if (minNext <= min) {
                    sumL += arr[idx];
                    sumR -= arr[idx];
                    idx++;
                    if (minNext < min1) {
                        if (arr[idx] % k != num1)
                            min2 = min1;
                        min1 = minNext;
                        num1 = arr[idx] % k;
                    } else if (minNext < min2 && num1 != arr[idx] % k) {
                        min2 = minNext;
                    }
                    if (idx > 0 && arr[idx] % k - arr[idx - 1] % k > 1) {
                        long minL = minNext - (idx - l) + (r - idx);
                        min2 = Math.min(min2, minL);
                    }
                    if (idx < arr.length - 1 && arr[idx + 1] % k - arr[idx] % k > 1) {
                        long minR = minNext + (idx - l) - (r - idx) + 2;
                        min2 = Math.min(min2, minR);
                    }
                    min = minNext;
                } else {
                    break;
                }
            }
            if (idx < arr.length - 1 && arr[idx + 1] % k != arr[idx] % k && (arr[idx] + 1) % k != num1) {
                long minR = min + (idx - l) - (r - idx) + 2;
                min2 = Math.min(min2, minR);
            }
            sumL -= arr[l];
            sumR += arr[r];
            if (idx == l) {
                sumL += arr[idx];
                sumR -= arr[idx];
                idx++;
            }
            l++;
            r++;
        }
        return new long[] { min1, num1, min2 };
    }
}
