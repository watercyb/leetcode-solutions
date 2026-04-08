/*
 * Problem: 773. Sliding Puzzle
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sliding-puzzle/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    int[] bases = { 1, 6, 6 * 6, 6 * 6 * 6, 6 * 6 * 6 * 6, 6 * 6 * 6 * 6 * 6 };
    static int[] steps = new int[6 * 6 * 6 * 6 * 6 * 6];

    public int slidingPuzzle(int[][] board) {
        if (steps[0] == 0) {
            Arrays.fill(steps, -1);
            Queue<int[]> Qu = new LinkedList<>();
            int beginning = bases[0] + 2 * bases[1] + 3 * bases[2] + 4 * bases[3] + 5 * bases[4];
            steps[beginning] = 0;
            int stp = 1;
            Qu.offer(new int[] { beginning, 5 });
            while (!Qu.isEmpty()) {
                int size = Qu.size();
                for (int i = 0; i < size; i++) {
                    int[] current = Qu.poll();
                    int h = 0;
                    switch (current[1]) {
                        case 0:
                            h = swap(current[0], 0, 1);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 1 });
                            }
                            h = swap(current[0], 0, 3);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 3 });
                            }
                            break;
                        case 1:
                            h = swap(current[0], 1, 0);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 0 });
                            }
                            h = swap(current[0], 1, 2);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 2 });
                            }
                            h = swap(current[0], 1, 4);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 4 });
                            }
                            break;
                        case 2:
                            h = swap(current[0], 2, 1);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 1 });
                            }
                            h = swap(current[0], 2, 5);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 5 });
                            }
                            break;
                        case 3:
                            h = swap(current[0], 3, 0);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 0 });
                            }
                            h = swap(current[0], 3, 4);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 4 });
                            }
                            break;
                        case 4:
                            h = swap(current[0], 4, 3);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 3 });
                            }
                            h = swap(current[0], 4, 5);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 5 });
                            }
                            h = swap(current[0], 4, 1);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 1 });
                            }
                            break;
                        case 5:
                            h = swap(current[0], 5, 4);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 4 });
                            }
                            h = swap(current[0], 5, 2);
                            if (steps[h] == -1) {
                                steps[h] = stp;
                                Qu.offer(new int[] { h, 2 });
                            }
                            break;
                    }
                }
                stp++;
            }
        }
        int target = board[0][0] + board[0][1] * bases[1] + board[0][2] * bases[2] + board[1][0] * bases[3]
                + board[1][1] * bases[4] + board[1][2] * bases[5];
        return steps[target];
    }

    public int swap(int h, int a, int b) {
        int digit = h / bases[b] % 6;
        return h - digit * bases[b] + digit * bases[a];
    }
}
