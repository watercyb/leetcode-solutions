/*
 * Problem: 3382. Maximum Area Rectangle With Point Constraints II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        HashSet<Integer> HS = new HashSet<>();
        for (int y : yCoord) {
            HS.add(y);
        }
        int[] arr = new int[HS.size()];
        int idx = 0;
        for (int y : HS) {
            arr[idx++] = y;
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            HM.put(arr[i], i);
        }
        BIT = new int[HM.size() + 1];
        int[][] points = new int[xCoord.length][];
        for (int i = 0; i < xCoord.length; i++) {
            points[i] = new int[] { xCoord[i], yCoord[i] };
        }
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[][] pairs = new int[HM.size()][];
        insert(HM.get(points[0][1]));
        long res = -1;
        for (int i = 1; i < points.length; i++) {
            int y1 = HM.get(points[i - 1][1]);
            int y2 = HM.get(points[i][1]);
            insert(y2);
            if (points[i - 1][0] != points[i][0])
                continue;
            int count = get(y2) - get(y1 - 1);
            if (pairs[y1] != null && pairs[y1][0] == y2 && count - pairs[y1][2] == 2)
                res = Math.max((long) (points[i][0] - pairs[y1][1]) * (arr[y2] - arr[y1]), res);
            pairs[y1] = new int[] { y2, points[i][0], count };
        }
        return res;
    }

    int[] BIT;

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }

    public void insert(int i) {
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }
}
