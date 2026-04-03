/*
 * Problem: 422. Valid Word Square
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-word-square/
 * Language: csharp
 * Date: 2026-04-03
 */

public class Solution {
    public bool ValidWordSquare(IList<string> words) {
        for (int i=0;i<words.Count;i++) {
            for (int j=0;j<words[i].Length;j++) {
               if (j>=words.Count||i>=words[j].Length)  {
                    return false;
                } else if (words[i][j]!=words[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
