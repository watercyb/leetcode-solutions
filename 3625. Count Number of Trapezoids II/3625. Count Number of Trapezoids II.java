/*
 * Problem: 3625. Count Number of Trapezoids II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-number-of-trapezoids-ii/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Long, HashMap<Long, HashMap<Long, Integer>>> HMs = new HashMap<>(points.length * points.length, 0.99f);
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                long[] pairs = getPair(x1, y1, x2, y2);
                long cos = pairs[0];
                long len = pairs[1];
                long p = pairs[2];
                if (!HMs.containsKey(cos))
                    HMs.put(cos, new HashMap<>());
                HashMap<Long, HashMap<Long, Integer>> HM = HMs.get(cos);
                if (!HM.containsKey(p))
                    HM.put(p, new HashMap<>());
                HashMap<Long, Integer> HM1 = HM.get(p);
                HM1.put(len, HM1.getOrDefault(len, 0) + 1);
            }
        }
        int res = 0;
        int sum = 0;
        int res1 = 0;
        for (Map.Entry<Long, HashMap<Long, HashMap<Long, Integer>>> entry : HMs.entrySet()) {
            sum = 0;
            HashMap<Long, Integer> counts = new HashMap<>();
            for (Map.Entry<Long, HashMap<Long, Integer>> entry1 : entry.getValue().entrySet()) {
                int count = 0;
                for (Map.Entry<Long, Integer> entry2 : entry1.getValue().entrySet()) {
                    long k1 = entry2.getKey();
                    int v1 = entry2.getValue();
                    int countK1 = counts.getOrDefault(k1, 0);
                    res += (sum - countK1) * v1;
                    res1 += countK1 * v1;
                    counts.put(k1, countK1 + v1);
                    count += v1;
                }
                sum += count;
            }
        }
        return res + res1 / 2;
    }

    public long[] getPair(int x1, int y1, int x2, int y2) {
        if (y1 > y2 || (y1 == y2 && x1 > x2))
            return getPair(x2, y2, x1, y1);
        int x = x2 - x1;
        int y = y2 - y1;
        double len = Math.sqrt(x * x + y * y);
        double cos = (double) x / len;
        double p = 0;
        if (x1 == x2) {
            p = x1;
        } else if (y1 == y2) {
            p = y1;
        } else {
            double slope = (double) (y1 - y2) / (x1 - x2);
            p = y1 - slope * x1;
        }
        return new long[] { round(cos), round(len), round(p) };
    }

    public long round(double num) {
        return (long) Math.round(num * 1000000000.0);
    }
}
