/*
 * Problem: 748. Shortest Completing Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shortest-completing-word/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] counts = new int['z' + 1];
        int count = 0;
        for (char chr : licensePlate.toCharArray()) {
            if (Character.isLowerCase(chr)) {
                if (counts[chr]++ == 0)
                    count++;
            } else if (Character.isUpperCase(chr)) {
                if (counts[chr + 32]++ == 0)
                    count++;
            }
        }
        int[][] arr = new int[count][2];
        int idx = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] > 0)
                arr[idx++] = new int[] { i, counts[i] };
        }
        String res = "";
        int length = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() >= length)
                continue;
            int[] wordCounts = new int['z' + 1];
            for (char chr : word.toCharArray()) {
                wordCounts[chr]++;
            }
            int i = 0;
            while (i < arr.length && wordCounts[arr[i][0]] >= arr[i][1]) {
                i++;
            }
            if (i == arr.length) {
                length = word.length();
                res = word;
            }
        }
        return res;
    }
}
