/*
 * Problem: 3995. Minimum Cost to Convert String III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-convert-string-iii/
 * Language: java
 * Date: 2026-07-18
 */

class Solution {
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        char[] chrsS = source.toCharArray();
        char[] chrsT = target.toCharArray();
        int[] DP = new int[chrsT.length + 1];
        Arrays.fill(DP, Integer.MAX_VALUE / 2);
        DP[0] = 0;
        char[][] as = new char[costs.length][];
        char[][] bs = new char[costs.length][];
        for (int i = 0; i < costs.length; i++) {
            as[i] = rules.get(i).get(0).toCharArray();
            bs[i] = rules.get(i).get(1).toCharArray();
            for (char chr : as[i]) {
                if (chr == '*')
                    costs[i]++;
            }
        }
        for (int i = 0; i < chrsS.length; i++) {
            for (int j = 0; j < costs.length; j++) {
                if (chrsS[i] == chrsT[i] && DP[i] < DP[i + 1])
                    DP[i + 1] = DP[i];
                if (i >= as[j].length - 1) {
                    if (DP[i + 1] > DP[i - as[j].length + 1] + costs[j]) {
                        boolean isGood = true;
                        for (int k = as[j].length - 1; k >= 0; k--) {
                            if ((as[j][k] != '*' && as[j][k] != chrsS[i - (as[j].length - 1 - k)])
                                    || bs[j][k] != chrsT[i - (as[j].length - 1 - k)]) {
                                isGood = false;
                                break;
                            }
                        }
                        if (isGood)
                            DP[i + 1] = DP[i - as[j].length + 1] + costs[j];
                    }
                }
            }
        }
        if (DP[chrsT.length] >= Integer.MAX_VALUE / 2)
            return -1;
        return DP[chrsT.length];
    }
}
