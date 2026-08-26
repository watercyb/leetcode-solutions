/*
 * Problem: 3959. Check Good Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-good-integer/
 * Language: csharp
 * Date: 2026-08-26
 */

public class Solution {
    public bool CheckGoodInteger(int n) {
        int sq=0;
        int di=0;
        while (n>0) {
            int digit=n%10;
            sq+=digit*digit;
            di+=digit;
            n/=10;
        }
        return sq-di>=50;
    }
}
