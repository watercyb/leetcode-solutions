/*
 * Problem: 2416. Sum of Prefix Scores of Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-prefix-scores-of-strings/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Word[] arr = new Word[words.length];
        int length = 0;
        for (int i = 0; i < words.length; i++) {
            arr[i] = new Word(words[i], i);
            length = Math.max(arr[i].chrs.length, length);
        }
        Arrays.sort(arr, (a, b) -> a.str.compareTo(b.str));
        int[] rights = new int[words.length];
        Arrays.fill(rights, arr.length - 1);
        int[] res = new int[words.length];
        for (int i = 0; i < length; i++) {
            int j = 0;
            while (j < arr.length) {
                while (j < arr.length && arr[j].chrs.length <= i) {
                    j++;
                }
                if (j == arr.length)
                    break;
                char chr = arr[j].chrs[i];
                int count = 1;
                int right = rights[j];
                while (j < right && arr[j + 1].chrs.length > i && chr == arr[j + 1].chrs[i]) {
                    count++;
                    j++;
                }
                for (int k = j - count + 1; k <= j; k++) {
                    res[arr[k].idx] += count;
                    rights[k] = j;
                }
                j++;
            }
        }
        return res;
    }
}

class Word {
    String str = "";
    char[] chrs;
    int idx = 0;

    public Word(String str, int idx) {
        this.str = str;
        chrs = str.toCharArray();
        this.idx = idx;
    }
}
