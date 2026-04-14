/*
 * Problem: 1178. Number of Valid Words for Each Puzzle
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Integer, Integer> HM = new HashMap<>(words.length, 0.99f);
        for (String word : words) {
            int h = getH(word);
            HM.put(h, HM.getOrDefault(h, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            int h = getH(puzzle);
            int target = 1 << (puzzle.charAt(0) - 1);
            int sum = 0;
            for (int i = h; i > 0; i = (i - 1) & h) {
                if ((i & target) == 0)
                    continue;
                sum += HM.getOrDefault(i, 0);
            }
            res.add(sum);
        }
        return res;
    }

    public int getH(String str) {
        int res = 0;
        for (char chr : str.toCharArray()) {
            res |= 1 << (chr - 'a');
        }
        return res;
    }
}
