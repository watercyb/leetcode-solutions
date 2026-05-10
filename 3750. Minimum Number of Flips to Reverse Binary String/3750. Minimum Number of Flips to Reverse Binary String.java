/*
 * Problem: 3750. Minimum Number of Flips to Reverse Binary String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-number-of-flips-to-reverse-binary-string/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minimumFlips(int n) {
        List<Integer> list=new ArrayList<>();
        while (n>0) {
            list.add(n&1);
            n/=2;
        }
        int l = 0;
        int r = list.size() - 1;
        int res = 0;
        while (l < r) {
            if (list.get(l) != list.get(r))
                res += 2;
            l++;
            r--;
        }
        return res;
    }
}
