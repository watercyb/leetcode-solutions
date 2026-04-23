/*
 * Problem: 2053. Kth Distinct String in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/kth-distinct-string-in-an-array/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashSet<String> seens = new HashSet<>();
        HashSet<String> repeats = new HashSet<>();
        for (String str : arr) {
            if (!seens.add(str))
                repeats.add(str);
        }
        for (String str : arr) {
            if (!repeats.contains(str)) {
                if (k-- == 1)
                    return str;
            }
        }
        return "";
    }
}
