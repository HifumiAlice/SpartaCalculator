package org.example

class Calculator {
    private var operator: String = " "
    private var result: Any = 0

    private val add = Add()
    private val sub = Sub()
    private val mul = Multiplication()
    private val div = Divide()
    private val remainder = Remainder()


    fun changeMode(operator : String) {
//        println("모드 변경하기")
        if (operator == "+" || operator == "-" || operator == "*" || operator == "/" || operator == "%") {
            this.operator = operator
            println("모드가 변경되었습니다.")
            println("현재 모드 : ${this.operator}")
        } else {
            println("-----------------------")
            println("연산기호가 잘못됐습니다.")
            println("현재 모드 : ${this.operator}")
            println("-----------------------")
        }
    }

    fun input(num1: Any, num2: Any): Any {
        if (operator == "+") {
            return add.calculate(num1, num2)
        } else if (operator == "-") {
            return sub.calculate(num1, num2)
        } else if (operator == "*") {
            return mul.calculate(num1, num2)
        } else if (operator == "/") {
            return div.calculate(num1, num2)
        } else if (operator == "%") {
            return remainder.calculate(num1, num2)
        }
        return num1
    }

}