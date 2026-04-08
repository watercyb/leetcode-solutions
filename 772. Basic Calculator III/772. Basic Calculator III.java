/*
 * Problem: 772. Basic Calculator III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/basic-calculator-iii/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int calculate(String s) {
        dfs(s.toCharArray());
        Deque<Integer> Dq = new ArrayDeque<>();
        while (!Qu.isEmpty()) {
            String str = Qu.poll();
            if (Character.isDigit(str.charAt(0))) {
                Dq.offerLast(Integer.valueOf(str));
            } else {
                int a = Dq.pollLast();
                int b = Dq.pollLast();
                if (str.equals("+")) {
                    Dq.offerLast(b + a);
                } else if (str.equals("-")) {
                    Dq.offerLast(b - a);
                } else if (str.equals("*")) {
                    Dq.offerLast(b * a);
                } else if (str.equals("/")) {
                    Dq.offerLast(b / a);
                }
            }
        }
        return Dq.pollLast();
    }

    Queue<String> Qu = new LinkedList<>();

    int idx = 0;

    public void dfs(char[] chrs) {
        char prv = '@';
        char sign = '+';
        boolean isNum = false;
        int num = 0;
        while (idx < chrs.length) {
            char chr = chrs[idx++];
            if (chr == '(') {
                dfs(chrs);
            } else if (Character.isDigit(chr)) {
                num *= 10;
                num += chr - '0';
                isNum = true;
            }
            if (chr == '*' || chr == '/' || chr == '+' || chr == '-' || chr == ')' || idx == chrs.length) {
                if (isNum) {
                    Qu.offer(String.valueOf(num));
                    isNum = false;
                }
                switch (sign) {
                    case '*':
                        Qu.offer("*");
                        break;
                    case '/':
                        Qu.offer("/");
                        break;
                }
                if (chr == '+' || chr == '-') {
                    if (prv != '@')
                        Qu.offer(String.valueOf(prv));
                    prv = chr;
                }
                if (chr == ')')
                    break;
                num = 0;
                sign = chr;
            }
        }
        if (prv != '@')
            Qu.offer(String.valueOf(prv));
    }
}
