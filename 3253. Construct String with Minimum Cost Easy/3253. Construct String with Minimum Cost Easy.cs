/*
 * Problem: 3253. Construct String with Minimum Cost (Easy)
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-string-with-minimum-cost-easy/
 * Language: csharp
 * Date: 2026-04-08
 */

public class Solution {
    public int MinimumCost(string target, string[] words, int[] costs) {
        List<int[]>[] lists = new List<int[]>[target.Length];
        for (int i=0;i<lists.Length;i++) {
            lists[i]=new List<int[]>();
        }
        for (int i=0;i<words.Length;i++) {
            if (words[i].Length>target.Length) continue;
            int[] LPS=getLPS(words[i]);
            int idx=0;
            int len=0;
            while (idx<target.Length) {
                if (words[i][len]==target[idx]) {
                    len++;
                    if (len==words[i].Length) {
                        lists[idx-len+1].Add(new int[] {idx+1,costs[i]});
                        len=LPS[len-1];
                    }
                    idx++;
                } else {
                    if (len>0) {
                        len=LPS[len-1];
                    } else {
                        idx++;
                    }
                }
            }
        }
        int[] dp=new int[target.Length+1];
        Array.Fill(dp, int.MaxValue/2);
        dp[0]=0;
        for (int i=0;i<target.Length;i++) {
            foreach (int[] pair in lists[i]) {
                dp[pair[0]]=Math.Min(dp[pair[0]], dp[i]+pair[1]);
            }
        }
        if (dp[target.Length]>=int.MaxValue/2)
            return -1;
        return dp[target.Length];
    }

    public int[] getLPS(string word) {
        int[] res=new int[word.Length];
        int idx=1;
        int len=0;
        while (idx<word.Length) {
            if (word[len]==word[idx]) {
                len++;
                res[idx]=len;
                idx++;
            } else {
                if (len>0) {
                    len=res[len-1];
                } else {
                    idx++;
                }
            }
        }
        return res;
    }
}
