/*
 * Problem: 3606. Coupon Code Validator
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/coupon-code-validator/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        for (int i = 'a'; i <= 'z'; i++) {
            valids[i] = true;
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            valids[i] = true;
        }
        for (int i = '0'; i <= '9'; i++) {
            valids[i] = true;
        }
        valids['_'] = true;
        List<String>[] lists = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < code.length; i++) {
            int idx = chk(code[i], businessLine[i], isActive[i]);
            if (idx >= 0)
                lists[idx].add(code[i]);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Collections.sort(lists[i]);
            res.addAll(lists[i]);
        }
        return res;
    }

    Map<String, Integer> map = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3);
    boolean[] valids = new boolean[256];

    public int chk(String code, String type, boolean isActive) {
        if (code.isEmpty())
            return -1;
        for (char chr : code.toCharArray()) {
            if (!valids[chr])
                return -1;
        }
        if (!isActive)
            return -1;
        return map.getOrDefault(type, -1);
    }
}
