/*
 * Problem: 1773. Count Items Matching a Rule
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-items-matching-a-rule/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx=ruleKey.equals("type")?0:ruleKey.equals("color")?1:2;
        int res=0;
        for (List<String> item:items) {
            if (item.get(idx).equals(ruleValue)) res++;
        }
        return res;
    }
}
