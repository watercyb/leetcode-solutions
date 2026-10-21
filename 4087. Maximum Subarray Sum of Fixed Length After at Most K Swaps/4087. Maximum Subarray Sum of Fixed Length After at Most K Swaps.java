/*
 * Problem: 4087. Maximum Subarray Sum of Fixed Length After at Most K Swaps
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-subarray-sum-of-fixed-length-after-at-most-k-swaps/
 * Language: java
 * Date: 2026-10-21
 */

class Solution {
    public long maxSum(int[] nums, int length, int k) {
        if (length + k >= nums.length)
            return getSum(nums, length);
        int[][] arr = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[] { nums[i], i };
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        boolean[] insides = new boolean[nums.length];
        int[] pos = new int[nums.length];
        int idx = 0;
        long sum = 0;
        while (idx < k) {
            sum += arr[idx][0];
            insides[arr[idx][1]] = true;
            idx++;
        }
        PriorityQueue<int[]> lefts = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> rights = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        long left = 0;
        long leftCount = 0;
        for (int i = 0; i < length; i++) {
            pos[i] = 1;
            if (insides[i]) {
                while (pos[arr[idx][1]] != 0) {
                    insides[arr[idx][1]] = true;
                    idx++;
                }
                insides[arr[idx][1]] = true;
                sum += arr[idx][0] - nums[i];
                idx++;
            }
            if (idx >= length)
                return getSum(nums, length);
            lefts.offer(new int[] { nums[i], i });
            left += nums[i];
            leftCount++;
            if (leftCount > length - k) {
                int[] pair = lefts.poll();
                left -= pair[0];
                leftCount--;
                pos[pair[1]] = 2;
                rights.offer(pair);
            }
        }
        long res = left + sum;
        for (int i = length; i < nums.length; i++) {
            int j = i - length;
            if (pos[j] == 1) {
                left -= nums[j];
                leftCount--;
            }
            pos[j] = 0;
            if (insides[j]) {
                while (pos[arr[idx - 1][1]] != 0) {
                    idx--;
                    insides[arr[idx][1]] = false;
                }
                idx--;
                insides[arr[idx][1]] = false;
                sum += nums[j] - arr[idx][0];
            }
            pos[i] = 1;
            if (insides[i]) {
                while (pos[arr[idx][1]] != 0) {
                    insides[arr[idx][1]] = true;
                    idx++;
                }
                insides[arr[idx][1]] = true;
                sum += arr[idx][0] - nums[i];
                idx++;
            }
            if (idx >= length)
                return getSum(nums, length);
            if (nums[i] >= lefts.peek()[0]) {
                lefts.offer(new int[] { nums[i], i });
                left += nums[i];
                pos[i] = 1;
                leftCount++;
            } else {
                rights.offer(new int[] { nums[i], i });
                pos[i] = 2;
            }
            if (leftCount > length - k) {
                while (pos[lefts.peek()[1]] == 0) {
                    lefts.poll();
                }
                int[] pair = lefts.poll();
                left -= pair[0];
                leftCount--;
                pos[pair[1]] = 2;
                rights.offer(pair);
            } else if (leftCount < length - k) {
                while (pos[rights.peek()[1]] == 0) {
                    rights.poll();
                }
                int[] pair = rights.poll();
                pos[pair[1]] = 1;
                left += pair[0];
                leftCount++;
                lefts.offer(pair);
            }
            res = Math.max(res, left + sum);
        }
        return res;
    }

    public long getSum(int[] nums, int length) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = nums.length - 1; i >= nums.length - length; i--) {
            res += nums[i];
        }
        return res;
    }
}
