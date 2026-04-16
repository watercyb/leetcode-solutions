/*
 * Problem: 1307. Verbal Arithmetic Puzzle
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/verbal-arithmetic-puzzle/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public boolean isSolvable(String[] words, String result) {
        boolean[] leadingChrs = new boolean['Z' + 1];
        char[][] chrWords = new char[words.length][];
        char[] chrResult = result.toCharArray();
        int max = 0;
        if (chrResult.length > 1)
            leadingChrs[chrResult[0]] = true;
        for (int i = 0; i < words.length; i++) {
            chrWords[i] = words[i].toCharArray();
            if (chrWords[i].length > 1)
                leadingChrs[chrWords[i][0]] = true;
            max = Math.max(chrWords[i].length, max);
        }
        if (max > chrResult.length || max < chrResult.length - 1)
            return false;
        int[] charToNums = new int['Z' + 1];
        Arrays.fill(charToNums, -1);
        char[] numToChars = new char[10];
        return dfs(chrWords, chrResult, charToNums, numToChars, leadingChrs, 0, 0, 0);
    }

    public boolean dfs(char[][] chrWords, char[] chrResult, int[] charToNums, char[] numToChars, boolean[] leadingChrs,
            int i,
            int j, int carry) {
        if (j == chrWords.length) {
            char chr = chrResult[chrResult.length - 1 - i];
            if (charToNums[chr] != -1) {
                return carry % 10 == charToNums[chr]
                        && dfs(chrWords, chrResult, charToNums, numToChars, leadingChrs, i + 1, 0, carry / 10);
            } else {
                int num = carry % 10;
                if (numToChars[num] != 0 || (num == 0 && leadingChrs[chr]))
                    return false;
                charToNums[chr] = num;
                numToChars[num] = chr;
                if (dfs(chrWords, chrResult, charToNums, numToChars, leadingChrs, i + 1, 0, carry / 10))
                    return true;
                charToNums[chr] = -1;
                numToChars[num] = 0;
            }
        } else {
            if (i == chrResult.length)
                return carry == 0;
            if (chrWords[j].length <= i)
                return dfs(chrWords, chrResult, charToNums, numToChars, leadingChrs, i, j + 1, carry);
            char chr = chrWords[j][chrWords[j].length - 1 - i];
            if (charToNums[chr] != -1) {
                return dfs(chrWords, chrResult, charToNums, numToChars, leadingChrs, i, j + 1, carry + charToNums[chr]);
            } else {
                for (int k = leadingChrs[chr] ? 1 : 0; k < 10; k++) {
                    if (numToChars[k] == 0) {
                        charToNums[chr] = k;
                        numToChars[k] = chr;
                        if (dfs(chrWords, chrResult, charToNums, numToChars, leadingChrs, i, j + 1, carry + k))
                            return true;
                        charToNums[chr] = -1;
                        numToChars[k] = 0;
                    }
                }
            }
        }
        return false;
    }
}
