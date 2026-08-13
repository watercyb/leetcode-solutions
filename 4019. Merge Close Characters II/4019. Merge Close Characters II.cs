/*
 * Problem: 4019. Merge Close Characters II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-close-characters-ii/
 * Language: csharp
 * Date: 2026-08-13
 */

public class Solution {
    public string MergeCharacters(string s, int k) { 
        char[] chrs = s.ToCharArray();
        int i=0;
        int j=0;
        int[] counts=new int[26];
        while (j<chrs.Length) {
            if (chrs[j]!='#') {
                if (counts[chrs[j]-'a']>0) {
                    chrs[j]='#';
                } else {
                    counts[chrs[j]-'a']++;
                    k--;
                    if (k<0) {
                        while (chrs[i]=='#') {
                            i++;
                        }
                        counts[chrs[i]-'a']--;
                        i++;
                        k++;
                    }
                }
            }
            j++;
        }
        StringBuilder sb = new StringBuilder();
        foreach (char chr in chrs) {
            if (chr!='#')
                sb.Append(chr);
        }
        return sb.ToString();
    }
}
