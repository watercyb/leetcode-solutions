/*
 * Problem: 3161. Block Placement Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/block-placement-queries/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int max = 0;
        for (int[] query : queries) {
            max = Math.max(query[1], max);
        }
        int lim = (int) Math.pow(2, (int) Math.ceil(Math.log(max + 1) / Math.log(2))) - 1;
        segment = new int[(lim + 1) * 2];
        TreeSet<Integer> TM = new TreeSet<>();
        TM.add(0);
        TM.add(lim + 1);
        int beginning = lim + 1;
        insert(beginning, lim);
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 1) {
                int l = TM.floor(queries[i][1]);
                int r = TM.higher(queries[i][1]);
                insert(beginning + l, queries[i][1] - l);
                insert(beginning + queries[i][1], r - queries[i][1]);
                TM.add(queries[i][1]);
            } else {
                res.add(getMax(1, queries[i][1] - queries[i][2], 0, lim) >= queries[i][2]);
            }
        }
        return res;
    }

    int[] segment;
    int max = 0;

    public void insert(int idx, int num) {
        segment[idx] = num;
        int prv = idx;
        idx = idx / 2;
        while (prv > 0) {
            segment[idx] = Math.max(segment[prv], segment[prv ^ 1]);
            prv = idx;
            idx = idx / 2;
        }
    }

    public int getMax(int idx, int positionRight, int l, int r) {
        if (l > positionRight)
            return 0;
        if (r <= positionRight)
            return segment[idx];
        if (l < r) {
            int mid = (l + r) >>> 1;
            return Math.max(getMax(2 * idx, positionRight, l, mid), getMax(2 * idx + 1, positionRight, mid + 1, r));
        }
        return 0;
    }
}
