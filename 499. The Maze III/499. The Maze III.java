/*
 * Problem: 499. The Maze III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-maze-iii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        PQ.offer(new Node(0, ball[0], ball[1]));
        maze[ball[0]][ball[1]] = 2;
        String res = "z";
        int distance = Integer.MAX_VALUE;
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();
            if (node.distance > distance)
                break;
            if (node.i == hole[0] && node.j == hole[1]) {
                StringBuilder SB = new StringBuilder();
                for (char chr : node.li) {
                    SB.append(chr);
                }
                String str = SB.toString();
                if (res.compareTo(str) > 0) {
                    res = str;
                    distance = node.distance;
                }
            }

            int x = node.i - 1;
            int y = node.j;
            while (x >= 0 && maze[x][y] != 1) {
                x--;
            }
            x++;
            if (x != node.i) {
                if (hole[0] >= x && hole[0] < node.i && y == hole[1]) {
                    Node tmp = new Node(node.distance + node.i - hole[0], hole[0], y, node.li);
                    tmp.li.add('u');
                    PQ.offer(tmp);
                } else if (maze[x][y] == 0 || maze[x][y] >= node.distance + node.i - x + 2) {
                    Node tmp = new Node(node.distance + node.i - x, x, y, node.li);
                    tmp.li.add('u');
                    PQ.offer(tmp);
                    maze[x][y] = node.distance + node.i - x + 2;
                }
            }

            x = node.i + 1;
            y = node.j;
            while (x < maze.length && maze[x][y] != 1) {
                x++;
            }
            x--;
            if (x != node.i) {
                if (hole[0] <= x && hole[0] > node.i && y == hole[1]) {
                    Node tmp = new Node(node.distance + hole[0] - node.i, hole[0], y, node.li);
                    tmp.li.add('d');
                    PQ.offer(tmp);
                } else if (maze[x][y] == 0 || maze[x][y] >= node.distance + x - node.i + 2) {
                    Node tmp = new Node(node.distance + x - node.i, x, y, node.li);
                    tmp.li.add('d');
                    PQ.offer(tmp);
                    maze[x][y] = node.distance + x - node.i + 2;
                }
            }

            x = node.i;
            y = node.j - 1;
            while (y >= 0 && maze[x][y] != 1) {
                y--;
            }
            y++;
            if (y != node.j) {
                if (x == hole[0] && hole[1] >= y && hole[1] < node.j) {
                    Node tmp = new Node(node.distance + node.j - hole[1], x, hole[1], node.li);
                    tmp.li.add('l');
                    PQ.offer(tmp);
                } else if (maze[x][y] == 0 || maze[x][y] >= node.distance + node.j - y + 2) {
                    Node tmp = new Node(node.distance + node.j - y, x, y, node.li);
                    tmp.li.add('l');
                    PQ.offer(tmp);
                    maze[x][y] = node.distance + node.j - y + 2;
                }
            }

            x = node.i;
            y = node.j + 1;
            while (y < maze[0].length && maze[x][y] != 1) {
                y++;
            }
            y--;
            if (y != node.j) {
                if (x == hole[0] && hole[1] <= y && hole[1] > node.j) {
                    Node tmp = new Node(node.distance + hole[1] - node.j, x, hole[1], node.li);
                    tmp.li.add('r');
                    PQ.offer(tmp);
                } else if (maze[x][y] == 0 || maze[x][y] >= node.distance + y - node.j + 2) {
                    Node tmp = new Node(node.distance + y - node.j, x, y, node.li);
                    tmp.li.add('r');
                    PQ.offer(tmp);
                    maze[x][y] = node.distance + y - node.j + 2;
                }
            }
        }
        if (res.equals("z"))
            return "impossible";
        return res;
    }
}

class Node {
    int distance = 0;
    int i = 0;
    int j = 0;
    List<Character> li;

    public Node(int distance, int i, int j) {
        this.distance = distance;
        this.i = i;
        this.j = j;
        li = new ArrayList<>();
    }

    public Node(int distance, int i, int j, List<Character> li) {
        this.distance = distance;
        this.i = i;
        this.j = j;
        this.li = new ArrayList<>(li);
    }
}
