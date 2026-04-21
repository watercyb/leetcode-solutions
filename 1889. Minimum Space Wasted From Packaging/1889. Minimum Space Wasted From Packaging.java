/*
 * Problem: 1889. Minimum Space Wasted From Packaging
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-space-wasted-from-packaging/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        long total = 0;
        for (int i = 0; i < packages.length; i++) {
            total += packages[i];
        }
        int[] idx = new int[100001];
        Arrays.fill(idx, -1);
        int idxP = packages.length - 1;
        for (int i = 100000; i >= 0; i--) {
            while (idxP >= 0 && packages[idxP] > i) {
                idxP--;
            }
            if (idxP < 0)
                break;
            idx[i] = idxP;
        }
        long res = Long.MAX_VALUE;
        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < packages[packages.length - 1])
                continue;
            long sum = 0;
            int prv = -1;
            for (int i = 0; i < box.length && prv < packages.length - 1; i++) {
                if (idx[box[i]] == prv)
                    continue;
                sum += (long) box[i] * (idx[box[i]] - prv);
                prv = idx[box[i]];
            }
            res = Math.min(sum - total, res);
        }
        if (res == Long.MAX_VALUE)
            return -1;
        return (int) (res % 1_000_000_007);
    }
}
