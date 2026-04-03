/*
 * Problem: 356. Line Reflection
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/line-reflection/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean isReflected(int[][] points) {
        HashMap<Integer, List<Integer>> HM = new HashMap<>();
        for (int[] point : points) {
            if (!HM.containsKey(point[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(point[0]);
                HM.put(point[1], list);
            } else {
                List<Integer> list = HM.get(point[1]);
                list.add(point[0]);
            }
        }
        double mid = Integer.MIN_VALUE;
        for (List<Integer> list : HM.values()) {
            if (mid == Integer.MIN_VALUE) {
                mid = getMid(list);
                if (mid == Integer.MIN_VALUE)
                    return false;
            } else {
                if (!chk(list, mid))
                    return false;
            }
        }
        return true;
    }

    public boolean chk(List<Integer> list, double mid) {
        Collections.sort(list);
        int l = 0;
        int r = list.size() - 1;
        if (mid != ((double) list.get(l++) + list.get(r--)) / 2)
            return false;
        while (l <= r) {
            if (list.get(l) == list.get(l - 1)) {
                l++;
                continue;
            }
            if (list.get(r) == list.get(r + 1)) {
                r--;
                continue;
            }
            if (mid != ((double) list.get(l++) + list.get(r--)) / 2)
                return false;
        }
        return true;
    }

    public double getMid(List<Integer> list) {
        Collections.sort(list);
        int l = 0;
        int r = list.size() - 1;
        double res = ((double) list.get(l++) + list.get(r--)) / 2;
        while (l <= r) {
            if (list.get(l) == list.get(l - 1)) {
                l++;
                continue;
            }
            if (list.get(r) == list.get(r + 1)) {
                r--;
                continue;
            }
            if (res != ((double) list.get(l++) + list.get(r--)) / 2)
                return Integer.MIN_VALUE;
        }
        return res;
    }
}
