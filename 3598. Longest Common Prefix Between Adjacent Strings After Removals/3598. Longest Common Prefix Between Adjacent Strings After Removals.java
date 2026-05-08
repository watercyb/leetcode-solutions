/*
 * Problem: 3598. Longest Common Prefix Between Adjacent Strings After Removals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-common-prefix-between-adjacent-strings-after-removals/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] longestCommonPrefix(String[] words) {
        if (words.length <= 2)
            return new int[words.length];
        int[] arr = new int[words.length - 1];
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        char[][] chrs = new char[words.length][];
        chrs[0] = words[0].toCharArray();
        for (int i = 0; i < words.length - 1; i++) {
            chrs[i + 1] = words[i + 1].toCharArray();
            arr[i] = getLen(chrs[i], chrs[i + 1]);
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3) {
                max3 = arr[i];
            }
        }
        int[] res = new int[words.length];
        if (arr[0] == max1) {
            res[0] = max2;
        } else {
            res[0] = max1;
        }
        for (int i = 1; i < words.length - 1; i++) {
            int len = getLen(chrs[i - 1], chrs[i + 1]);
            if (len >= max1) {
                res[i] = len;
            } else if (arr[i - 1] + arr[i] == max1 + max2) {
                res[i] = Math.max(max3, len);
            } else if (arr[i - 1] == max1 || arr[i] == max1) {
                res[i] = Math.max(max2, len);
            } else {
                res[i] = max1;
            }
        }
        if (arr[arr.length - 1] == max1) {
            res[arr.length] = max2;
        } else {
            res[arr.length] = max1;
        }
        return res;
    }

    public int getLen(char[] chrsA, char[] chrsB) {
        int i = 0;
        while (i < chrsA.length && i < chrsB.length) {
            if (chrsA[i] != chrsB[i])
                return i;
            i++;
        }
        return i;
    }
}
