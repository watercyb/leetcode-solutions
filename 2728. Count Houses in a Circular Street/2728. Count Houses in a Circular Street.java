/*
 * Problem: 2728. Count Houses in a Circular Street
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-houses-in-a-circular-street/
 * Language: java
 * Date: 2026-04-30
 */

/**
 * Definition for a street.
 * class Street {
 * public Street(int[] doors);
 * public void openDoor();
 * public void closeDoor();
 * public boolean isDoorOpen();
 * public void moveRight();
 * public void moveLeft();
 * }
 */
class Solution {
    public int houseCount(Street street, int k) {
        int res = 0;
        street.closeDoor();
        street.moveLeft();
        street.openDoor();
        street.moveRight();
        if (street.isDoorOpen())
            return 1;
        for (int i = 0; i < k; i++) {
            if (street.isDoorOpen()) {
                res = i;
                street.closeDoor();
            }
            street.moveRight();
        }
        return res + 1;
    }
}
