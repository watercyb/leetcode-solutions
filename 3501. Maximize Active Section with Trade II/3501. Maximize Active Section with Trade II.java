/*
 * Problem: 3501. Maximize Active Section with Trade II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-active-section-with-trade-ii/
 * Language: java
 * Date: 2026-05-08
 */


class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        List<int[]> list = new ArrayList<>();
        char[] chrs = s.toCharArray();
        int sum = 0;
        char prv = '1';
        int idx = 0;
        int[] indexes = new int[chrs.length];
        int count = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '1') {
                sum++;
                if (prv == '0')
                    list.add(new int[] { idx, i - 1 });
            } else {
                if (prv == '1') {
                    idx = i;
                    count++;
                }
            }
            prv = chrs[i];
            indexes[i] = count;
        }
        if (prv == '0')
            list.add(new int[] { idx, chrs.length - 1 });
        List<Integer> res = new ArrayList<>();
        if (list.size() <= 1) {
            for (int i = 0; i < queries.length; i++) {
                res.add(sum);
            }
            return res;
        }
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        int len = (int) Math.pow(2, Math.ceil(Math.log(arr.length) / Math.log(2)));
        int[] segment = new int[2 * len - 1];
        for (int i = 1; i < arr.length; i++) {
            segment[len + i - 1] = arr[i][1] - arr[i][0] + arr[i - 1][1] - arr[i - 1][0] + 2;
        }
        for (int i = len - 2; i >= 0; i--) {
            segment[i] = Math.max(segment[2 * i + 1], segment[2 * i + 2]);
        }
        for (int i = 0; i < queries.length; i++) {
            int l = indexes[queries[i][0]];
            int r = indexes[queries[i][1]];
            if (l == r) {
                res.add(sum);
                continue;
            }
            int max = 0;
            r--;
            if (l > 0 && arr[l - 1][1] >= queries[i][0]) {
                if (l == r) {
                    res.add(arr[l - 1][1] - queries[i][0] + Math.min(arr[r][1], queries[i][1]) - arr[r][0] + 2 + sum);
                    continue;
                }
                max = arr[l - 1][1] - queries[i][0] + arr[l][1] - arr[l][0] + 2;
            } else if (l == r) {
                res.add(sum);
                continue;
            }
            if (arr[r][1] >= queries[i][1]) {
                max = Math.max(queries[i][1] - arr[r][0] + arr[r - 1][1] - arr[r - 1][0] + 2, max);
                r--;
            }
            res.add(Math.max(getMax(segment, 0, 0, len - 1, l + 1, r), max) + sum);
        }
        return res;
    }

    public int getMax(int[] segment, int i, int l, int r, int left, int right) {
        if (r < left || l > right)
            return 0;
        if (l >= left && r <= right)
            return segment[i];
        int mid = (l + r) >>> 1;
        return Math.max(getMax(segment, 2 * i + 1, l, mid, left, right),
                getMax(segment, 2 * i + 2, mid + 1, r, left, right));
    }
}
