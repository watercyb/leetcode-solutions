/*
 * Problem: 3984. Divisible Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/divisible-game/
 * Language: csharp
 * Date: 2026-07-13
 */

public class Solution {
    public int DivisibleGame(int[] nums) {
        int max=0;
        foreach (int num in nums) {
            max=Math.Max(max, num);
        }
        if (max==1) {
            return (-2+1_000_000_007)%1_000_000_007;
        }
        bool[] isPrimes=new bool[max+1];
        foreach (int num in nums) {
            int n=num;
            int idx=2;
            while (idx*idx<=n) {
                if (n%idx==0) {
                    isPrimes[idx]=true;
                    while (n%idx==0) {
                        n/=idx;
                    }
                }
                idx++;
            }
            isPrimes[n]=true;
        }
        int max_val=int.MinValue;
        int k=0;
        for (int i=2;i<=max;i++) {
            if (isPrimes[i]) {
                int min=0;
                int sum=0;
                foreach (int num in nums) {
                    if (num%i==0) {
                        sum+=num;
                    } else {
                        sum-=num;
                    }
                    if (max_val<sum-min) {
                        max_val=sum-min;
                        k=i;
                    }
                    min=Math.Min(min, sum);
                }
            }
        }
        return ((int)((long)max_val*k%1_000_000_007)+1_000_000_007)%1_000_000_007;
    }
}
