/*
 * Problem: 2753. Count Houses in a Circular Street II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-houses-in-a-circular-street-ii/
 * Language: java
 * Date: 2026-04-30
 */

/**
 * Definition for a street.
 * class Street {
 *     public Street(int[] doors);
 *     public void closeDoor();
 *     public boolean isDoorOpen();
 *     public void moveRight();
 * }
 */
class Solution {
    public int houseCount(Street street, int k) {
        int[] prv = new int[2];
        while (true) {
            int[] re = chk(street, k);
            if (re[0] == 0)
                return prv[1] + 1;
            if (re[0] == 1) {
                street.closeDoor();
            } else {
                closeDoor(street, k, re[1]);
            }
            prv = re;
        }
    }

    public void closeDoor(Street street, int k, int avoid) {
        chkDoor(street, k);
        int len = 0;
        street.moveRight();
        for (int j = 0; j < 2 * k; j++) {
            if (!street.isDoorOpen()) {
                len++;
            } else {
                if (len < avoid)
                    street.closeDoor();
                len = 0;
                if (j > k)
                    break;
            }
            street.moveRight();
        }
    }

    public boolean chkDoor(Street street, int k) {
        for (int i = 0; i < k; i++) {
            if (street.isDoorOpen())
                return true;
            street.moveRight();
        }
        return false;
    }

    public int[] chk(Street street, int k) {
        if (!chkDoor(street, k))
            return new int[] { 0, 0 };
        int len = 0;
        int maxLen = -1;
        int count = 0;
        street.moveRight();
        for (int j = 0; j < 2 * k; j++) {
            if (!street.isDoorOpen()) {
                len++;
            } else {
                if (len > maxLen) {
                    maxLen = len;
                    count++;
                }
                len = 0;
                if (j > k)
                    break;
            }
            street.moveRight();
        }
        return new int[] { count, maxLen };
    }
}
