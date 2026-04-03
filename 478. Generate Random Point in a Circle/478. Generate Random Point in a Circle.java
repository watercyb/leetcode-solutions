/*
 * Problem: 478. Generate Random Point in a Circle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/generate-random-point-in-a-circle/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    double radius;
    double x_center;
    double y_center;
    Random random = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double randomDouble = radius * Math.sqrt(random.nextDouble());
        double angle = random.nextDouble(Math.PI * 2);
        return new double[] { Math.cos(angle) * randomDouble + x_center, Math.sin(angle) * randomDouble + y_center };
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
