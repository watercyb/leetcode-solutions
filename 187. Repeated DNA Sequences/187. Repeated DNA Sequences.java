/*
 * Problem: 187. Repeated DNA Sequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/repeated-dna-sequences/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] arr = new int['U'];
        arr['A'] = 0;
        arr['C'] = 1;
        arr['G'] = 2;
        arr['T'] = 3;
        List<String> res = new ArrayList<>();
        if (s.length() < 10)
            return res;
        int h = 0;
        int base = 1;
        for (int i = 0; i < 9; i++) {
            h = h * 4 + arr[s.charAt(i)];
            base *= 4;
        }
        h = h * 4 + arr[s.charAt(9)];
        int[] counts = new int[(int) Math.pow(4, 10)];
        counts[h]++;
        for (int i = 10; i < s.length(); i++) {
            h = (h - arr[s.charAt(i - 10)] * base) * 4 + arr[s.charAt(i)];
            if (counts[h]++ == 1)
                res.add(s.substring(i - 9, i + 1));
        }
        return res;
    }
}
