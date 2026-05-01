/*
 * Problem: 2857. Count Pairs of Points With Distance k
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-pairs-of-points-with-distance-k/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> HMs = new HashMap<>();
        int res = 0;
        for (List<Integer> coordinate : coordinates) {
            int a = coordinate.get(0);
            int b = coordinate.get(1);
            for (int i = 0; i <= k; i++) {
                HashMap<Integer, Integer> HM = HMs.getOrDefault(i ^ a, null);
                if (HM != null)
                    res += HM.getOrDefault((k - i) ^ b, 0);
            }
            if (!HMs.containsKey(a)) {
                HashMap<Integer, Integer> HM = new HashMap<>();
                HM.put(b, 1);
                HMs.put(a, HM);
            } else {
                HashMap<Integer, Integer> HM = HMs.get(a);
                HM.put(b, HM.getOrDefault(b, 0) + 1);
            }
        }
        return res;
    }
}
