/*
 * Problem: 819. Most Common Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/most-common-word/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> HS = new HashSet<>();
        HashMap<String, Integer> HM = new HashMap<>();
        for (String ban : banned) {
            HS.add(ban);
        }
        StringBuilder SB = new StringBuilder();
        String res = "";
        int max = 0;
        for (char chr : paragraph.toCharArray()) {
            if (Character.isUpperCase(chr)) {
                SB.append((char) (chr + 32));
            } else if (Character.isLowerCase(chr)) {
                SB.append(chr);
            } else if (!SB.isEmpty()) {
                String str = SB.toString();
                if (!HS.contains(str)) {
                    int count = HM.getOrDefault(str, 0) + 1;
                    if (count > max) {
                        max = count;
                        res = str;
                    }
                    HM.put(str, count);
                }
                SB.setLength(0);
            }
        }
        if (!SB.isEmpty()) {
            String str = SB.toString();
            if (!HS.contains(str)) {
                int count = HM.getOrDefault(str, 0) + 1;
                if (count > max) {
                    max = count;
                    res = str;
                }
                HM.put(str, count);
            }
        }
        return res;
    }
}
