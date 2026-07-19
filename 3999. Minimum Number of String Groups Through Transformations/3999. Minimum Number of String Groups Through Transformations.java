/*
 * Problem: 3999. Minimum Number of String Groups Through Transformations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-string-groups-through-transformations/
 * Language: java
 * Date: 2026-07-19
 */

class Solution {
    public int minimumGroups(String[] words) {
        HashMap<String, Integer> HM = new HashMap<>();
        for (String word : words) {
            String str = getStr(word);
            HM.put(str, HM.getOrDefault(str, 0) + 1);
        }
        return HM.size();
    }

    public String getStr(String word) {
        int n = word.length();
        int lenE = (n + 1) / 2;
        int lenO = n - lenE;
        char[] e = new char[lenE];
        char[] o = new char[lenO];
        for (int i = 0; i < word.length(); i++) {
            if ((i & 1) == 0) {
                e[i / 2] = word.charAt(i);
            } else {
                o[i / 2] = word.charAt(i);
            }
        }
        e = getChrs(e);
        o = getChrs(o);
        char[] chrs = new char[word.length()];
        for (int i = 0; i < e.length; i++) {
            chrs[i * 2] = e[i];
        }
        for (int i = 0; i < o.length; i++) {
            chrs[i * 2 + 1] = o[i];
        }
        return new String(chrs);
    }

    public char[] getChrs(char[] chrs) {
        int i = 0;
        int j = 1;
        int len = 0;
        while (j < chrs.length) {
            if (len >= chrs.length)
                break;
            int ir = (i + len) % chrs.length;
            int jr = (j + len) % chrs.length;
            if (chrs[ir] == chrs[jr]) {
                len++;
            } else {
                if (chrs[ir] > chrs[jr])
                    i = j;
                j = Math.max(j + 1, jr);
                len = 0;
            }
        }
        char[] res = new char[chrs.length];
        for (int k = 0; k < chrs.length; k++) {
            res[k] = chrs[(k + i) % chrs.length];
        }
        return res;
    }
}
