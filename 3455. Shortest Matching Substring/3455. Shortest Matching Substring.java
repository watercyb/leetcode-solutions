/*
 * Problem: 3455. Shortest Matching Substring
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-matching-substring/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int shortestMatchingSubstring(String s, String p) {
        String[] strArr = p.split("\\*");
        int n = strArr.length;
        for (String str : strArr) {
            if (str.length() == 0)
                n--;
        }
        String[] target = new String[n];
        int[] lens = new int[n];
        int len = 0;
        int idx = 0;
        StringBuilder SB = new StringBuilder();
        for (String str : strArr) {
            if (str.length() != 0) {
                target[idx] = str;
                lens[idx] = str.length();
                len += lens[idx];
                idx++;
                SB.append(str);
            }
        }
        if (s.indexOf(SB.toString()) >= 0)
            return SB.toString().length();
        if (target.length == 0)
            return 0;
        if (target.length == 1) {
            if (s.indexOf(target[0]) == -1)
                return -1;
            return target[0].length();
        }
        int[][] arr = new int[target.length][];
        for (int i = 0; i < target.length; i++) {
            List<Integer> list = new ArrayList<>();
            idx = s.indexOf(target[i]);
            while (idx >= 0) {
                list.add(idx);
                idx = s.indexOf(target[i], idx + 1);
            }
            if (list.size() == 0)
                return -1;
            arr[i] = new int[list.size()];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = list.get(j);
            }
        }
        int res = Integer.MAX_VALUE / 2;
        Integer[][] meme = new Integer[n + 1][100001];
        for (int num : arr[0]) {
            res = Math.min(dfs(arr, lens, meme, 1, num + lens[0]), res);
        }
        if (res >= Integer.MAX_VALUE / 2)
            return -1;
        return res + len;
    }

    public int dfs(int[][] arr, int[] lens, Integer[][] meme, int i, int prv) {
        if (i == arr.length)
            return 0;
        if (meme[i][prv] != null)
            return meme[i][prv];
        int idx = binarySearch(arr[i], prv);
        if (idx == arr[i].length)
            return meme[i][prv] = Integer.MAX_VALUE / 2;
        int res = Integer.MAX_VALUE;
        for (int j = idx; j < arr[i].length; j++) {
            res = Math.min(dfs(arr, lens, meme, i + 1, arr[i][j] + lens[i]) + arr[i][j] - prv, res);
        }
        return meme[i][prv] = res;
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
