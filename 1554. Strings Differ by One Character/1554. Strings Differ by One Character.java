/*
 * Problem: 1554. Strings Differ by One Character
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/strings-differ-by-one-character/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public boolean differByOne(String[] dict) {
        if (dict[0].length() > 10) {
            char[][] chrs = new char[dict.length][];
            for (int i = 0; i < dict.length; i++) {
                chrs[i] = dict[i].toCharArray();
            }
            for (int i = 0; i < dict.length - 1; i++) {
                for (int j = i + 1; j < dict.length; j++) {
                    int n = 0;
                    for (int k = 0; k < dict[i].length(); k++) {
                        if (chrs[i][k] != chrs[j][k]) {
                            n++;
                            if (n == 2)
                                break;
                        }
                    }
                    if (n < 2)
                        return true;
                }
            }
            return false;
        }
        HashSet<String> HS = new HashSet<>();
        for (int i = 0; i < dict.length; i++) {
            char[] tmp = dict[i].toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                char prv = tmp[j];
                tmp[j] = '@';
                String str = new String(tmp);
                if (HS.contains(str))
                    return true;
                HS.add(str);
                tmp[j] = prv;
            }
        }
        return false;
    }
}
