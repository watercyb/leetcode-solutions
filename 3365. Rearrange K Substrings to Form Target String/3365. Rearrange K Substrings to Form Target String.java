/*
 * Problem: 3365. Rearrange K Substrings to Form Target String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if (s.equals(t))
            return true;
        HashMap<String, Integer> HM = new HashMap<>();
        int stp = s.length() / k;
        for (int i = 0; i < s.length(); i += stp) {
            String str = s.substring(i, i + stp);
            HM.put(str, HM.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < t.length(); i += stp) {
            String str = t.substring(i, i + stp);
            int count = HM.getOrDefault(str, 0);
            if (count == 0)
                return false;
            HM.put(str, count - 1);
        }
        return true;
    }
}
