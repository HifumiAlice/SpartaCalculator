package org.example

abstract class AbstractCalculate {
    abstract fun calculate(num1: Any, num2: Any) : Any

    fun zeroCheck(n : Number) : Boolean {

        if (n is Long || n is Double) {
            if (n == 0L || n == 0.0) {
                println("------------------------------------")
                println("0으로 나눌 수 없습니다.")
                println("다시 입력해주세요")
                println("------------------------------------")
                return true
            } else {
                return false
            }
        }
        return true
    }
}