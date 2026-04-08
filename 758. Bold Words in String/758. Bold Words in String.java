/*
 * Problem: 758. Bold Words in String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bold-words-in-string/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String boldWords(String[] words, String s) {
        char[] chrs = s.toCharArray();
        int[] arr = new int[chrs.length + 1];
        for (String word : words) {
            int len = word.length();
            int idx = s.indexOf(word);
            while (idx >= 0) {
                arr[idx]++;
                arr[idx + len]--;
                idx = s.indexOf(word, idx + 1);
            }
        }
        StringBuilder SB = new StringBuilder();
        int sum = 0;
        boolean isBold = false;
        for (int i = 0; i < chrs.length; i++) {
            sum += arr[i];
            if (sum > 0) {
                if (!isBold) {
                    isBold = true;
                    SB.append("<b>");
                }
            } else if (isBold) {
                isBold = false;
                SB.append("</b>");
            }
            SB.append(chrs[i]);
        }
        if (isBold)
            SB.append("</b>");
        return SB.toString();
    }
}
