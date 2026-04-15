/*
 * Problem: 1279. Traffic Light Controlled Intersection
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/traffic-light-controlled-intersection/
 * Language: java
 * Date: 2026-04-15
 */

class TrafficLight {
    int road = 1;
    ReentrantLock lock = new ReentrantLock();

    public TrafficLight() {

    }

    public void carArrived(
            int carId, // ID of the car
            int roadId, // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction, // Direction of the car
            Runnable turnGreen, // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar // Use crossCar.run() to make car cross the intersection
    ) {
        try {
            lock.lock();
            if (road != roadId) {
                road = roadId;
                turnGreen.run();
            }
            crossCar.run();
        } finally {
            lock.unlock();
        }
    }
}
