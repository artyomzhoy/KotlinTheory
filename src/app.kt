fun main(args: Array<String>) { // fun означает, что это функция
    // main - имя функции
    // параметры функции заключены в круглые скобки, в данный момент функция получает массив строк,
    // и этому массиву присвоено имя args
    println("Hello Kotlin")

    var x = 1 // var - изменяемое значение переменной

    println("Before the loop: x = $x") // выводим переменную х до цикла

    while (x < 4) { // поку условие (в скобках) имеет значение true цикл будет выполняться
        // код цикла будет выполняться, пока x остается меньше 4

        println("In the loop: x = $x") // выводим переменную х в цикле
        x += 1 // увеличиваем значение переменной
    }

    println("After the loop: x = $x") // значение переменной после выхода из цикла

    val y = 1 // val - неизменяемое значение переменной
    val z = 3

    println(if (z > y) "z is greater than y" else "z is not greater than y") // если условие (в скобках) имеет значение true,
    // оно выполнится, в противном случае используется else
    println("This line runs no matter what")

    /** При объявлении переменной значение, присвоенное переменной, используется для создания нового объекта.
     * В данном примере число 1 присваивается новой переменной с именем i. Компилятор знает, что 5 является целым числом,
     * поэтому он создает новый объект Int со значением 1. И компилятор определяет тип переменной по этому объекту.
     * Объект имеет тип Int, поэтому переменная тоже будет относиться к типу Int.
     * Когда объект присваивается переменной, сам объект в переменной не сохраняется.
     * Вместо этого в переменной сохраняется ссылка на объект. По ссылке, хранящейся в переменной, можно получить доступ к объекту.
     */
    var i = 1

    while (i < 3) {
        print (if ( i == 1) "Yab" else "Dab")
        print("ba")
        i += 1
    }
    if (i == 3) println("Do")

    /** Целые числа
     *
     * Тип     Биты        Диапазон значений
     *
     * Byte    8 битов     –128 до 127</p>
     *
     * Short   16 битов    –32768 до 32767
     *
     * Int     32 бита     –2147483648 до 2147483647
     *
     * Long    64 бита     –huge до (huge - 1)
     *
     * Каждый тип вмещает фиксированное количество битов. Например, тип Byte может содержать 8 битов,
     * поэтому Byte может представлять целочисленные значения
     * от –128 до 127.
     *
     * Если присваиваемое число слишком велико, чтобы поместиться в Int,
     * то будет создан объект и переменная типа Long. Чтобы создать объект и переменную типа Long,
     * можно также добавить суффикс «L» в конец целого числа.
     */

    var hugeNumber = 1L

    /** Значения с плавающей точкой
     *
     * Существуют два основных типа с плавающей точкой: Float и Double.
     * Тип Float вмещает до 32 битов, тогда как Double — до 64 битов.
     *
     * По умолчанию при объявлении переменной с присваиванием числа с плавающей точкой будет создан объект
     * и переменная типа Double. Если добавить в конец числа суффикс «F» или «f», то создается тип Float.
     */

    var number = 123.5F

    /** Логические значения
     *
     * Переменные Boolean используются для значений из набора true или false.
     * Для создания объекта и переменных Boolean переменные объявляются в коде следующего вида:
     */

    var isBarking = true
    var isTrained = false

    /** Символы и строки
     *
     * Переменные Char используются для представления отдельных символов.
     * При создании переменной Char присваивается символ, заключенный в одинарные кавычки.
     *
     * Переменные String предназначены для хранения наборов символов, объединенных в цепочку.
     * Чтобы создать переменную типа String, присвойте ей последовательность символов, заключенных в двойные кавычки.
     *
     * Tип Char в Kotlin содержит символы, а не числа.
     */

    var letter = 'D'
    var name = "Fido"

    /** Чтобы не поручать компилятору определение типа переменной по ее значению,
     * поставьте двоеточие (:) после имени переменной, а потом укажите нужный тип. Итак, приведенный ниже код
     * означает «создать изменяемую переменную с именем smallNum и типом Short».
     * Аналогичным образом для объявления переменной с типом Byte.
     *
     *  Если вы хотите явно объявить тип переменной и присвоить ей значение — это тоже возможно.
     *  Например, следующая команда создает переменную типа Short с именем c и присваивает ей значение 6.
     *
     *  Переменная ДОЛЖНА быть инициализирована перед использованием, иначе компилятор сообщит об ошибке.
     *
     *  Компилятор Kotlin разрешает присвоить значение переменной только в том случае,
     *  если значение совместимо с переменной. Если значение слишком велико или относится к неподходящему типу,
     *  код не будет компилироваться.
     */

    var smallNum: Short
    var tinyNum: Byte
    var c: Short = 6

    var q: Int
    var w = q + 6 // следующий код не будет компилироваться, потому что q не было присвоено исходное значение

    var e: Int = 3.12 // Компилятор понимает, что значение 3.12 невозможно разместить в Int без потери точности
    // (то есть потери всей дробной части), поэтому отказывается компилировать код.

    /** Объект обладает состоянием и поведением. Доступ к его поведению предоставляется через функции.
     *
     * Каждый числовой тип содержит следующие функции преобразования:
     * toByte(), toShort(), toInt(), toLong(), toFloat() и toDouble().
     *
     * Создается переменная Int с именем x и объект Int со значением 5. В x сохраняется ссылка на этот объект.
     *
     * Создается новая переменная Long с именем z. Вызывается функция toLong() для объекта x,
     * которая создает новый объект Long со значением 5. Ссылка на объект Long сохраняется в переменной z.
     *
     */

    var x = 5
    var z: Long = x.toLong()
}