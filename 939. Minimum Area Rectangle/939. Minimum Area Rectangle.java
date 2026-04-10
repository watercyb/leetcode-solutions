/*
 * Problem: 939. Minimum Area Rectangle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-area-rectangle/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, List<Integer>> HM = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] != points[j][1])
                    continue;
                int min = Math.min(points[i][0], points[j][0]);
                int max = points[i][0] + points[j][0] - min;
                int h = min * 40001 + max;
                if (!HM.containsKey(h)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(points[i][1]);
                    HM.put(h, list);
                } else {
                    List<Integer> list = HM.get(h);
                    list.add(points[i][1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : HM.entrySet()) {
            int k = entry.getKey();
            List<Integer> v = entry.getValue();
            if (v.size() > 1) {
                int width = k % 40001 - k / 40001;
                int min = Integer.MAX_VALUE;
                Collections.sort(v);
                for (int i = 1; i < v.size(); i++) {
                    min = Math.min(v.get(i) - v.get(i - 1), min);
                }
                res = Math.min(min * width, res);
            }
        }
        if (res == Integer.MAX_VALUE)
            return 0;
        return res;
    }
}
