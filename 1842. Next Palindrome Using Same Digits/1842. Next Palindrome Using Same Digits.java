/*
 * Problem: 1842. Next Palindrome Using Same Digits
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/next-palindrome-using-same-digits/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public String nextPalindrome(String num) {
        if (num.length() <= 3)
            return "";
        char[] chrs = num.toCharArray();
        int l = 0;
        int r = chrs.length / 2 - 1;
        int[] counts = new int['9' + 1];
        counts[chrs[r]]++;
        int max = chrs[r];
        for (int i = r - 1; i >= l; i--) {
            counts[chrs[i]]++;
            if (chrs[i] < max) {
                for (int j = chrs[i] + 1; j <= max; j++) {
                    if (counts[j] != 0) {
                        chrs[i] = (char) j;
                        chrs[chrs.length - 1 - i] = chrs[i];
                        counts[j]--;
                        i++;
                        break;
                    }
                }
                for (int k = '0'; k <= '9'; k++) {
                    for (int n = 0; n < counts[k]; n++) {
                        chrs[i] = (char) k;
                        chrs[chrs.length - 1 - i] = chrs[i];
                        i++;
                    }
                }
                return new String(chrs);
            }
            max = chrs[i];
        }
        return "";
    }
}
