/*
 * Problem: 67. Add Binary
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/add-binary/
 * Language: csharp
 * Date: 2026-03-25
 */

public class Solution {
    public string AddBinary(string a, string b) {
        int i=a.Length-1;
        int j=b.Length-1;
        char[] arr=new char[Math.Max(a.Length, b.Length)+1];
        int idx=arr.Length-1;
        int carry=0;
        while (i>=0||j>=0||carry>0) {
            int sum=(i>=0?a[i]:'0')+(j>=0?b[j]:'0')-2*'0'+carry;
            carry=sum/2;
            arr[idx--]=(char)((sum&1)+'0');
            i--;
            j--;
        }
        if (arr[0]==0) return new string(arr,1,arr.Length-1);
        return new string(arr);
    }
}
