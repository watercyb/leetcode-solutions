/*
 * Problem: 2013. Detect Squares
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/detect-squares/
 * Language: java
 * Date: 2026-04-23
 */

class DetectSquares {
    HashMap<Integer, HashMap<Integer, Integer>> HM = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        if (!HM.containsKey(point[0])) {
            HashMap<Integer, Integer> tmp = new HashMap<>();
            tmp.put(point[1], 1);
            HM.put(point[0], tmp);
        } else {
            HashMap<Integer, Integer> tmp = HM.get(point[0]);
            tmp.put(point[1], tmp.getOrDefault(point[1], 0) + 1);
        }
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int res = 0;
        if (HM.containsKey(x)) {
            HashMap<Integer, Integer> tmp = HM.get(x);
            for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
                int y1 = entry.getKey();
                if (y1 != y) {
                    int x2 = x + y1 - y;
                    if (HM.containsKey(x2)) {
                        HashMap<Integer, Integer> tmp1 = HM.get(x2);
                        if (tmp1.containsKey(y) && tmp1.containsKey(y1))
                            res += entry.getValue() * tmp1.get(y) * tmp1.get(y1);
                    }
                    x2 = x - y1 + y;
                    if (HM.containsKey(x2)) {
                        HashMap<Integer, Integer> tmp1 = HM.get(x2);
                        if (tmp1.containsKey(y) && tmp1.containsKey(y1))
                            res += entry.getValue() * tmp1.get(y) * tmp1.get(y1);
                    }
                }
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
