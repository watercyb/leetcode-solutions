/*
 * Problem: 1845. Seat Reservation Manager
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/seat-reservation-manager/
 * Language: java
 * Date: 2026-04-21
 */

class SeatManager {
    PriorityQueue<Integer> PQ = new PriorityQueue<>();
    int unreserved = 1;

    public SeatManager(int n) {
        PQ = new PriorityQueue<>();
        unreserved = 1;
    }

    public int reserve() {
        if (PQ.isEmpty() || PQ.peek() > unreserved) {
            return (unreserved++);
        } else {
            return PQ.poll();
        }
    }

    public void unreserve(int seatNumber) {
        PQ.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
