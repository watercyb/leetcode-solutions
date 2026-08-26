/*
 * Problem: 4024. Nearest Available Drone
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/nearest-available-drone/
 * Language: swift
 * Date: 2026-08-26
 */

class Solution {
    func nearestDrone(_ drones: [[Int]], _ target: [Int]) -> Int {
        var res = -1
        var min = 101
        for i in 0..<drones.count {
            let dist=abs(drones[i][0]-target[0])+abs(drones[i][1]-target[1])
            if (dist<=drones[i][2]&&dist<min) {
                min=dist
                res=i
            }
        }
        return res
    }
}
