/*
 * Problem: 3907. Count Smaller Elements With Opposite Parity
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-smaller-elements-with-opposite-parity/
 * Language: csharp
 * Date: 2026-04-22
 */

public class Solution {
    public int[] CountSmallerOppositeParity(int[] nums) {
        int[][] arr=new int[nums.Length][];
        for (int i=0;i<arr.Length;i++) {
            arr[i]=new int[] {nums[i], i};
        }
        Array.Sort(arr, (a, b) => a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        BIT even=new BIT(arr.Length+2);
        BIT odd=new BIT(arr.Length+2);
        int evenSum=0;
        int oddSum=0;
        int[] res=new int[arr.Length];
        for (int i=arr.Length-1;i>=0;i--) {
            int idx=arr[i][1];
            if ((arr[i][0]&1)==0) {
                res[idx]=oddSum-odd.get(idx-1);
                even.insert(idx);
                evenSum++;
            } else {
                res[idx]=evenSum-even.get(idx-1);
                odd.insert(idx);
                oddSum++;
            }
        }
        return res;
    }
}

public class BIT {
    int[] bit;

    public BIT(int n) {
        bit=new int[n];
    }

    public void insert(int i) {
        i++;
        while (i<bit.Length) {
            bit[i]++;
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
