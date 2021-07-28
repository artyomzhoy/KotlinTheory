fun main() {
    val options: Array<String> = arrayOf("Rock", "Paper", "Scissors") // создаем неизменяемый массив типа String
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
    

//       Содержимое переменной options передается функции getGameChoice.
//       В переменной options хранится ссылка на массив с элементами
//       String; копия ссылки передается функции getGameChoice и попадает
//       в ее параметр options. Это означает, что в переменных options
//       и options хранятся ссылки на один и тот же массив.
    
    /** Как создаются функции.
     *
     * Новые функции определяются ключевым словом fun, за которым следует имя функции.
     */
    
    fun foo() {
        //Здесь размещается код функции
    }
    
    /** Функции можно передавать данные.
     *
     * Чтобы сообщить компилятору, какие значения получает функция, вы указываете один или несколько параметров.
     * Каждый параметр должен обладать именем и типом.
     */
    
    fun foo(param: Int) { // Параметры объявляются в круглых скобках в начале функции.
        // функция foo получает один параметр Int с именем param
        println("Parameter is $param")
    }
    
    /**
     * После этого можно вызвать функцию и передать ей значение Int: foo(6)
     *
     * Если у функции есть параметр, ей необходимо что-то передать.
     * И это «что-то» непременно должно быть значением подходящего
     * типа. Следующий вызов функции работать не будет, потому что
     * функция foo должна получать значение типа Int, а не String.
     */
    
    // foo("Freddie")
    
    
    /** Вызов функции с двумя параметрами и передача двух аргументов.
     *
     */
    
    printSum(5, 6)
}

//                             Аргументы передаются функции в том порядке, в котором вы их указали.
//                             Первый аргумент попадает в первый параметр, второй
//                             аргумент — во второй параметр и т.д.
//                             Каждый передаваемый аргумент должен
//                             относиться к тому же типу, что и параметр, в котором он окажется.

fun printSum(int1: Int, int2: Int) {
    val result = int1 + int2
    println(result)
}

/** Получение значений из функции.
 *
 * Если вы хотите получить значение из функции, его необходимо объявить.
 *
 */

fun max(a: Int, b: Int): Int {      // Int сообщает компилятору, что функция возвращает значение Int. 
    val maxValue = if (a > b) a else b
    return maxValue // Чтобы вернуть значение, используйте ключевое слово ‘return’, за которым следует возвращаемое значение.
    // return "Fish" - Если функция объявлена с возвращаемым значением, вы должны вернуть значение объявленного типа.
//                    Следующий код недопустим, потому что он возвращает String вместо Int.
}

fun getGameChoice(options: Array<String>) = // Используйте = для определения значения, возвращаемого функцией, и уберите фигурные скобки {}
    options[(Math.random() * options.size).toInt()] // Компилятор знает, что options - String и сам определяет, что возвращать
// спросить Артура, почему так или узнать самому

/** Оператор .. берет значения ОТ и ДО. 1..100
 *
 * Оператор until исключает последнее значение. 1 until 100
 *
 * Оператор downTo перебирает числа в обратном порядке. 15 downTo 1
 *
 * Ключевое слово step устанавливает размер шага для перебора. 1..100 step 2
 *
 */

fun getUserChoice(options: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    
    while (!isValidChoice) {
    
        //Запросить у пользователя его выбор
        print("Please enter one of the following:")
        for (item in options)
            print(" $item")
        println(".")
    
        //Прочитать пользовательский ввод
        val userInput =
            readLine() // Читает пользовательский ввод из стандартного входного потока. В нашем случае это окно вывода в IDE.
    
        //Проверить пользовательский ввод
        if(userInput != null && userInput in options) {
            isValidChoice = true // Если ввод пользователя прошел проверку, цикл прерывается.
            userChoice = userInput
        }
    
        //Если выбран недопустимый вариант, сообщить пользователю
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    
    if (userChoice == gameChoice) result = "Tie"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
            (userChoice == "Paper" && gameChoice == "Rock") ||
            (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win!"
    else result = "You lose!"
    
    println("You chose $userChoice. I chose $gameChoice. $result")
}