### 스파르타 코딩클럽 Kotlin&Spring 트랙 2기 최민수의 계산기 과제 프로젝트입니다.
------

### 프로젝트 소개
두 수와 연산기호를 입력 받아 두 수를 연산기호에 맞는 결과를 보여줍니다.

수는 정수와 실수를 입력받습니다.

연산기호는 +(더하기), -(빼기), *(곱하기), /(몫), %(나머지)를 입력 받습니다.

+ 예) 3 + 4.2 = 7.2
+ 예) 5 / 2 = 2(몫)

계산 결과는 누적되어 다음 연산에 이용됩니다. --> 일반적인 계산기처럼 만들었습니다.

+ 예) 3 + 4 = 7 --> + 5 = 12 

수와  연산기호 입력창에 r 또는 reset을 입력 시 계산 결과가 초기화 됩니다.

수와  연산기호 입력창에 q 또는 quit을 입력 시 계산기가 종료됩니다.


---------
### 개발 기간
2024-04-22(월) ~ 2024-04-26(금) 5일간

--------
### 개발 환경
IDE : IntelliJ

JDK : 21.0.1

프로그램 언어 : 코틀린

------------
### 구현 기능

#### 정수, 실수 구분
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

1. 먼저 정수 변환을 시도한다.
2. 에러가 발생 시 실수 변환을 시도한다.
3. 에러 발생시 잘못된 값을 입력 받았다. --> 다시 입력 받는다.

#### 연산기호에서 잘못된 값 구별

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



#### 계산기 종료 및 계산 결과 초기화


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

+ 입력 받은 연산기호가 r이면 리셋, q면 종료한다.

#### 정수, 실수 타입별 계산

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

+ 예로 더하기 클래스에서 설명
+ 두 수를 Any(어떤 타입이든지)로 받는다.
+ 두 수의 타입을 각각 확인 후 계산 결과를 반환한다.
+ 만약 잘못된 타입을 받으면 잘못됐다고 표시 후 반환한다.

#### 계산 결과에 따른 타입 분류

      if (resultDouble % 1.0 == 0.0) {
          resultLong = resultDouble.toLong()
          doubleFlag = false
      }

+ 만약 실수타입에서 계산 결과가 정수로 될 경우 정수로 변환한다.

#### 소수점 5번째까지 표시

        resultDouble = resultDouble * 100000
        if (resultDouble - resultDouble.toLong() >= 0.5 ) {
            resultDouble = ceil(resultDouble) / 100000.0
        } else {
            resultDouble = floor(resultDouble) / 100000.0
        }

+ 만약 실수 타입에서 소수점이 너무 길어지면 소수점 5번 자리까지만 표시한다.
