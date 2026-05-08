/*
 * Problem: 3527. Find the Most Common Response
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-most-common-response/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        int count = 0;
        for (List<String> response : responses) {
            count += response.size();
        }
        HashMap<String, Integer> HM = new HashMap<>(count, 0.99f);
        for (List<String> response : responses) {
            HashSet<String> HS = new HashSet<>();
            for (String str : response) {
                if (HS.add(str)) {
                    HM.put(str, HM.getOrDefault(str, 0) + 1);
                }
            }
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            if (v > max || (v == max && k.compareTo(res) < 0)) {
                max = v;
                res = k;
            }
        }
        return res;
    }
}
