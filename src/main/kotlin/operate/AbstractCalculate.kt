package operate

abstract class AbstractCalculate {
    abstract fun calculate(num1: Number, num2: Number) : Number

    fun zeroCheck(n : Number) : Boolean {

        if (n is Long || n is Double) {
            if (n == 0L || n == 0.0) {
                return true
            } else {
                return false
            }
        }
        return true
    }
}