/*
 * Problem: 1826. Faulty Sensor
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/faulty-sensor/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        for (int i = 0; i < sensor1.length; i++) {
            if (sensor1[i] != sensor2[i]) {
                boolean a = chk(sensor1, sensor2, i + 1, i);
                boolean b = chk(sensor1, sensor2, i, i + 1);
                if (a && b) {
                    return -1;
                } else if (a) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return -1;
    }

    public boolean chk(int[] sensor1, int[] sensor2, int i, int j) {
        while (i < sensor1.length && j < sensor2.length) {
            if (sensor1[i] != sensor2[j])
                return false;
            i++;
            j++;
        }
        return true;
    }
}
