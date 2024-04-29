class PrintClass {
    companion object {
        fun firstPrint() {
            println("------------------------------------")
            println("계산기 사용법")
            println("숫자 입력창에 정수 또는 실수를 입력해주세요 ")
            println("연산 입력창에는 +, -, *, /, % 연산만 입력해주세요")
            println("숫자 또는 연산 입력창에 \"q 또는 quit\"을 입력하면 계산기 작동을 멈춥니다.")
            println("숫자 또는 연산 입력창에 \"r 또는 reset\"을 입력하면 계산값이 초기화 됩니다.")
            println("------------------------------------")
        }

        fun endPrint(){
            println("------------------------------------")
            println("계산기를 종료합니다.")
            println("------------------------------------")
        }

        fun resetPrint() {
            println("------------------------------------")
            println("계산 결과를 초기화 합니다.")
            println("------------------------------------")
        }

        fun wrongNumber() {
            println("------------------------------------")
            println("정수 또는 실수를 입력해주세요")
            println("------------------------------------")
        }

        fun resultNumber(result : Number) {
            if (result is Double || result is Long) {
                println("계산 결과 : ${result}")
            }
        }

        fun wrongOperator() {
            println("------------------------------------")
            println("연산기호가 잘못됐습니다.")
            println("다시 입력해주세요")
            println("------------------------------------")
        }

        fun zeroDivision() {
            println("------------------------------------")
            println("0으로 나눌 수 없습니다.")
            println("다시 입력해주세요")
            println("------------------------------------")
        }
    }


}