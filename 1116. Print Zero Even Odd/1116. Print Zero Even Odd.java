/*
 * Problem: 1116. Print Zero Even Odd
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/print-zero-even-odd/
 * Language: java
 * Date: 2026-04-14
 */

class ZeroEvenOdd {
    private int n;
    private int num = 1;
    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            zero.acquire();
            if (num > n)
                break;
            printNumber.accept(0);
            if ((num & 1) == 1) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            even.acquire();
            if (num > n)
                break;
            printNumber.accept(num++);
            if (num <= n) {
                zero.release();
            } else {
                zero.release();
                odd.release();
                break;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            odd.acquire();
            if (num > n)
                break;
            printNumber.accept(num++);
            if (num <= n) {
                zero.release();
            } else {
                zero.release();
                even.release();
                break;
            }
        }
    }
}
