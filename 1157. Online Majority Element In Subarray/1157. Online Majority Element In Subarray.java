/*
 * Problem: 1157. Online Majority Element In Subarray
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/online-majority-element-in-subarray/
 * Language: java
 * Date: 2026-04-14
 */

class MajorityChecker {
    List<Integer>[] lists = new ArrayList[20001];
    int[][] sums;

    public MajorityChecker(int[] arr) {
        sums = new int[arr.length + 1][15];
        for (int i = 0; i < arr.length; i++) {
            if (lists[arr[i]] == null)
                lists[arr[i]] = new ArrayList<>();
            lists[arr[i]].add(i);
            for (int j = 0; j < 15; j++) {
                sums[i + 1][j] = (arr[i] & 1) + sums[i][j];
                arr[i] /= 2;
            }
        }
    }

    public int query(int left, int right, int threshold) {
        int num = 0;
        for (int i = 14; i >= 0; i--) {
            int sum = sums[right + 1][i] - sums[left][i];
            if (sum >= threshold) {
                num = (num << 1) + 1;
            } else if (right - left + 1 - sum >= threshold) {
                num <<= 1;
            } else {
                return -1;
            }
        }
        if (lists[num] == null || lists[num].size() < threshold)
            return -1;
        if (binarySearch(lists[num], right + 1) - binarySearch(lists[num], left) >= threshold)
            return num;
        return -1;
    }

    public int binarySearch(List<Integer> list, int target) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
