/*
 * Problem: 3805. Count Caesar Cipher Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-caesar-cipher-pairs/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long countPairs(String[] words) {
        HashMap<String, Long> HM = new HashMap<>(words.length, 0.99f);
        long res = 0;
        for (String word : words) {
            word = getH(word);
            long count = HM.getOrDefault(word, 0l);
            res += count;
            HM.put(word, count + 1);
        }
        return res;
    }

    public String getH(String str) {
        char[] chrs = str.toCharArray();
        char chr = chrs[0];
        for (int i = 0; i < chrs.length; i++) {
            chrs[i] = (char) ((chrs[i] - chr + 26) % 26 + 'a');
        }
        return new String(chrs);
    }
}
