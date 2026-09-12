/*
 * Problem: 4051. Count Subarrays with Distant Sums
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subarrays-with-distant-sums/
 * Language: csharp
 * Date: 2026-09-12
 */

public class Solution {
    public long DistantSubarrays(int[] nums, int goal, int k) {
        if (k==0)
            return (long)(nums.Length+1)*nums.Length/2;
        Tuple<int, long>[] arr=new Tuple<int, long>[nums.Length];
        BIT larger=new BIT(nums.Length);
        BIT smaller=new BIT(nums.Length);
        long sum=0;
        for (int i=0;i<nums.Length;i++) {
            sum+=nums[i];
            arr[i]=new Tuple<int, long>(i, sum);
            larger.insert(i, 1);
        }
        Array.Sort(arr, (a,b)=>a.Item2.CompareTo(b.Item2));
        long res=0;
        int l=0;
        int s=0;
        int left=goal-k;
        int right=goal+k;
        for (int i=0;i<arr.Length;i++) {
            int idx=arr[i].Item1;
            sum=arr[i].Item2;
            if (sum<=left||sum>=right) res++;
            long lar=sum-left;
            long sma=sum-right;
            while (l<arr.Length&&arr[l].Item2<lar) {
                larger.insert(arr[l].Item1,-1);
                l++;
            }
            while (s<arr.Length&&arr[s].Item2<=sma) {
                smaller.insert(arr[s].Item1,1);
                s++;
            }
            res+=larger.get(idx-1)+smaller.get(idx-1);
        }
        return res;
    }

    class BIT {
        int[] bit;

        public BIT(int n) {
            bit=new int[n+1];
        }

        public void insert(int i, int num) {
            i++;
            while (i<bit.Length) {
                bit[i]+=num;
                i+=i&-i;
            }
        }
        
        public int get(int i) {
            i++;
            int res=0;
            while (i>0) {
                res+=bit[i];
                i-=i&-i;
            }
            return res;
        }
    }
}
