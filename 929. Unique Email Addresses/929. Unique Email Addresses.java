/*
 * Problem: 929. Unique Email Addresses
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/unique-email-addresses/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> HS = new HashSet<>();
        for (String email : emails) {
            chk(email, HS);
        }
        return HS.size();
    }

    public void chk(String email, HashSet<String> HS) {
        char[] chrs = email.toCharArray();
        int idx = 0;
        StringBuilder SB = new StringBuilder();
        while (idx < chrs.length) {
            if (chrs[idx] == '+') {
                idx++;
                while (chrs[idx] != '@') {
                    idx++;
                }
                break;
            }
            if (chrs[idx] == '@') {
                break;
            }
            if (chrs[idx] != '.')
                SB.append(chrs[idx]);
            idx++;
        }
        while (idx < chrs.length) {
            SB.append(chrs[idx]);
            idx++;
        }
        HS.add(SB.toString());
    }
}
