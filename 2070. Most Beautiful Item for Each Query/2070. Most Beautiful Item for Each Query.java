/*
 * Problem: 2070. Most Beautiful Item for Each Query
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/most-beautiful-item-for-each-query/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(new int[] { 0, 0 });
        int prv = 0;
        for (int[] item : items) {
            if (item[1] > prv) {
                list.add(item);
                prv = item[1];
            }
        }
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = binarySearch(arr, queries[i]);
        }
        return res;
    }

    public int binarySearch(int[][] arr, int num) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid][0] > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l - 1][1];
    }
}
