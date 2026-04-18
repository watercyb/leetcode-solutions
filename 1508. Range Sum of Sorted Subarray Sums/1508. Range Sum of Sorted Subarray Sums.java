/*
 * Problem: 1508. Range Sum of Sorted Subarray Sums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        long[] sumSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sumSums[i + 1] = sumSums[i] + sums[i + 1];
        }
        long l = left == 1 ? 0 : binarySearch(sums, sumSums, left - 1);
        long r = binarySearch(sums, sumSums, right);
        return (int) ((r - l) % 1_000_000_007);
    }

    public long binarySearch(int[] sums, long[] sumSums, int num) {
        int l = 0;
        int r = sums[sums.length - 1] + 1;
        int diff = 0;
        long res = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            Node c = chk(sums, sumSums, num, mid);
            if (c.count == 0)
                return c.sum;
            if (c.count < 0) {
                diff = -c.count;
                r = mid;
                res = c.sum;
            } else {
                l = mid + 1;
            }
        }
        return res - (long) diff * l;
    }

    public Node chk(int[] sums, long[] sumSums, int num, int mid) {
        long res = 0;
        int j = 0;
        for (int i = 0; i < sums.length - 1; i++) {
            while (j < sums.length && sums[j] - sums[i] <= mid) {
                j++;
            }
            res += sumSums[j - 1] - sumSums[i] - (long) (j - 1 - i) * sums[i];
            num -= j - 1 - i;
        }
        return new Node(num, res);
    }
}

class Node {
    int count;
    long sum;

    public Node(int count, long sum) {
        this.count = count;
        this.sum = sum;
    }
}
