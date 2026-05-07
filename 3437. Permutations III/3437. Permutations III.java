/*
 * Problem: 3437. Permutations III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/permutations-iii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[][] permute(int n) {
        int[] arr = new int[n];
        boolean[] seens = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            seens[i] = true;
            arr[0] = i;
            dfs(arr, seens, 1);
            seens[i] = false;
        }
        int[][] res = new int[list.size()][];
        list.toArray(res);
        return res;
    }

    List<int[]> list = new ArrayList<>();

    public void dfs(int[] arr, boolean[] seens, int i) {
        if (i == arr.length) {
            list.add(arr.clone());
        } else {
            int idx = arr[i - 1] % 2 + 1;
            while (idx < seens.length) {
                if (!seens[idx]) {
                    seens[idx] = true;
                    arr[i] = idx;
                    dfs(arr, seens, i + 1);
                    seens[idx] = false;
                }
                idx += 2;
            }
        }
    }
}
