/*
 * Problem: 1603. Design Parking System
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/design-parking-system/
 * Language: java
 * Date: 2026-04-19
 */

class ParkingSystem {
    int[] parkingLots;

    public ParkingSystem(int big, int medium, int small) {
        parkingLots = new int[] { 0, big, medium, small };
    }

    public boolean addCar(int carType) {
        if (parkingLots[carType] == 0) {
            return false;
        } else {
            parkingLots[carType]--;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
