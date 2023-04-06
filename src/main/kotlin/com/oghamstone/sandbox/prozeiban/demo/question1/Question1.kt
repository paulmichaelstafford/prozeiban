package com.oghamstone.sandbox.prozeiban.demo.question1

import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class Question1 {

    /*
        Write a function solution that, given an integer N, returns the smallest number with the same number of digits. You can assume N is between 1 and 109 (a billion).
        For example, given N = 125, the function should return 100. Given N = 10, the function should return 10. Given N = 1, the function should return 0.
     */
    fun boom() {
        System.out.println(findSmallestNumber(190039))
        System.out.println(findSmallestNumber(6))
        System.out.println(findSmallestNumber(778855643))
    }

    fun findSmallestNumber(number: Int): Int {
        if(number < 10) {
            return 0;
        }
        val smallestNumber = "1" + "0".repeat(number.toString().length - 1)
        return smallestNumber.toInt();
    }

}