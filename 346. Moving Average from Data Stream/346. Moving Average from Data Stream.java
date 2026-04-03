/*
 * Problem: 346. Moving Average from Data Stream
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/moving-average-from-data-stream/
 * Language: java
 * Date: 2026-04-03
 */

class MovingAverage {
    private final int[] queue;
    private int head;
    private int count;
    private int total;

    public MovingAverage(int size) {
        this.queue = new int[size];
        this.head = 0;
        this.count = 0;
        this.total = 0;
    }
    
    public double next(int val) {
        // If the queue is full replace the head value with the new one
        if (this.isFull()) this.total -= this.queue[this.head];

        // Update the new value into the queue
        this.queue[(this.head + this.count) % this.queue.length] = val;

        if (this.isFull()) {
            // Update the head if the queue is full
            this.head = (this.head + 1) % this.queue.length;
        } else {
            // Increment the count if the queue has space
            this.count++;
        }

        this.total += val;

        return (double) this.total / this.count;
    }

    private boolean isFull() {
        return this.count == this.queue.length;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
