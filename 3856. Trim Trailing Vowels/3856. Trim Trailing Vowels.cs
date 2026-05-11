/*
 * Problem: 3856. Trim Trailing Vowels
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/trim-trailing-vowels/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public string TrimTrailingVowels(string s) {
        int idx=s.Length-1;
        while (idx>=0&&(s[idx]=='a'||s[idx]=='e'||s[idx]=='i'||s[idx]=='o'||s[idx]=='u')) {
            idx--;
        }
        return s.Substring(0,idx+1);
    }
}
