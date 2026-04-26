/*
 * Problem: 2306. Naming a Company
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/naming-a-company/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long distinctNames(String[] ideas) {
        HashMap<String, boolean[]> HM = new HashMap<>(ideas.length, 0.99f);
        for (String idea : ideas) {
            String h = idea.substring(1);
            if (!HM.containsKey(h)) {
                boolean[] seens = new boolean[26];
                seens[idea.charAt(0) - 'a'] = true;
                HM.put(h, seens);
            } else {
                HM.get(h)[idea.charAt(0) - 'a'] = true;
            }
        }
        int[][] counts = new int[26][26];
        long res = 0;
        for (boolean[] seens : HM.values()) {
            for (char i = 0; i < 26; i++) {
                if (!seens[i])
                    continue;
                for (char j = 0; j < 26; j++) {
                    if (!seens[j]) {
                        counts[i][j]++;
                        res += counts[j][i];
                    }
                }
            }
        }
        return res * 2;
    }
}
