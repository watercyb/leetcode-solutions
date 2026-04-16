/*
 * Problem: 1326. Minimum Number of Taps to Open to Water a Garden
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr=new int[n+1];
        for (int i=0;i<=n;i++) {
            if (ranges[i]==0) continue;
            int l=i-ranges[i];
            int r=i+ranges[i];
            if (l<0) l=0;
            if (r>n) {
                arr[l]=n;
            } else {
                arr[l]=Math.max(arr[l],r);
            }
        }

        int[] res=new int[n+1];
        res[0]=arr[0];
        int index=0;
        for (int i=1;i<n;i++) {
            if (res[index]>=arr[i]) continue;
            int j=0;
            while (j<=index&&res[j]<i) j++;
            if (j>index) return -1;
            index=++j;
            res[index]=arr[i];
            if (arr[i]==n) return index+1;
        }
        if (res[index]<n) return -1;
        
        return index+1;
    }
}
