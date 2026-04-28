/*
 * Problem: 2506. Count Pairs Of Similar Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-pairs-of-similar-strings/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int similarPairs(String[] words) {
        int[] charToNum = new int['z' + 1];
        for (int i = 'a'; i <= 'z'; i++) {
            charToNum[i] = 1 << (i - 'a');
        }
        HashMap<Integer, Integer> HM = new HashMap<>();
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            int h = getH(charToNum, words[i]);
            int count = HM.getOrDefault(h, 0);
            res += count;
            HM.put(h, count + 1);
        }
        return res;
    }

    public int getH(int[] charToNum, String word) {
        int res = 0;
        for (char chr : word.toCharArray()) {
            res |= charToNum[chr];
        }
        return res;
    }
}
