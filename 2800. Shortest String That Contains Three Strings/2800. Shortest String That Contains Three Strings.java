/*
 * Problem: 2800. Shortest String That Contains Three Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-string-that-contains-three-strings/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public String minimumString(String a, String b, String c) {
        chk(a, b, c);
        chk(b, a, c);
        chk(c, a, b);
        chk(a, c, b);
        chk(b, c, a);
        chk(c, b, a);
        return res;
    }

    String res;

    public void chk(String a, String b, String c) {
        String str = getString(getString(a, b), c);
        if (res == null || res.length() > str.length() || (res.length() == str.length() && str.compareTo(res) < 0))
            res = str;
    }

    public String getString(String a, String b) {
        char[] chrsA = a.toCharArray();
        char[] chrsB = b.toCharArray();
        int[] LPS = getLPS(chrsB);
        int len = 0;
        int idx = 0;
        while (idx < chrsA.length) {
            if (chrsA[idx] == chrsB[len]) {
                idx++;
                len++;
                if (len == chrsB.length)
                    return a;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    idx++;
                }
            }
        }
        return new StringBuilder(a).append(b.substring(len)).toString();
    }

    public int[] getLPS(char[] chrs) {
        int[] res = new int[chrs.length];
        int idx = 1;
        int len = 0;
        while (idx < chrs.length) {
            if (chrs[idx] == chrs[len]) {
                res[idx] = ++len;
                idx++;
            } else {
                if (len != 0) {
                    len = res[len - 1];
                } else {
                    idx++;
                }
            }
        }
        return res;
    }
}
