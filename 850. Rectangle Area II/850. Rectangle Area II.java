/*
 * Problem: 850. Rectangle Area II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/rectangle-area-ii/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int rectangleArea(int[][] rectangles) {
        Node root=new Node(rectangles[0][0],rectangles[0][1],rectangles[0][2],rectangles[0][3]);
        for (int[] ar:rectangles) {
            root.add(ar[0],ar[1],ar[2],ar[3]);
        }
        return root.area();

    }
}

class Node {
    int x1, y1, x2, y2;
    Node t, b, l, r;

    public Node(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void add(int x1, int y1, int x2, int y2) {
        int rx1, ry1, rx2, ry2;
        if (this.x1 <= x1 && this.x2 >= x2
                && this.y1 <= y1 && this.y2 >= y2)
            return;
        if (this.y1 > y1) {
            if (this.y1<y2) {
                ry1 = this.y1;
            } else {
                ry1 = y2;
            }           
            if (b == null) {
                b = new Node(x1, y1, x2, ry1);
            } else {
                b.add(x1, y1, x2, ry1);
            }
        } else {
            ry1 = y1;
        }
        if (this.y2 < y2) {
            if (this.y2>y1) {
                ry2 = this.y2;
            } else {
                ry2 = y1;
            }            
            if (t == null) {
                t = new Node(x1, ry2, x2, y2);
            } else {
                t.add(x1, ry2, x2, y2);
            }
        } else {
            ry2 = y2;
        }
        if (this.x1 > x1) {
            if (this.x1<x2) {
                rx1 = this.x1;
            } else {
                rx1 = x2;
            }          
            if (l == null) {
                l = new Node(x1, ry1, rx1, ry2);
            } else {
                l.add(x1, ry1, rx1, ry2);
            }
        } else {
            rx1 = x1;
        }
        if (this.x2 < x2) {
            if (this.x2>x1) {
                rx2 = this.x2;
            } else {
                rx2 = x1;
            }          
            if (r == null) {
                r = new Node(rx2, ry1, x2, ry2);
            } else {
                r.add(rx2, ry1, x2, ry2);
            }
        } else {
            rx2 = x2;
        }
    }

    public int area() {
        long res=(long)(x2 - x1) * (y2 - y1);
        if (t!=null) res+=t.area();
        if (b!=null) res+=b.area();
        if (l!=null) res+=l.area();
        if (r!=null) res+=r.area();
        return (int)(res%1000000007);
    }
}
