package org.example
import java.util.Scanner
import kotlin.math.*

fun main() {
    val cal = Calculator()
    val scanner = Scanner(System.`in`)

    var numberLong : Long = 0
    var numberDouble : Double = 0.0
    var resultLong : Long = 0
    var resultDouble : Double = 0.0

    var operator : String = " "
    var input : String = " "

    var cnt : Int = 0
    var doubleFlag : Boolean = false
    var longFlag : Boolean = false

    println("------------------------------------")
    println("계산기 사용법")
    println("숫자 입력창에 정수 또는 실수를 입력해주세요 ")
    println("연산 입력창에는 +, -, *, /, % 연산만 입력해주세요")
    println("숫자 또는 연산 입력창에 \"q 또는 quit\"을 입력하면 계산기 작동을 멈춥니다.")
    println("숫자 또는 연산 입력창에 \"r 또는 reset\"을 입력하면 계산값이 초기화 됩니다.")
    println("------------------------------------")

    while (true) {
        print("숫자 입력창 :   ")
        input = scanner.next()

        if (input == "q" || input == "quit") {
            println("------------------------------------")
            println("계산기를 종료합니다.")
            println("------------------------------------")
            break
        } else if (input == "r" || input == "reset") {
            println("------------------------------------")
            println("계산 결과를 초기화 합니다.")
            println("------------------------------------")
            cnt = -1
            doubleFlag = false
            resultDouble = 0.0
            resultLong = 0.toLong()
        } else {

            try {
                numberLong = input.toLong()
                longFlag = true
            } catch (e: NumberFormatException) {

                try {
                    numberDouble = input.toDouble()
                    doubleFlag = true
                } catch (e: NumberFormatException) {
                    println("------------------------------------")
                    println("정수 또는 실수를 입력해주세요")
                    println("------------------------------------")
                    continue
                }
            }

            if (cnt == 0) {

                operator = returnOperator()

                if (operator == "r" || operator == "reset") {
                    cnt = 0
                    longFlag = false
                    doubleFlag = false
                    resultDouble = 0.0
                    resultLong = 0
                    continue
                } else if (operator == "q" || operator == "quit") {
                    break
                } else {
                    cal.changeMode(operator)

                    if (longFlag == true) {
                        resultLong = numberLong
                        resultDouble = resultLong.toDouble()
                        longFlag = false
                    } else {
                        resultDouble = numberDouble
                    }
                    cnt++
                    continue

                }
            }

            if (doubleFlag == true) {

                if(longFlag == true) {

                    resultDouble = cal.input(resultDouble,numberLong).toString().toDouble()

                    longFlag = false
                } else {
                    resultDouble = cal.input(resultDouble,numberDouble).toString().toDouble()
                }

                resultDouble = resultDouble * 100000
                if (resultDouble - resultDouble.toLong() >= 0.5 ) {
                    resultDouble = ceil(resultDouble) / 100000.0
                } else {
                    resultDouble = floor(resultDouble) / 100000.0
                }

                println("계산 결과 : ${resultDouble}")

            } else {
                resultLong = cal.input(resultLong,numberLong).toString().toLong()
                longFlag = false
                resultDouble = resultLong.toDouble()
                println("계산 결과 : ${resultLong}")
            }

            operator = returnOperator()

            if (operator == "r" || operator == "reset") {
                cnt = 0
                longFlag = false
                doubleFlag = false
                resultDouble = 0.0
                resultLong = 0
                continue
            } else if (operator == "q" || operator == "quit") {
                break
            } else {
                cal.changeMode(operator)
            }

        }
        cnt++

    }

}

fun returnOperator() : String{
    val scanner = Scanner(System.`in`)
    var input : String

    while (true) {
        print("연산기호 입력창 : ")
        input = scanner.next()

        if (input == "+" || input == "-" || input == "*" || input == "/" || input == "%") {
            return input
        } else if (input == "q" || input == "quit" || input == "r" || input == "reset") {
            return input
        }
        else {
            println("------------------------------------")
            println("연산기호가 잘못됐습니다.")
            println("다시 입력해주세요 : ")
            println("------------------------------------")
        }

    }
}