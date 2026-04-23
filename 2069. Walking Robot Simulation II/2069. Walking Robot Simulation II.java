/*
 * Problem: 2069. Walking Robot Simulation II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/walking-robot-simulation-ii/
 * Language: java
 * Date: 2026-04-23
 */

class Robot {
    boolean ini = true;
    int idx = 0;
    int width;
    int height;
    int l1, l2, l3, l4;
    int total;
    String[] strs = { "East", "North", "West", "South" };

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        l1 = width - 1;
        l2 = width + height - 2;
        l3 = 2 * width + height - 3;
        l4 = 2 * width + 2 * height - 4;
    }

    public void step(int num) {
        ini = false;
        idx = (idx + num) % l4;
    }

    public int[] getPos() {
        if (idx <= l1)
            return new int[] { idx, 0 };
        if (idx <= l2)
            return new int[] { width - 1, idx - l1 };
        if (idx <= l3)
            return new int[] { l3 - idx, height - 1 };
        return new int[] { 0, l4 - idx };
    }

    public String getDir() {
        if (ini)
            return "East";
        if (idx == 0)
            return "South";
        if (idx <= l1)
            return "East";
        if (idx <= l2)
            return "North";
        if (idx <= l3)
            return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
