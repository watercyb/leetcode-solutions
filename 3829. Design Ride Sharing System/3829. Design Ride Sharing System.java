/*
 * Problem: 3829. Design Ride Sharing System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-ride-sharing-system/
 * Language: java
 * Date: 2026-05-11
 */

class RideSharingSystem {
    Deque<int[]> riders = new ArrayDeque<>();
    Deque<Integer> drivers = new ArrayDeque<>();
    int[] cancels = new int[1001];
    int idx = 0;

    public RideSharingSystem() {

    }

    public void addRider(int riderId) {
        riders.addLast(new int[] { riderId, idx++ });
    }

    public void addDriver(int driverId) {
        drivers.addLast(driverId);
    }

    public int[] matchDriverWithRider() {
        while (!riders.isEmpty() && cancels[riders.peekFirst()[0]] > riders.peekFirst()[1]) {
            riders.pollFirst();
        }
        if (!riders.isEmpty() && !drivers.isEmpty()) {
            return new int[] { drivers.pollFirst(), riders.pollFirst()[0] };
        } else {
            return new int[] { -1, -1 };
        }
    }

    public void cancelRider(int riderId) {
        cancels[riderId] = idx++;
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
