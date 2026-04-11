/*
 * Problem: 1048. Longest String Chain
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-string-chain/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int longestStrChain(String[] words) {
        List<char[]>[] Li = new ArrayList[17];
        List<Integer>[] DP = new ArrayList[17];
        for (String word : words) {
            int l = word.length();
            if (Li[l] == null) {
                Li[l] = new ArrayList();
                DP[l] = new ArrayList();
            }
            Li[l].add(word.toCharArray());
        }
        int max = 1;
        for (int i = 1; i < 17; i++) {
            if (Li[i] == null)
                continue;
            for (int j = 0; j < Li[i].size(); j++) {
                if (Li[i - 1] == null) {
                    DP[i].add(1);
                } else {
                    char[] thisWord = Li[i].get(j);
                    int thisMax = 0;
                    for (int k = 0; k < Li[i - 1].size(); k++) {
                        if (chk(thisWord, Li[i - 1].get(k)) && DP[i - 1].get(k) > thisMax)
                            thisMax = DP[i - 1].get(k);
                    }
                    DP[i].add(++thisMax);
                    if (thisMax > max)
                        max = thisMax;
                }
            }
        }
        return max;
    }

    public boolean chk(char[] a, char[] b) {
        int i = 0;
        int j = 0;
        while (j < b.length) {
            if (a[i] != b[j]) {
                if (i > j) {
                    return false;
                } else {
                    i++;
                    continue;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}
