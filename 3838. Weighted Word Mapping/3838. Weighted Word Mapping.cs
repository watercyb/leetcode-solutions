/*
 * Problem: 3838. Weighted Word Mapping
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/weighted-word-mapping/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public string MapWordWeights(string[] words, int[] weights) {
        char[] chrs=new char[words.Length];
        for (int i=0;i<words.Length;i++) {
            int sum=0;
            foreach (char chr in words[i]) {
                sum+=weights[chr-'a'];
            }
            chrs[i]=(char)('z'-sum%26);
        }
        return new string(chrs);
    }
}
