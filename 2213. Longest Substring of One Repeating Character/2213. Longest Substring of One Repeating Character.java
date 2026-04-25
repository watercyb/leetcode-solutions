/*
 * Problem: 2213. Longest Substring of One Repeating Character
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-substring-of-one-repeating-character/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    char[] chrLefts;
    int[] lenLefts;
    char[] chrRights;
    int[] lenRights;
    int[] lens;
    int[] maxes;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] chrs = s.toCharArray();
        char[] chrsQ = queryCharacters.toCharArray();
        int len = (int) 1 << (32 - Integer.numberOfLeadingZeros(chrs.length));
        chrLefts = new char[len * 2 - 1];
        lenLefts = new int[len * 2 - 1];
        chrRights = new char[len * 2 - 1];
        lenRights = new int[len * 2 - 1];
        lens = new int[len * 2 - 1];
        maxes = new int[len * 2 - 1];
        for (int i = len - 1; i < len - 1 + chrs.length; i++) {
            chrLefts[i] = chrRights[i] = chrs[i - len + 1];
            lenLefts[i] = lenRights[i] = lens[i] = maxes[i] = 1;
        }
        for (int i = len - 1 + chrs.length; i < chrLefts.length; i++) {
            chrLefts[i] = chrRights[i] = (char) ('1' + i % 2);
            lenLefts[i] = lenRights[i] = lens[i] = maxes[i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            lens[i] = lens[l] + lens[r];
            change(l, r, i);
        }
        int[] res = new int[chrsQ.length];
        for (int i = 0; i < chrsQ.length; i++) {
            if (chrsQ[i] != chrs[queryIndices[i]]) {
                modify(0, queryIndices[i], chrsQ[i], 0, len - 1);
                chrs[queryIndices[i]] = chrsQ[i];
            }
            res[i] = maxes[0];
        }
        return res;
    }

    public void change(int l, int r, int i) {
        chrLefts[i] = chrLefts[l];
        chrRights[i] = chrRights[r];
        if (chrRights[l] == chrLefts[r]) {
            if (lenLefts[l] == lens[l] && lenRights[r] == lens[r]) {
                lenLefts[i] = lenRights[i] = lens[i];
                maxes[i] = lens[i];
            } else if (lenLefts[l] == lens[l]) {
                lenLefts[i] = lens[l] + lenLefts[r];
                lenRights[i] = lenRights[r];
                maxes[i] = lenLefts[i];
            } else if (lenRights[r] == lens[r]) {
                lenLefts[i] = lenLefts[l];
                lenRights[i] = lenRights[l] + lens[r];
                maxes[i] = lenRights[i];
            } else {
                lenLefts[i] = lenLefts[l];
                lenRights[i] = lenRights[r];
                maxes[i] = Math.max(lenRights[l] + lenLefts[r], Math.max(maxes[l], maxes[r]));
            }
        } else {
            lenLefts[i] = lenLefts[l];
            lenRights[i] = lenRights[r];
            maxes[i] = Math.max(maxes[l], maxes[r]);
        }
    }

    public void modify(int i, int idx, char chr, int left, int right) {
        if (idx < left || idx > right)
            return;
        if (left == right) {
            chrLefts[i] = chrRights[i] = chr;
        } else {
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            int mid = (left + right) >>> 1;
            modify(l, idx, chr, left, mid);
            modify(r, idx, chr, mid + 1, right);
            change(l, r, i);
        }
    }
}
