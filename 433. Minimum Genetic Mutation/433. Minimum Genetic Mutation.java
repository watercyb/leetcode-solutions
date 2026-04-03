/*
 * Problem: 433. Minimum Genetic Mutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-genetic-mutation/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return 1;
        HashSet<String> HS = new HashSet<>();
        Queue<String> Qu = new LinkedList<>();
        Qu.add(startGene);
        for (int i = 0; i < bank.length; i++) {
            HS.add(bank[i]);
        }
        if (!HS.contains(endGene))
            return -1;
        int stp = 1;
        char[] chr={'A','C','G','T'};
        while (!Qu.isEmpty()) {
            Queue<String> QuNext = new LinkedList<>();
            for (String thisStp : Qu) {
                for (int i=0;i<thisStp.length();i++) {
                    char[] chrs=thisStp.toCharArray();
                    for (int j=0;j<=3;j++) {
                        chrs[i]=chr[j];
                        String newStr=new String(chrs);
                        if (newStr.equals(endGene)) return stp;
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
        return -1;
    }
}
