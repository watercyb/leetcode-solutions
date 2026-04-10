#
# Problem: 966. Vowel Spellchecker
# Difficulty: Medium
# Link: https://leetcode.com/problems/vowel-spellchecker/
# Language: python3
# Date: 2026-04-10


class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        words = {}
        words_cas = {}
        words_vow = {}
        for i in range(len(wordlist)):
            str = wordlist[i]
            if str not in words:
                words[str] = i
            str = str.lower()
            if str not in words_cas:
                words_cas[str] = i
            str = self.vow(str)
            if str not in words_vow:
                words_vow[str] = i
        res = []
        for i in range(len(queries)):
            str = queries[i]
            if str in words:
                res.append(wordlist[words[str]])
            else:
                str = str.lower()
                if str in words_cas:
                    res.append(wordlist[words_cas[str]])
                else:
                    str = self.vow(str)
                    if str in words_vow:
                        res.append(wordlist[words_vow[str]])
                    else:
                        res.append("")

        return res

    def vow(self, str):
        return (
            str.replace("a", "*")
            .replace("e", "*")
            .replace("i", "*")
            .replace("o", "*")
            .replace("u", "*")
        )

