/*
 * Problem: 249. Group Shifted Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/group-shifted-strings/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> HM = new HashMap<>();
        for (String str : strings) {
            String tmp = getIni(str);
            if (!HM.containsKey(tmp)) {
                List<String> Li = new ArrayList<>();
                Li.add(str);
                HM.put(tmp, Li);
            } else {
                HM.get(tmp).add(str);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> Li : HM.values()) {
            res.add(Li);
        }
        return res;
    }

    public String getIni(String str) {
        if (str.charAt(0) == 'a')
            return str;
        StringBuilder SB = new StringBuilder();
        int diff = 26 - str.charAt(0) ;
        for (int i = 0; i < str.length(); i++) {
            SB.append((char) ((str.charAt(i) + diff) % 26 + 'a'));
        }
        return SB.toString();
    }
}
