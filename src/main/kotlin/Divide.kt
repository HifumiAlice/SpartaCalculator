package org.example

class Divide : AbstractCalculate() {
    override fun calculate(num1: Any, num2: Any): Any {
        if (num1 is Long && num2 is Long) {

            if (zeroCheck(num2)) {
                return num1
            } else {
                println("${num1} / ${num2} = ${num1 / num2}")
                return num1 / num2
            }

        } else if (num1 is Long && num2 is Double) {

            if (zeroCheck(num2)) {
                return num1
            } else {
                println("${num1} / ${num2} = ${num1 / num2}")
                return num1.toDouble() / num2
            }

        } else if (num1 is Double && num2 is Long) {

            if (zeroCheck(num2)) {
                return num1
            } else {
                println("${num1} / ${num2} = ${num1 / num2}")
                return num1 / num2.toDouble()
            }

        } else if (num1 is Double && num2 is Double) {

            if (zeroCheck(num2)) {
                return num1
            } else {
                println("${num1} / ${num2} = ${num1 / num2}")
                return num1 / num2
            }

        } else {
            println("잘못된 타입 받음")
            println("num1 type : ${num1.javaClass.name} / num2 type : ${num2.javaClass.name}")
            return num1
        }
    }

    private fun zeroCheck(n : Long) : Boolean {
        if (n == 0.toLong()) {
            println("------------------------------------")
            println("0으로 나눌 수 없습니다.")
            println("다시 입력해주세요")
            println("------------------------------------")
            return true
        } else {
            return false
        }
    }

    private fun zeroCheck(n : Double) : Boolean {
        if (n == 0.0) {
            println("------------------------------------")
            println("0으로 나눌 수 없습니다.")
            println("다시 입력해주세요")
            println("------------------------------------")
            return true
        } else {
            return false
        }
    }
}
