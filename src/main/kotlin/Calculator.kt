

import operate.*

class Calculator {

    fun input(operator : AbstractCalculate, num1: Number, num2: Number): Number {
        return operator.calculate(num1, num2)
    }

}