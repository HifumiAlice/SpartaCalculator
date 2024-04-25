package org.example

class Add : AbstractCalculate(){

    override fun calculate(num1: Any, num2: Any): Any {
        if (num1 is Long && num2 is Long) {
            println("${num1} + ${num2} = ${num1 + num2}")
            return num1 + num2
        } else if (num1 is Long && num2 is Double) {
            println("${num1} + ${num2} = ${num1 + num2}")
            return num1.toDouble() + num2
        } else if (num1 is Double && num2 is Long) {
            println("${num1} + ${num2} = ${num1 + num2}")
            return num1 + num2.toDouble()
        } else if (num1 is Double && num2 is Double) {
            println("${num1} + ${num2} = ${num1 + num2}")
            return num1 + num2
        } else {
            println("잘못된 타입 받음")
            println("num1 type : ${num1.javaClass.name} / num2 type : ${num2.javaClass.name}")
            return num1
        }
    }
}