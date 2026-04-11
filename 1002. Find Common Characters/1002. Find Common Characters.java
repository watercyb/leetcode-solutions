/*
 * Problem: 1002. Find Common Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-common-characters/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public List<String> commonChars(String[] words) {
        int[] counts = new int['z' + 1];
        Arrays.fill(counts, Integer.MAX_VALUE);
        for (String str : words) {
            int[] tmp = new int['z' + 1];
            for (char chr : str.toCharArray()) {
                tmp[chr]++;
            }
            for (char i = 'a'; i <= 'z'; i++) {
                counts[i] = Math.min(tmp[i], counts[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < counts[i]; j++) {
                res.add(str);
            }
        }
        return res;
    }
}
