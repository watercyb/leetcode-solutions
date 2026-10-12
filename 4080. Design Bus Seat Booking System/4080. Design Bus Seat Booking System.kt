/*
 * Problem: 4080. Design Bus Seat Booking System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-bus-seat-booking-system/
 * Language: kotlin
 * Date: 2026-10-12
 */

class BusBooking(n: Int) {
    val seats: Array<IntArray>
    var tt=0
    var mt=0

    init {
        seats=Array(n+1) {IntArray(4)}
    }
    
    fun toggle(seat: String) {
        val j=seat[0]-'A'
        val i=seat.substring(1).toIntOrNull() ?: 0
        if (j==0) {
            if (seats[i][j]==0) {
                if (seats[i][j+1]!=0) {
                    seats[i][j]=3;
                    tt+=3
                } else {
                    seats[i][j]=1
                    tt+=1
                }
                mt++
            } else {
                tt-=seats[i][j]
                seats[i][j]=0
                mt--
            }
        } else if (j==3) {
            if (seats[i][j]==0) {
                if (seats[i][j-1]!=0) {
                    seats[i][j]=3;
                    tt+=3
                } else {
                    seats[i][j]=1
                    tt+=1
                }
                mt++
            } else {
                tt-=seats[i][j]
                seats[i][j]=0
                mt--
            }
        } else {
            if (seats[i][j]==0) {
                seats[i][j]=1
                tt+=1
                mt++
            } else {
                tt-=seats[i][j]
                seats[i][j]=0
                mt--
            }
        }
    }

    fun getTotalTime(): Int {
        return tt
    }

    fun getMinTime(): Int {
        return mt
    }

}

/**
 * Your BusBooking object will be instantiated and called as such:
 * var obj = BusBooking(n)
 * obj.toggle(seat)
 * var param_2 = obj.getTotalTime()
 * var param_3 = obj.getMinTime()
 */
