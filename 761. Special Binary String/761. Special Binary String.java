/*
 * Problem: 761. Special Binary String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/special-binary-string/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int prv = 0;
        int count = 1;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                count++;
            } else if (--count == 0) {
                list.add(new StringBuilder("1").append(makeLargestSpecial(s.substring(prv + 1, i))).append("0")
                        .toString());
                count = 1;
                i++;
                prv = i;
            }
            i++;
        }
        Collections.sort(list, (a, b) -> b.compareTo(a));
        StringBuilder SB = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            SB.append(list.get(j));
        }
        return SB.toString();
    }
}
