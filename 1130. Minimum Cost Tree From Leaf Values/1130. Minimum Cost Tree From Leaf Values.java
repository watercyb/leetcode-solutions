/*
 * Problem: 1130. Minimum Cost Tree From Leaf Values
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int mctFromLeafValues(int[] arr) {
        dfs(arr, 0, arr.length - 1);
        return res;
    }

    int res = 0;

    public int dfs(int[] arr, int l, int r) {
        if (l > r)
            return 0;
        if (l == r)
            return arr[l];
        int max = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        int right=dfs(arr, max + 1, r);
        int left=dfs(arr, l, max - 1);
        res += (left + right) * arr[max];
        return arr[max];
    }
}
