/*
 * Problem: 1001. Grid Illumination
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/grid-illumination/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[][] directions = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 1 }, { 0, -1 }, { 1, -1 },
                { -1, -1 } };
        for (int[] lamp : lamps) {
            if (HS.add(1_000_000_001l * lamp[0] + lamp[1])) {
                insert(lamp[0], lamp[1], n);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (rows.containsKey(x) || cols.containsKey(y) || diag1.containsKey(x + n - 1 - y)
                    || diag2.containsKey(y + x))
                res[i] = 1;
            for (int[] direction : directions) {
                int x1 = x + direction[0];
                int y1 = y + direction[1];
                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && HS.contains(1_000_000_001l * x1 + y1))
                    reduce(x1, y1, n);
            }
        }
        return res;
    }

    HashMap<Integer, Integer> rows = new HashMap<>(20000, 0.99f);
    HashMap<Integer, Integer> cols = new HashMap<>(20000, 0.99f);
    HashMap<Integer, Integer> diag1 = new HashMap<>(20000, 0.99f);
    HashMap<Integer, Integer> diag2 = new HashMap<>(20000, 0.99f);
    HashSet<Long> HS = new HashSet<>(20000, 0.99f);

    public void insert(int x, int y, int n) {
        rows.put(x, rows.getOrDefault(x, 0) + 1);
        cols.put(y, cols.getOrDefault(y, 0) + 1);
        int d = x + n - 1 - y;
        diag1.put(d, diag1.getOrDefault(d, 0) + 1);
        d = y + x;
        diag2.put(d, diag2.getOrDefault(d, 0) + 1);
    }

    public void reduce(int x1, int y1, int n) {
        HS.remove(1_000_000_001l * x1 + y1);
        int count = rows.get(x1);
        if (count == 1) {
            rows.remove(x1);
        } else {
            rows.put(x1, count - 1);
        }
        count = cols.get(y1);
        if (count == 1) {
            cols.remove(y1);
        } else {
            cols.put(y1, count - 1);
        }
        int d = x1 + n - 1 - y1;
        count = diag1.get(d);
        if (count == 1) {
            diag1.remove(d);
        } else {
            diag1.put(d, count - 1);
        }
        d = y1 + x1;
        count = diag2.get(d);
        if (count == 1) {
            diag2.remove(d);
        } else {
            diag2.put(d, count - 1);
        }
    }
}
