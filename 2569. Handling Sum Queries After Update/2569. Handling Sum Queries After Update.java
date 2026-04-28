/*
 * Problem: 2569. Handling Sum Queries After Update
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/handling-sum-queries-after-update/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int len = (int) Math.pow(2, Math.ceil(Math.log(nums1.length) / Math.log(2)));
        segment = new int[len * 2 - 1];
        caches = new boolean[len * 2 - 1];
        for (int i = 0; i < nums1.length; i++) {
            segment[i + len - 1] = nums1[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            segment[i] = segment[2 * i + 1] + segment[2 * i + 2];
        }
        long sum = 0;
        for (int num : nums2) {
            sum += num;
        }
        List<Long> list = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                insert(query[1], query[2], 0, 0, len - 1);
            } else if (query[0] == 2) {
                sum += (long) segment[0] * query[1];
            } else {
                list.add(sum);
            }
        }
        long[] res = new long[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int[] segment;
    boolean[] caches;

    public int insert(int l, int r, int idx, int left, int right) {
        if (caches[idx]) {
            caches[idx] = false;
            segment[idx] = right - left + 1 - segment[idx];
            if (left != right) {
                caches[2 * idx + 1] = !caches[2 * idx + 1];
                caches[2 * idx + 2] = !caches[2 * idx + 2];
            }
        }
        if (r < left || l > right)
            return segment[idx];
        if (left == right) {
            segment[idx] = 1 - segment[idx];
            return segment[idx];
        }
        if (l <= left && r >= right) {
            caches[2 * idx + 1] = !caches[2 * idx + 1];
            caches[2 * idx + 2] = !caches[2 * idx + 2];
            segment[idx] = right - left + 1 - segment[idx];
            return segment[idx];
        }
        int mid = (left + right) / 2;
        segment[idx] = insert(l, r, 2 * idx + 1, left, mid) + insert(l, r, 2 * idx + 2, mid + 1, right);
        return segment[idx];
    }
}
