/*
 * Problem: 353. Design Snake Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-snake-game/
 * Language: java
 * Date: 2026-04-03
 */

class SnakeGame {
    List<Integer> snake = new ArrayList<>();
    int[] head = { 0, 0 };
    int width;
    int height;
    int[][] food;
    int idx = 0;
    int nextFood;

    public SnakeGame(int width, int height, int[][] food) {
        snake.add(0);
        this.width = width;
        this.height = height;
        this.food = food;
        if (idx < food.length)
            nextFood = food[idx][0] * width + food[idx][1];
    }

    public int move(String direction) {
        switch (direction) {
            case "U":
                if (--head[0] < 0)
                    return -1;
                break;
            case "D":
                if (++head[0] == height)
                    return -1;
                break;
            case "L":
                if (--head[1] < 0)
                    return -1;
                break;
            case "R":
                if (++head[1] == width)
                    return -1;
                break;
        }
        int h = head[0] * width + head[1];
        if (h == nextFood) {
            idx++;
            if (idx < food.length) {
                nextFood = food[idx][0] * width + food[idx][1];
            } else {
                nextFood = -1;
            }
        } else {
            snake.removeLast();
        }
        for (int hTmp : snake) {
            if (hTmp == h)
                return -1;
        }
        snake.addFirst(h);
        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
