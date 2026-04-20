/*
 * Problem: 3905. Multi Source Flood Fill
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/multi-source-flood-fill/
 * Language: csharp
 * Date: 2026-04-20
 */

public class Solution {
    public int[][] ColorGrid(int n, int m, int[][] sources) {
        var res= new int[n][];
        var stps= new int[n][];
        for (int i=0;i<n;i++) {
            res[i]=new int[m];
            stps[i]=new int[m];
            Array.Fill(stps[i], n*m);
        }
        var qu=new Queue<int[]>();
        foreach (int[] source in sources) {
            qu.Enqueue(source);
            res[source[0]][source[1]]=source[2];
            stps[source[0]][source[1]]=0;
        }
        while (qu.Count!=0) {
            var current=qu.Dequeue();
            var color=current[2];
            var x=current[0];
            var y=current[1];
            var stp=stps[x][y]+1;
            if (res[x][y]!=color) continue;
            if (x>0&&(stps[x-1][y]>stp||(stps[x-1][y]==stp&&res[x-1][y]<color))) {
                res[x-1][y]=color;
                stps[x-1][y]=stp;
                qu.Enqueue(new int[] {x-1,y,color});
            }
            if (x<n-1&&(stps[x+1][y]>stp||(stps[x+1][y]==stp&&res[x+1][y]<color))) {
                res[x+1][y]=color;
                stps[x+1][y]=stp;
                qu.Enqueue(new int[] {x+1,y,color});
            }
            if (y>0&&(stps[x][y-1]>stp||(stps[x][y-1]==stp&&res[x][y-1]<color))) {
                res[x][y-1]=color;
                stps[x][y-1]=stp;
                qu.Enqueue(new int[] {x,y-1,color});
            }
            if (y<m-1&&(stps[x][y+1]>stp||(stps[x][y+1]==stp&&res[x][y+1]<color))) {
                res[x][y+1]=color;
                stps[x][y+1]=stp;
                qu.Enqueue(new int[] {x,y+1,color});
            }
        }
        return res;
    }
}
