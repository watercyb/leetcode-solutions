/*
 * Problem: 3926. Count Valid Word Occurrences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-valid-word-occurrences/
 * Language: swift
 * Date: 2026-05-12
 */

class Solution {
    func countWordOccurrences(_ chunks: [String], _ queries: [String]) -> [Int] {
        var chrs: [Character]=[]
        var map: [String: Int] = [:]
        for chunk in chunks {
            for chr in chunk {
                if chr.isLowercase {
                    chrs.append(chr)
                } else if chr=="-" {
                    if (chrs.last=="-") {
                        if chrs.count>1 {
                            chrs.removeLast();
                            let str=String(chrs)
                            map[str]=map[str, default: 0]+1
                        }
                        chrs=[]
                    } else if !chrs.isEmpty {
                        chrs.append(chr)
                    }
                } else {
                    if (chrs.last=="-") {
                       chrs.removeLast();
                    }
                    if !chrs.isEmpty {
                        let str=String(chrs)
                        map[str]=map[str, default: 0]+1
                        chrs=[]
                    }
                }
            }
        }
        if (chrs.last=="-") {
            chrs.removeLast();
        }
        if !chrs.isEmpty {
            let str=String(chrs)
            map[str]=map[str, default: 0]+1
        }
        var res: [Int]=[]
        for query in queries {
            res.append(map[query, default: 0])
        }
        return res
    }
}
