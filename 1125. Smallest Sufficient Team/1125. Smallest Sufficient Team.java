/*
 * Problem: 1125. Smallest Sufficient Team
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-sufficient-team/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = people.size();
        HashMap<String, Integer> HM = new HashMap<>();
        for (String str : req_skills) {
            if (!HM.containsKey(str))
                HM.put(str, HM.size());
        }
        int target = (1 << HM.size()) - 1;
        int[] hs = new int[n];
        long[] DP = new long[target + 1];
        int[] counts = new int[target + 1];
        Arrays.fill(counts, Integer.MAX_VALUE / 2);
        for (int i = 0; i < n; i++) {
            List<String> list = people.get(i);
            int h = 0;
            for (String str : list) {
                if (HM.containsKey(str))
                    h += 1 << HM.get(str);
            }
            if (h == target)
                return new int[] { i };
            hs[i] = h;
            long mask = 1l << i;
            for (int j = 0; j < i; j++) {
                if ((hs[j] | mask) == hs[j])
                    continue;
            }
            DP[h] = mask;
            counts[h] = 1;
            for (int j = target; j >= 0; j--) {
                if ((DP[j] & mask) == 0 && counts[j | hs[i]] > counts[j] + 1) {
                    DP[j | hs[i]] = DP[j] | mask;
                    counts[j | hs[i]] = counts[j] + 1;
                }
            }
        }
        int[] res = new int[Long.bitCount(DP[target])];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if ((DP[target] & (1l << i)) != 0)
                res[idx++] = i;
        }
        return res;
    }
}
