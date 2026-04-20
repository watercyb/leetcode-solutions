/*
 * Problem: 3905. Multi Source Flood Fill
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/multi-source-flood-fill/
 * Language: csharp
 * Date: 2026-04-20
 */

public class Solution {
    public int[][] ColorGrid(int n, int m, int[][] sources) {
        var pq = new PriorityQueue<int[], int[]>(Comparer<int[]>.Create((x, y) => x[0]==y[0]?y[1]-x[1]:x[0]-y[0]));
        var res= new int[n][];
        for (int i=0;i<n;i++) {
            res[i]=new int[m];
        }
        foreach (int[] source in sources) {
            var arr=new int[] {0,source[2],source[0],source[1]};
            pq.Enqueue(arr, arr);
            res[source[0]][source[1]]=source[2];
        }
        while (pq.Count!=0) {
            var current=pq.Dequeue();
            var stp=current[0]+1;
            var color=current[1];
            var x=current[2];
            var y=current[3];
            if (x>0&&res[x-1][y]==0) {
                res[x-1][y]=color;
                var arr=new int[] {stp,color,x-1,y};
                pq.Enqueue(arr, arr);
            }
            if (x<n-1&&res[x+1][y]==0) {
                res[x+1][y]=color;
                var arr=new int[] {stp,color,x+1,y};
                pq.Enqueue(arr, arr);
            }
            if (y>0&&res[x][y-1]==0) {
                res[x][y-1]=color;
                var arr=new int[] {stp,color,x,y-1};
                pq.Enqueue(arr, arr);
            }
            if (y<m-1&&res[x][y+1]==0) {
                res[x][y+1]=color;
                var arr=new int[] {stp,color,x,y+1};
                pq.Enqueue(arr, arr);
            }
        }
        return res;
    }
}
