/*
 * Problem: 128. Longest Consecutive Sequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        HashSet<Integer> seens = new HashSet<>();
        for (int num : nums) {
            if (!seens.add(num))
                continue;
            if (!HM.containsKey(num))
                HM.put(num, num);
            if (HM.containsKey(num - 1)) {
                int a = find(HM, num - 1);
                int b = find(HM, num);
                if (a != b)
                    HM.put(a, b);
            }
            if (HM.containsKey(num + 1)) {
                int a = find(HM, num + 1);
                int b = find(HM, num);
                if (a != b)
                    HM.put(a, b);
            }
        }
        int res = 0;
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
            int v = find(HM, entry.getValue());
            int count = counts.getOrDefault(v, 0) + 1;
            res = Math.max(res, count);
            counts.put(v, count);
        }
        return res;
    }

    public int find(HashMap<Integer, Integer> HM, int i) {
        if (HM.get(i) != i)
            HM.put(i, find(HM, HM.get(i)));
        return HM.get(i);
    }
}
