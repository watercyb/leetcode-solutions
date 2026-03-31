/*
 * Problem: 267. Palindrome Permutation II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/palindrome-permutation-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public List<String> generatePalindromes(String s) {
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int count = 0;
        char chr = '#';
        List<Character> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] > 0) {
                if ((counts[i] & 1) == 1) {
                    count++;
                    chr = (char) i;
                    if (counts[i] > 1) {
                        list.add((char) i);
                        list1.add(counts[i] / 2);
                    }
                } else {
                    list.add((char) i);
                    list1.add(counts[i] / 2);
                }
            }
        }
        if (count > 1)
            return new ArrayList<>();
        char[] arr = new char[list.size()];
        int[] arr1 = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
            arr1[i] = list1.get(i);
        }
        char[] chrs = new char[s.length()];
        if (chr != '#')
            chrs[chrs.length / 2] = chr;
        dfs(arr, arr1, chrs, 0);
        return res;
    }

    List<String> res = new ArrayList<>();

    public void dfs(char[] arr, int[] arr1, char[] chrs, int i) {
        if (i == chrs.length / 2) {
            res.add(new String(chrs));
        } else {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] > 0) {
                    arr1[j]--;
                    chrs[i] = chrs[chrs.length - 1 - i] = arr[j];
                    dfs(arr, arr1, chrs, i + 1);
                    arr1[j]++;
                }
            }
        }
    }
}
