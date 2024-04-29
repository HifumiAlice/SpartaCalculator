import java.util.*

class Input() {
    private var operatorList : MutableList<String> = mutableListOf()

    constructor (list : MutableList<String>) : this() {
        operatorList = list
//        println(operatorList)
    }

    fun returnStr(type : String ) : Any {
        val scanner = Scanner(System.`in`)
        var input: String

        while (true) {
            if (type == "operator") {
                print("연산기호 입력창 : ")

                input = scanner.next()

                if (input in operatorList) {
                    return input
                } else if (input == "q" || input == "quit" || input == "r" || input == "reset") {
                    return input
                } else {
                    PrintClass.wrongOperator()
                }
            } else if (type == "number") {
                print("숫자 입력창 : ")
                input = scanner.next()

                if (input == "q" || input == "quit" || input == "r" || input == "reset") {
                    return input
                }

                try {
                    return input.toLong()
                } catch (e: NumberFormatException) {

                    try {
                        return input.toDouble()

                    } catch (e: NumberFormatException) {
                        PrintClass.wrongNumber()
                    }
                }


            }
        }
    }
}