/*
 * Problem: 1923. Longest Common Subpath
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-common-subpath/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        int min = Integer.MAX_VALUE;
        for (int[] path : paths) {
            min = Math.min(path.length, min);
        }
        int l = 1;
        int r = min + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(paths, n, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    long mod = (long) (Math.pow(10, 11) + 7);

    public boolean chk(int[][] paths, int n, int mid) {
        HashMap<Long, List<Integer>[]> HM = new HashMap<>();
        long h = 0;
        long base = 1;
        for (int i = 0; i < mid - 1; i++) {
            h = (h * n + paths[0][i]) % mod;
            base = base * n % mod;
        }
        h = (h * n + paths[0][mid - 1]) % mod;
        if (!HM.containsKey(h)) {
            List<Integer>[] lists = new ArrayList[paths.length];
            lists[0] = new ArrayList<>();
            lists[0].add(0);
            HM.put(h, lists);
        } else {
            HM.get(h)[0].add(0);
        }
        for (int i = mid; i < paths[0].length; i++) {
            h = ((h - paths[0][i - mid] * base % mod + mod) * n + paths[0][i]) % mod;
            if (!HM.containsKey(h)) {
                List<Integer>[] lists = new ArrayList[paths.length];
                lists[0] = new ArrayList<>();
                lists[0].add(i - mid + 1);
                HM.put(h, lists);
            } else {
                HM.get(h)[0].add(i - mid + 1);
            }
        }
        for (int i = 1; i < paths.length; i++) {
            h = 0;
            for (int j = 0; j < mid; j++) {
                h = (h * n + paths[i][j]) % mod;
            }
            if (HM.containsKey(h)) {
                List<Integer>[] lists = HM.get(h);
                if (lists[i - 1] == null) {
                    HM.remove(h);
                } else {
                    lists[i] = new ArrayList<>();
                    lists[i].add(0);
                }
            }
            for (int j = mid; j < paths[i].length; j++) {
                h = ((h - paths[i][j - mid] * base % mod + mod) * n + paths[i][j]) % mod;
                if (HM.containsKey(h)) {
                    List<Integer>[] lists = HM.get(h);
                    if (lists[i - 1] == null) {
                        HM.remove(h);
                    } else {
                        lists[i] = new ArrayList<>();
                        lists[i].add(j - mid + 1);
                    }
                }
            }
            if (HM.isEmpty())
                return false;
        }
        for (List<Integer>[] lists : HM.values()) {
            if (lists[paths.length - 1] == null)
                continue;
            for (int idx : lists[0]) {
                if (chk(paths, idx, lists, mid))
                    return true;
            }
        }
        return false;
    }

    public boolean chk(int[] a, int[] b, List<Integer> list, int i, int mid) {
        for (int idx : list) {
            if (chk(a, b, idx, i, mid))
                return true;
        }
        return false;
    }

    public boolean chk(int[] a, int[] b, int i, int j, int mid) {
        for (int k = 0; k < mid; k++) {
            if (a[i + k] != b[j + k])
                return false;
        }
        return true;
    }

    public boolean chk(int[][] paths, int i, List<Integer>[] lists, int mid) {
        for (int j = 1; j < paths.length; j++) {
            if (!chk(paths[j], paths[0], lists[j], i, mid))
                return false;
        }
        return true;
    }
}
