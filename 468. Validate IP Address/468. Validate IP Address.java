/*
 * Problem: 468. Validate IP Address
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/validate-ip-address/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String validIPAddress(String queryIP) {
        String[] strs = queryIP.split("\\.", -1);
        if (strs.length == 4)
            return chkIPv4(strs);
        strs = queryIP.split(":", -1);
        if (strs.length == 8)
            return chkIPv6(strs);
        return "Neither";
    }

    public String chkIPv4(String[] strs) {
        for (String str : strs) {
            if (str.isEmpty() || str.length() > 3 || (str.length() > 1 && str.charAt(0) == '0'))
                return "Neither";
            int num = 0;
            for (char chr : str.toCharArray()) {
                if (!Character.isDigit(chr))
                    return "Neither";
                num = num * 10 + chr - '0';
            }
            if (num > 255)
                return "Neither";
        }
        return "IPv4";
    }

    public String chkIPv6(String[] strs) {
        boolean[] valids = new boolean[256];
        for (int i = '0'; i <= '9'; i++) {
            valids[i] = true;
        }
        for (int i = 'a'; i <= 'f'; i++) {
            valids[i] = true;
        }
        for (int i = 'A'; i <= 'F'; i++) {
            valids[i] = true;
        }
        for (String str : strs) {
            if (str.isEmpty() || str.length() > 4)
                return "Neither";
            for (char chr : str.toCharArray()) {
                if (!valids[chr])
                    return "Neither";
            }
        }
        return "IPv6";
    }
}
