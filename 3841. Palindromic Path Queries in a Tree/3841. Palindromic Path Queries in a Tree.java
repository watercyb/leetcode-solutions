/*
 * Problem: 3841. Palindromic Path Queries in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindromic-path-queries-in-a-tree/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] links = new int[n][];
        int[] chrs = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]];
            chrs[i] = s.charAt(i) - 'a';
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = edge[1];
            links[edge[1]][--counts[edge[1]]] = edge[0];
        }
        firsts = new int[n];
        seconds = new int[n];
        prvs = new int[n];
        levels = new int[n];
        bit = new BIT(2 * n);
        int len = 32 - Integer.numberOfLeadingZeros(2 * n);
        if (len > 1 && (1 << (len - 1)) == 2 * n)
            len--;
        ST = new int[len][2 * n];
        dfs(links, chrs, 0, -1, 0);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * n; j++) {
                int idx = j + (1 << (i - 1));
                if (idx >= 2 * n || levels[ST[i - 1][j]] < levels[ST[i - 1][idx]]) {
                    ST[i][j] = ST[i - 1][j];
                } else {
                    ST[i][j] = ST[i - 1][idx];
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            int[] q = getQuery(query);
            if (q[0] == 0) {
                if (q[1] == q[2]) {
                    res.add(true);
                } else {
                    res.add(Integer.bitCount(
                            bit.get(firsts[q[1]]) ^ bit.get(firsts[q[2]]) ^ (1 << chrs[getLCA(q[1], q[2])])) <= 1);
                }
            } else {
                if (chrs[q[1]] != q[2]) {
                    bit.insert(firsts[q[1]], chrs[q[1]], q[2]);
                    bit.insert(seconds[q[1]], chrs[q[1]], q[2]);
                    chrs[q[1]] = q[2];
                }
            }
        }
        return res;
    }

    int idx = 0;
    int[] firsts;
    int[] seconds;
    int[] prvs;
    int[] levels;
    int[][] ST;
    BIT bit;

    public void dfs(int[][] links, int[] chrs, int i, int prv, int lv) {
        firsts[i] = idx;
        prvs[i] = prv;
        bit.insert(idx, chrs[i]);
        ST[0][idx++] = i;
        levels[i] = lv;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            dfs(links, chrs, next, i, lv + 1);
        }
        bit.insert(idx, chrs[i]);
        seconds[i] = idx;
        ST[0][idx++] = i;
    }

    public int[] getQuery(String query) {
        String[] strs = query.split(" ");
        int[] res = new int[3];
        res[1] = Integer.parseInt(strs[1]);
        if (strs[0].charAt(0) == 'q') {
            res[2] = Integer.parseInt(strs[2]);
        } else {
            res[0] = 1;
            res[2] = strs[2].charAt(0) - 'a';
        }
        return res;
    }

    public int getLCA(int a, int b) {
        int idxA = firsts[a];
        int idxB = firsts[b];
        if (idxA > idxB) {
            return getLCA(b, a);
        }
        if (idxB - idxA == 1)
            return a;
        int l = idxA + 1;
        int r = idxB - 1;
        int len = 32 - Integer.numberOfLeadingZeros(r - l + 1);
        if (len > 1 && (1 << (len - 1)) == r - l + 1)
            len--;
        int idx = r - (1 << (len - 1)) + 1;
        if (levels[ST[len - 1][l]] < levels[ST[len - 1][idx]]) {
            return Math.max(prvs[ST[len - 1][l]], 0);
        } else {
            return Math.max(prvs[ST[len - 1][idx]], 0);
        }
    }
}

class BIT {
    int[] bit;

    public BIT(int n) {
        bit = new int[n + 1];
    }

    public void insert(int i, int j) {
        i++;
        int h = 1 << j;
        while (i < bit.length) {
            bit[i] ^= h;
            i += i & -i;
        }
    }

    public void insert(int i, int j, int k) {
        i++;
        int h = (1 << j) ^ (1 << k);
        while (i < bit.length) {
            bit[i] ^= h;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res ^= bit[i];
            i -= i & -i;
        }
        return res;
    }
}
