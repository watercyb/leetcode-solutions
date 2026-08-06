/*
 * Problem: 4007. Widest Possible Fence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/widest-possible-fence/
 * Language: csharp
 * Date: 2026-08-06
 */

public class Solution {
    public int MaximumWidth(int[] planks) {
        Dictionary<int, int> dic = new Dictionary<int, int>();
        for (int i=0;i<planks.Length;i++) {
            dic[planks[i]]=dic.GetValueOrDefault(planks[i],0)+1;
        }
        int[][] arr=new int[dic.Count][];
        int idx=0;
        foreach (KeyValuePair<int, int> entry in dic)
        {
            arr[idx++]=new int[] {entry.Key, entry.Value};
        }
        Array.Sort(arr, (x, y) => x[0].CompareTo(y[0]));
        dic.Clear();
        for (int i=0;i<arr.Length-1;i++) {
            if (arr[i][1]>=2)
                dic[arr[i][0]*2]=dic.GetValueOrDefault(arr[i][0]*2,0)+arr[i][1]/2;
            for (int j=i+1;j<arr.Length;j++) {
                int k=arr[i][0]+arr[j][0];
                int v=Math.Min(arr[i][1],arr[j][1]);
                dic[k]=dic.GetValueOrDefault(k,0)+v;
            }
        }
        int res=0;
        foreach (KeyValuePair<int, int> entry in dic)
        {
            res=Math.Max(res, entry.Value);
        }
        foreach (int[] pair in arr) {
            res=Math.Max(res, dic.GetValueOrDefault(pair[0])+pair[1]);
        }
        return res;
    }
}
