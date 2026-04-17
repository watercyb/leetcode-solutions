/*
 * Problem: 1409. Queries on a Permutation With Key
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/queries-on-a-permutation-with-key/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] arr = new int[m + 1];
        BIT = new int[queries.length + m + 1];
        for (int i = 1; i <= m; i++) {
            arr[i] = queries.length + i;
            if (i > 1)
                insert(arr[i], 1);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = get(arr[queries[i]]);
            insert(queries.length - i, 1);
            insert(arr[queries[i]], -1);
            arr[queries[i]] = queries.length - 1 - i;
        }
        return res;
    }

    int[] BIT;

    public void insert(int i, int num) {
        while (i < BIT.length) {
            BIT[i] += num;
            i += i & -i;
        }
    }

    public int get(int i) {
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
