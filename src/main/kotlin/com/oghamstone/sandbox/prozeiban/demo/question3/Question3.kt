package com.oghamstone.sandbox.prozeiban.demo.question3

import org.springframework.stereotype.Service
import org.springframework.util.Assert
import javax.annotation.PostConstruct

@Service
class Question3 {

    /*
        Charlemagne, the King of Frankia, is considering building some castles on the border with Servia.
        The border is divided into N segments. The King knows the height of the terrain in each segment of the border.
        The height of each segment of terrain is stored in array A, with A[P] denoting the height of the P-th segment of the border.
        The King has decided to build a castle on top of every hill and in the bottom of every valley.
        Let [P..Q] denote a group of consecutive segments from P to Q inclusive such that (0 SPsQs N-1). Segments [P..Q] form a hill or a valley if all the following conditions are satisfied:

            • The terrain height of each segment from P to Q is the same (A[P] =A[P+1] = AQI):
            • If P>0 then AP-1) API (for a hill) or AP-1]> A[P] (for a valley)
            • If Q<N-1 then A[Q+1]< A[Q] (for a hill) or A[Q+1]> A[Q] (for a valley);

        That is, a hill is higher than its surroundings and a valley is lower than its surroundings.
        Note that if the surroundings on either side of the hill or valley don't exist
        (i.e. at the edges of the area under consideration, where P = 0 or Q = N-1), then the condition is considered satisfied for that side of the hill/valley.
        The king is wondering how many castles is he going to build. Can you help him?

        For example, consider the following array A = [2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5).
        There are two hills: [3..3] and [11..11]. There are also two valleys: [0..1] and [8..9]. There are no other suitable places for castles.

        Write a function:
        fun solution (A: IntArray): Int

        that, given an array A consisting of N integers, as explained above, returns the total
        number of hills and valleys. For example, given array A as described above, the function should return 4.

        Given array A-1-3, -3] describing segments with a terrain height below 0, segment [0..1] forms both a hill and a valley, and only one castle can be built, so the function should return 1.
        Write an efficient algorithm for the following assumptions:
        N is an integer within the range [1..100,000); each element of array A is an integer within the range [-1,000,000,000..1,000,000,000).
     */
    @PostConstruct
    fun boom() {
//        System.out.println(solution(3, intArrayOf(1)))
//        Assert.isTrue(returnHillsAndValleys(intArrayOf(2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5)) == 1)
//        System.out.println(returnHillsAndValleys(intArrayOf(2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5)))
//        System.out.println(returnHillsAndValleys(intArrayOf(2, 2, 3, 4, 2)))
//        System.out.println(returnHillsAndValleys(intArrayOf(2, 2, -33, 4, 2)))
        System.out.println(returnHillsAndValleys(intArrayOf(2, 2, 2,3,3,3,4,4,4,5,4,4,3,3,3,2,2,1,1,1,2,2,2,3)))
    }


    enum class Direction {
        up, down
    }

    fun returnHillsAndValleys(numbersToCheck: IntArray): Int {

        var count = 0;
        var direction: Direction? = null

        for (i in 0 until numbersToCheck.size - 1) {
            val curr = numbersToCheck[i]
            val next = numbersToCheck[i + 1]
            if (curr != next) {
                if (curr < next) {
                    direction = Direction.down
                } else {
                    direction = Direction.up
                }
                break;
            }
        }
        for (i in 1 until numbersToCheck.size - 1) {
            val curr = numbersToCheck[i]
            val next = numbersToCheck[i + 1]

            if (curr != next) { //Something is happening, either we are going up or down
                if (direction == Direction.up) {
                    if (curr > next) {
                        count++
                        direction = Direction.down
                    }
                } else { //(direction == Direction.down)
                    if (curr < next) {
                        count++
                        direction = Direction.up
                    }
                }
            }
        }
        return count + 1 //Need to add 1 for the last one
    }
}
