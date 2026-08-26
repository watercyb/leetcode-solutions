/*
 * Problem: 68. Text Justification
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/text-justification/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int count = 0;
            int length = 0;
            int j = i;
            while (j < words.length && length + words[j].length() + count <= maxWidth) {
                length += words[j].length();
                count++;
                j++;
            }
            int space = maxWidth - length;
            StringBuilder SB = new StringBuilder();
            if (j == words.length) {
                while (i < j - 1) {
                    SB.append(words[i]);
                    SB.append(' ');
                    space--;
                    i++;
                }
                SB.append(words[i]);
                for (int k = 0; k < space; k++) {
                    SB.append(' ');
                }
            } else {
                while (i < j - 1) {
                    SB.append(words[i]);
                    int tmp = (int) Math.ceil((double) space / --count);
                    for (int k = 0; k < tmp; k++) {
                        SB.append(' ');
                    }
                    space -= tmp;
                    i++;
                }
                SB.append(words[i]);
                if (space > 0) {
                    for (int k = 0; k < space; k++) {
                        SB.append(' ');
                    }
                }
            }
            res.add(SB.toString());
            i++;
        }
        return res;
    }
}
