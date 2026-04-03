/*
 * Problem: 391. Perfect Rectangle
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/perfect-rectangle/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        HashMap<Integer, HashSet<Integer>> HS = new HashMap<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        long area=0;
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i][0] < x1)
                x1 = rectangles[i][0];
            if (rectangles[i][1] < y1)
                y1 = rectangles[i][1];
            if (rectangles[i][2] > x2)
                x2 = rectangles[i][2];
            if (rectangles[i][3] > y2)
                y2 = rectangles[i][3];
            area+=(long)(rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
            put(HS, rectangles[i][0], rectangles[i][1]);
            put(HS, rectangles[i][2], rectangles[i][3]);
            put(HS, rectangles[i][0], rectangles[i][3]);
            put(HS, rectangles[i][2], rectangles[i][1]);
        }
        if (!HS.get(x1).contains(y1)|| !HS.get(x1).contains(y2)|| !HS.get(x2).contains(y1)|| !HS.get(x2).contains(y2))
            return false;

        for (Map.Entry<Integer, HashSet<Integer>> ex : HS.entrySet()) {
            int x = ex.getKey();
            for (int y : ex.getValue()) {
                if ((x != x1 && x != x2) || (y != y1 && y != y2))
                    return false;
            }
        }       
        return (long)(x2-x1)*(y2-y1)==area;
    }

    public void put(HashMap<Integer, HashSet<Integer>> HS, int x, int y) {
        HashSet<Integer> tmp = HS.getOrDefault(x, new HashSet<Integer>());
        if (tmp.contains(y)) {
            tmp.remove(y);
        } else {
            tmp.add(y);
        }
        HS.put(x, tmp);
    }

}
