/*
 * Problem: 884. Uncommon Words from Two Sentences
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> HM = new HashMap<>();
        int count = 0;
        for (String str : s1.split(" ")) {
            int n = HM.getOrDefault(str, 0) + 1;
            if (n == 1) {
                count++;
            } else if (n == 2) {
                count--;
            }
            HM.put(str, n);
        }
        for (String str : s2.split(" ")) {
            int n = HM.getOrDefault(str, 0) + 1;
            if (n == 1) {
                count++;
            } else if (n == 2) {
                count--;
            }
            HM.put(str, n);
        }
        String[] res = new String[count];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            if (entry.getValue() == 1)
                res[idx++] = entry.getKey();
        }
        return res;
    }
}
