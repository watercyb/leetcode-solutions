/*
 * Problem: 3081. Replace Question Marks in String to Minimize Its Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public String minimizeStringValue(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '?')
                continue;
            counts[chrs[i] - 'a']++;
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < 26; i++) {
            PQ.offer(new int[] { counts[i], i });
        }
        Arrays.fill(counts, 0);
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] != '?')
                continue;
            int[] pair = PQ.poll();
            counts[pair[1]]++;
            pair[0]++;
            PQ.offer(pair);
        }
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] != '?')
                continue;
            while (counts[idx] == 0) {
                idx++;
            }
            chrs[i] = (char) (idx + 'a');
            counts[idx]--;
        }
        return new String(chrs);
    }
}
