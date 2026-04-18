/*
 * Problem: 1515. Best Position for a Service Centre
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/best-position-for-a-service-centre/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public double getMinDistSum(int[][] positions) {
        double[] xy = getXY(positions);
        double x = xy[0];
        double y = xy[1];
        double[] dXY = chkXY(positions, x, y);
        boolean dX;
        boolean dY;
        double stpX = 10;
        double stpY = 10;
        if (dXY[0] > 0) {
            x -= stpX;
            dX = true;
        } else {
            x += stpX;
            dX = false;
        }
        if (dXY[1] > 0) {
            y -= stpY;
            dY = true;
        } else {
            y += stpY;
            dY = false;
        }
        while (stpX >= 0.000001 || stpY >= 0.000001) {
            dXY = chkXY(positions, x, y);
            if (dXY[0] > 0) {
                x -= stpX;
                if (!dX) {
                    stpX /= 2;
                    dX = true;
                }
            } else {
                x += stpX;
                if (dX) {
                    stpX /= 2;
                    dX = false;
                }
            }
            if (dXY[1] > 0) {
                y -= stpY;
                if (!dY) {
                    stpY /= 2;
                    dY = true;
                }
            } else {
                y += stpY;
                if (dY) {
                    stpY /= 2;
                    dY = false;
                }
            }
        }
        double res = 0;
        for (int[] position : positions) {
            res += Math.sqrt((x - position[0]) * (x - position[0]) + (y - position[1]) * (y - position[1]));
        }
        return res;
    }

    public double[] getXY(int[][] positions) {
        double lX = 0;
        double rX = 100;
        double lY = 0;
        double rY = 100;
        while (rX - lX > 0.00001 || rY - lY > 0.00001) {
            double midX = (lX + rX) / 2;
            double midY = (lY + rY) / 2;
            double[] res = chkXY(positions, midX, midY);
            if (res[0] >= 0) {
                rX = midX;
            } else {
                lX = midX;
            }
            if (res[1] >= 0) {
                rY = midY;
            } else {
                lY = midY;
            }
        }
        return new double[] { (lX + rX) / 2, (lY + rY) / 2 };
    }

    public double[] chkXY(int[][] positions, double xl, double yl) {
        double x = xl;
        double y = yl;
        double resX = 0;
        double resY = 0;
        for (int[] position : positions) {
            double a = Math.sqrt((x - position[0]) * (x - position[0]) + (y - position[1]) * (y - position[1]));
            resX += (x - position[0])
                    / a;
            resY += (y - position[1])
                    / a;
        }
        return new double[] { resX, resY };
    }
}
