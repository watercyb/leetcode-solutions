/*
 * Problem: 811. Subdomain Visit Count
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subdomain-visit-count/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> HM = new HashMap<>();
        for (String cpd : cpdomains) {
            String[] strs = cpd.split(" ");
            int num = Integer.valueOf(strs[0]);
            HM.put(strs[1], HM.getOrDefault(strs[1], 0) + num);
            int idx = strs[1].indexOf(".");
            while (idx >= 0) {
                String k = strs[1].substring(idx + 1);
                HM.put(k, HM.getOrDefault(k, 0) + num);
                idx = strs[1].indexOf(".", idx + 1);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            res.add(new StringBuilder().append(v).append(' ').append(k).toString());
        }
        return res;
    }
}
