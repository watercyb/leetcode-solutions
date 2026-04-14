/*
 * Problem: 1115. Print FooBar Alternately
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/print-foobar-alternately/
 * Language: java
 * Date: 2026-04-14
 */

class FooBar {
    private int n;
    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            a.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            b.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            b.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            a.release();
        }
    }
}
