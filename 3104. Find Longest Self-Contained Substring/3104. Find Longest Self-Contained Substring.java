/*
 * Problem: 3104. Find Longest Self-Contained Substring
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-longest-self-contained-substring/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maxSubstringLength(String s) {
        char[] chrs = s.toCharArray();
        int[] first = new int[26];
        Arrays.fill(first, chrs.length);
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (first[idx] == -1)
                first[idx] = i;
            last[idx] = i;
        }
        List<int[]> ranges = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                int l = first[i];
                int r = last[i];
                int idx = l + 1;
                while (idx <= r) {
                    int index = chrs[idx] - 'a';
                    if (first[index] < l)
                        break;
                    r = Math.max(last[index], r);
                    idx++;
                }
                if (idx <= r)
                    continue;
                ranges.add(new int[] { l, r });
            }
        }
        int[][] arr = new int[ranges.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranges.get(i);
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        res = chrs.length + 1;
        for (int i = 0; i < arr.length; i++) {
            int[] current = arr[i];
            dfs(arr, i + 1, current[1], chrs.length - current[1] + current[0] - 1);
        }
        return chrs.length - res;
    }

    int res;

    public void dfs(int[][] arr, int i, int prv, int n) {
        if (i == arr.length) {
            if (n != 0 && n < res)
                res = n;
            return;
        }
        int[] current = arr[i];
        if (current[0] <= prv) {
            dfs(arr, i + 1, prv, n);
        } else if (current[0] == prv + 1) {
            res = Math.min(n, res);
            dfs(arr, i + 1, current[1], n - current[1] + current[0] - 1);
        } else if (n != 0 && n < res) {
            res = n;
        }
    }
}
