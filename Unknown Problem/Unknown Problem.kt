/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-modulo-alternating-ii/
 * Language: kotlin
 * Date: 2026-05-27
 */

class Solution {
    fun minOperations(nums: IntArray, k: Int): Long {
        if (nums.size==1) return 0
        for (i in 0 until nums.size) {
            nums[i]=nums[i]%k
        }
        val min1=getMin(nums, k, 0)
        val min2=getMin(nums, k, 1)
        if (min1[1]!=min2[1]) return min1[0]+min2[0]
        return minOf(min1[0]+min2[2], min1[2]+min2[0])
    }

    fun getMin(nums: IntArray, k:Int, idx:Int): LongArray {
        val n=(nums.size-idx+1)/2
        val arr=IntArray(2*n)
        var idx=idx
        var l=0
        var r=n
        while (idx<nums.size) {
            arr[l]=nums[idx]
            arr[r]=nums[idx]+k
            idx+=2
            l++
            r++
        }
        arr.sort()
        l=0
        r=0
        var sumL: Long=0
        var sumR: Long=0
        while (r<n) {
            sumR+=arr[r++]
        }
        var sum:Long=sumR-arr[0].toLong()*n
        var min1: Long=sum
        var num1=arr[0]%k
        var min2=sum+n
        idx=0
        while (r<arr.size) {
            var min: Long=arr[idx].toLong()*(idx-l)-sumL+sumR-arr[idx].toLong()*(r-idx)
            if (min<min1) {
                if (arr[idx]%k!=num1)
                    min2=min1
                min1=min
                num1=arr[idx]%k
            } else if (min<min2&&num1!=arr[idx]%k) {
                min2=min
            }
            if (idx>0&&arr[idx]%k-arr[idx-1]%k>1) {
                val minL=min-(idx-l)+(r-idx)
                if (minL<min2) min2=minL
            }
            if (idx<arr.size-1&&arr[idx+1]%k-arr[idx]%k>1) {
                val minR=min+(idx-l)-(r-idx)+2
                if (minR<min2) min2=minR
            }
            while (idx<r) {
                var minNext: Long=arr[idx+1].toLong()*(idx+1-l)-(sumL+arr[idx])+(sumR-arr[idx])-arr[idx+1].toLong()*(r-idx-1)
                if (minNext<=min) {
                    sumL+=arr[idx]
                    sumR-=arr[idx]
                    idx++
                    if (minNext<min1) {
                        if (arr[idx]%k!=num1)
                            min2=min1
                        min1=minNext
                        num1=arr[idx]%k
                    } else if (minNext<min2&&num1!=arr[idx]%k) {
                        min2=minNext
                    }
                    if (arr[idx]%k-arr[idx-1]%k>1) {
                        val minL=minNext-(idx-l)+(r-idx)
                        if (minL<min2) min2=minL
                    }
                    if (idx<arr.size-1&&arr[idx+1]%k-arr[idx]%k>1) {
                        val minR=minNext+(idx-l)-(r-idx)+2
                        if (minR<min2) min2=minR
                    }
                    min=minNext;
                } else {
                    break;
                }
            }
            sumL-=arr[l]
            sumR+=arr[r]
            if (idx==l) {
                sumL+=arr[idx]
                sumR-=arr[idx]
                idx++
            }
            l++
            r++                
        }
        return longArrayOf(min1, num1.toLong(), min2)
    }
}
