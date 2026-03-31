/*
 * Problem: 299. Bulls and Cows
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bulls-and-cows/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public String getHint(String secret, String guess) {
        char[] chrsS = secret.toCharArray();
        char[] chrsG = guess.toCharArray();
        int[] counts = new int['9' + 1];
        for (int i = 0; i < chrsS.length; i++) {
            counts[chrsS[i]]++;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (chrsG[i] == chrsS[i]) {
                if (counts[chrsG[i]]-- <= 0) {
                    b--;
                }
                a++;
            } else if (counts[chrsG[i]] > 0) {
                counts[chrsG[i]]--;
                b++;
            }
        }
        return new StringBuilder().append(a).append('A').append(b).append('B').toString();
    }
}
