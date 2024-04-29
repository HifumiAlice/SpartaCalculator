

import operate.*
import kotlin.math.*


fun main() {

    val cal = Calculator()
    var operatorList = mutableListOf("+","-","*","/","%")
    val output = Input(operatorList)

    var operator : String = " "

    var resultNumber : Any
    var number1 : Number = 0
    var number2 : Number = 0
    var numberFlag = false

    PrintClass.firstPrint()

    while (true) {
        resultNumber = output.returnStr("number")

        if(resultNumber is Number) {
            number2 = resultNumber
        } else if (resultNumber is String) {
            if (resultNumber == "r" || resultNumber == "reset") {
                number1 = 0
                number2 = 0
                numberFlag = false
                PrintClass.resetPrint()
                continue
            } else if (resultNumber == "q" || resultNumber == "quit") {
                PrintClass.endPrint()
                break
            }

        }

        if (numberFlag == false) {
            operator = output.returnStr("operator").toString()
            number1 = number2
            numberFlag = true
            continue
        }

        when (operator) {
            "+" -> {
                number1 = cal.input(Add(),number1,number2)
            }
            "-" -> number1 = cal.input(Sub(),number1,number2)
            "*" -> number1 = cal.input(Multiplication(),number1,number2)
            "/" -> number1 = cal.input(Divide(),number1,number2)
            "%" -> number1 = cal.input(Remainder(),number1,number2)
        }

        number1 = number1.toDouble() * 100000
        if (number1 - number1.toLong() >= 0.5 ) {
            number1 = ceil(number1) / 100000.0
        } else {
            number1 = floor(number1) / 100000.0
        }

        if (number1 % 1.0 == 0.0) number1 = number1.toLong()

        PrintClass.resultNumber(number1)


        operator = output.returnStr("operator").toString()

        if (operator == "r" || operator == "reset") {
            number1 = 0
            number2 = 0
            numberFlag = false
            PrintClass.resetPrint()
            continue
        } else if (operator == "q" || operator == "quit") {
            PrintClass.endPrint()
            break
        }


    }


}

