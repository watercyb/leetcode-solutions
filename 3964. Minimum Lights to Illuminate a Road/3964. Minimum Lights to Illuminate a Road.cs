/*
 * Problem: 3964. Minimum Lights to Illuminate a Road
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-lights-to-illuminate-a-road/
 * Language: csharp
 * Date: 2026-06-24
 */

public class Solution {
    public int MinLights(int[] lights) {
        int[] arr=new int[lights.Length+1];
        for (int i=0;i<lights.Length;i++) {
            if (lights[i]>0) {
                arr[Math.Max(i-lights[i],0)]++;
                arr[Math.Min(i+lights[i]+1,lights.Length)]--;
            }
        }
        int res=0;
        int sum=0;
        for (int i=0;i<arr.Length-1;i++) {
            sum+=arr[i];
            if (sum==0) {
                res++;
                sum++;
                arr[Math.Min(i+3,lights.Length)]--;
            }
        }
        return res;
    }
}
