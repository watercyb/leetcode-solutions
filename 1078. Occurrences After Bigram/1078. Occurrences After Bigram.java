/*
 * Problem: 1078. Occurrences After Bigram
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/occurrences-after-bigram/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length - 2; i++) {
            if (strs[i].equals(first) && strs[i + 1].equals(second))
                list.add(strs[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }
}
