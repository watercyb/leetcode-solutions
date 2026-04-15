/*
 * Problem: 1239. Maximum Length of a Concatenated String with Unique Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for (String str : arr) {
            int h = getH(str);
            if (h != 0) {
                list.add(h);
            }
        }
        return dfs(list, 0, 0);
    }

    public int dfs(List<Integer> list, int i, int h) {
        if (i == list.size()) {
            return Integer.bitCount(h);
        } else {
            int res = dfs(list, i + 1, h);
            if ((list.get(i) & h) == 0)
                res = Math.max(res, dfs(list, i + 1, h | list.get(i)));
            return res;
        }
    }

    public int getH(String str) {
        int res = 0;
        for (char chr : str.toCharArray()) {
            int bit = 1 << (chr - 'a');
            if ((res & bit) != 0)
                return 0;
            res += bit;
        }
        return res;
    }
}
