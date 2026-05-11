/*
 * Problem: 3839. Number of Prefix Connected Groups
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-prefix-connected-groups/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public int PrefixConnected(string[] words, int k) {
        Dictionary<string,int> map=new Dictionary<string,int>();
        int res=0;
        foreach (string word in words) {
            if (word.Length<k) continue;
            string key=word[0..k];
            int count = (map.TryGetValue(key, out int v) ? v : 0)+1;
            if (count==2) res++;
            map[key]=count;
        }
        return res;
    }
}
