/*
 * Problem: 514. Freedom Trail
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/freedom-trail/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findRotateSteps(String ring, String key) {
        List<List<Integer>> Li = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            Li.add(new ArrayList<>());
        }
        int l = ring.length();
        for (int i = 0; i < l; i++) {
            Li.get(ring.charAt(i) - 'a').add(i);
        }
        int[][] pos = new int[26][];
        for (int i = 0; i < 26; i++) {
            List<Integer> tmp = Li.get(i);
            int size = tmp.size();
            pos[i] = new int[size * 3];
            for (int j = 0; j < size; j++) {
                int num = tmp.get(j);
                pos[i][j] = num - l;
                pos[i][j + size] = num;
                pos[i][j + 2 * size] = num + l;
            }
        }
        return dfs(new int[key.length()][l], key.toCharArray(), pos, 0, 0, l);
    }

    public int dfs(int[][] mems, char[] chrs, int[][] pos, int i, int prv, int l) {
        if (i == chrs.length)
            return 0;
        if (mems[i][prv] != 0)
            return mems[i][prv];
        int idx = chrs[i] - 'a';
        int idxNext = BS(pos[idx], prv);
        mems[i][prv] = Math.min(
                dfs(mems, chrs, pos, i + 1, (pos[idx][idxNext] + l) % l, l) + pos[idx][idxNext] - prv + 1,
                dfs(mems, chrs, pos, i + 1, (pos[idx][idxNext - 1] + l) % l, l) + prv - pos[idx][idxNext - 1] + 1);
        return mems[i][prv];
    }

    public int BS(int[] pos, int i) {
        int l = 0;
        int r = pos.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (pos[mid] >= i) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
