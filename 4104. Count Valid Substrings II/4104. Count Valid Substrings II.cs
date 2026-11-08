/*
 * Problem: 4104. Count Valid Substrings II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-valid-substrings-ii/
 * Language: csharp
 * Date: 2026-11-08
 */

public class Solution {
    public long CountValidSubstrings(string s) {
        LinkedList<int> a = new LinkedList<int>();
        LinkedList<int> b = new LinkedList<int>();
        long res=0;
        int j=0;
        for (int i=0;i<s.Length;i++) {
            char chr=s[i];
            if (chr=='a') {
                a.AddLast(i);
            } else if (chr=='b') {
                b.AddLast(i);
            } else {
                trim(a,b,j);
                while (b.Count>0) {
                    j++;
                    trim(a,b,j);
                }
            }
            res+=i-j+1;
        }
        return res;
    }

    public void trim(LinkedList<int> a, LinkedList<int> b,int j) {
        while (a.Count>0&&a.First.Value<j) {
            a.RemoveFirst();
        }
        if (a.Count>0) {
            while (b.Count>0&&b.First.Value<a.First.Value) {
                b.RemoveFirst();
            }
        } else {
            b.Clear();
        }
    }
}
