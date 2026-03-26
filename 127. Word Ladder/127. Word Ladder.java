/*
 * Problem: 127. Word Ladder
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/word-ladder/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 2;
        HashSet<String> HS = new HashSet<>();
        Queue<String> Qu = new LinkedList<>();
        Qu.add(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            HS.add(wordList.get(i));
        }
        if (!HS.contains(endWord))
            return 0;
        int stp = 2;
        while (!Qu.isEmpty()) {
            Queue<String> QuNext = new LinkedList<>();
            for (String thisStp : Qu) {
                for (int i=0;i<thisStp.length();i++) {
                    char[] chrs=thisStp.toCharArray();
                    for (char j='a';j<='z';j++) {
                        chrs[i]=j;
                        String newStr=new String(chrs);
                        if (newStr.equals(endWord)) return stp;
                        if (HS.contains(newStr)) {
                            QuNext.add(newStr);
                            HS.remove(newStr);
                        }
                    }
                }
            }
            Qu = QuNext;
            stp++;
        }
        return 0;
    }
}
