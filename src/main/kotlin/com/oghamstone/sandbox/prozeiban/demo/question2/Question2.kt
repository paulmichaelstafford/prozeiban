package com.oghamstone.sandbox.prozeiban.demo.question2

import org.springframework.stereotype.Service
import org.springframework.util.Assert
import javax.annotation.PostConstruct

@Service
class Question2 {

    /*
        You are given an implementation of a function:
        class Solution { public int solution (int M, int[] A); }
        that, given an integer M and an array A consisting of N non-negative integers, wh not greater than M, returns the value (or one of the values) that occurs most ofte this array.

        For example, given M 3 and array A such that:
        A[0] = 1 A[1]= 2
        A[2] = 3 A[3] = 3 A[4] = 1
        A[5] = 3
        A[6] = 1

        the function may return 1 or 3.

        The attached code is still incorrect for some inputs. Despite the error(s), the code
        produce a correct answer for the example test cases. The goal of the exercise is to
        and fix the bug(s) in the implementation. You can modify at most four lines.

        Assume that:
        N is an integer within the range [1..200,000);
        M is an integer within the range [1..10,000];
        each element of array A is an integer within the range [0..M].
        In your solution, focus on correctness. The performance of your solution will not be

        focus of the assessment.
     */

    fun boom() {
        Assert.isTrue(solution(3, intArrayOf(1)) == 1)
        Assert.isTrue(solution(3, intArrayOf(1,1,2,3,3,3)) == 3)
        Assert.isTrue(solution(3, intArrayOf(3,3,3,3,2)) == 3)
    }

    fun solution(maxInteger: Int, numbersToCheck: IntArray): Int {
        val arraySize = numbersToCheck.size
        val countArray = IntArray(maxInteger + 1)
        for (i in 0..maxInteger) countArray[i] = 0

        var maxOccurence = -1
        var index = -1
        for (i in 0 until arraySize) {
            if (countArray[numbersToCheck[i]] > -1) {
                val numberInArray = countArray[numbersToCheck[i]]
                if (numberInArray > maxOccurence) {
                    maxOccurence = numberInArray
                    index = i
                }
                countArray[numbersToCheck[i]] = numberInArray + 1
            } else {
                countArray[numbersToCheck[i]] = 1
            }
        }
        return numbersToCheck[index]
    }

}