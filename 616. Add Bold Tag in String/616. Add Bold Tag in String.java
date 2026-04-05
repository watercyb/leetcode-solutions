/*
 * Problem: 616. Add Bold Tag in String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-bold-tag-in-string/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public String addBoldTag(String s, String[] words) {
        int l = s.length();
        int[] arr = new int[s.length()];
        for (String str : words) {
            int size = str.length();
            int idx = s.indexOf(str);
            while (idx >= 0) {
                arr[idx]++;
                if (idx + size < l)
                    arr[idx + size]--;
                idx = s.indexOf(str, idx + 1);
            }
        }
        String t1 = "<b>";
        String t2 = "</b>";
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            int tmp = sum + arr[i];
            if (sum == 0 && tmp != 0) {
                res.append(t1);
            } else if (sum != 0 && tmp == 0) {
                res.append(t2);
            }
            sum = tmp;
            res.append(s.charAt(i));
        }
        if (sum > 0)
            res.append("</b>");
        return res.toString();
    }
}
