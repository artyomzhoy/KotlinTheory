fun main(args: Array<String>) {

    /** Массивы создаются функцией arrayOf().
     *
     * Чтобы получить значение элемента массива, обратитесь к переменной массива с указанием индекса.
     *
     * println(myArray[0])
     *
     * Для получения размера массива используется функция: myArray.size
     *
     */

    val wordArray1 = arrayOf("24/7", "multi-tier", "B-to-B", "dynamic", "pervasive")

    /** Компилятор определяет тип массива по значениям элементов.
     *
     * Массив с элементами Int с именем myArray:
     * var myArray = arrayOf(1, 2, 3)
     *
     * Чтобы обновить второй элемент и присвоить ему значение 15, используйте код следующего вида: myArray[1] = 15
     *
     * Но здесь есть один нюанс: значение должно иметь правильный тип.
     *
     * Компилятор проверяет тип каждого элемента в массиве и раз и навсегда определяет тип элементов,
     * которые должны храниться в массиве. В предыдущем примере массив объявляется со значениями Int,
     * поэтому компилятор делает вывод, что массив будет содержать только значения типа Int.
     * При попытке сохранить в массиве что-либо кроме Int код не будет компилироваться:
     *
     * myArray[1] = "Fido" //Не компилируется
     */

    val wordArray2 = arrayOf("empowered", "leveraged", "aligned", "targeted")

    /** Явное определение типа массива.
     *
     * var myArray: Array<Byte> = arrayOf(1, 2, 3)
     *
     * Код Array<Byte> сообщает компилятору, что вы хотите создать массив для хранения переменных Byte.
     * В общем случае тип создаваемого массива просто указывается в угловых скобках (<>).
     *
     */

    val wordArray3 = arrayOf("process", "paradigm", "solution", "portal", "vision")

    /** ВАЖНО!!!
     *
     * var означает, что переменная может указывать на другой массив
     *
     * При объявлении переменной с ключевым словом var переменную можно изменить, чтобы в ней хранилась
     * ссылка на другой объект. Если переменная содержит ссылку на массив, это означает, что
     * переменную можно обновить, чтобы в ней хранилась ссылка на другой массив того же
     * типа. Например, следующий код абсолютно правилен и откомпилируется без ошибок:
     *
     * var myArray = arrayOf(1, 2, 3) - Создает массив Int и переменную с именем myArray, в которой хранится ссылка на него.
     *
     * myArray = arrayOf(4, 5) - Создает новый масссив с элементами Int. Ссылка на новый массив сохраняется в переменной myArray и заменяет предыдущую ссылку.
     *
     * val означает, что переменная всегда будет указывать на один и тот же массив
     *
     * Если массив объявляется с ключевым словом val, вы не сможете обновить переменную так, чтобы в ней хранилась ссылка на другой массив.
     *
     * val myArray = arrayOf(1, 2, 3)
     * myArray = arrayOf(4, 5, 6) - Если переменная массива объявляется с ключевым словом val, ее нельзя изменить и заставить указывать на другой массив.
     *
     * Но хотя в переменной всегда хранится ссылка на один и тот же массив, сам массив при этом может изменяться.
     *
     * val myArray = arrayOf(1, 2, 3)
     * myArray[2] = 6 - Изменяет третий элемент в массиве.
     */

    val arraySize1 = wordArray1.size
    val arraySize2 = wordArray2.size
    val arraySize3 = wordArray3.size

    /** Math.random() возвращает случайное число в диапазоне от 0 до (почти) 1, которое для
     * получения индекса необходимо умножить на количество элементов в массиве. После этого результат преобразуется
     * в целое число вызовом toInt().
     */

    val rand1 = (Math.random() * arraySize1).toInt()
    val rand2 = (Math.random() * arraySize2).toInt()
    val rand3 = (Math.random() * arraySize3).toInt()

    /** Используется строковый шаблон для того, чтобы выбрать три слова и объединить их в строку.
     *
     * Строковые шаблоны предоставляют простой и быстрый механизм включения переменных в строковые значения.
     *
     * Чтобы включить значение переменной в строку, поставьте перед именем переменной префикс $.
     *
     * Также строковые шаблоны могут использоваться для обращения к свойствам объектов и вызова их функций.
     * В этом случае выражение заключается в фигурные скобки.
     *
     * Строковые шаблоны даже могут использоваться для вычисления более сложных выражений внутри строк.
     * Скажем, в следующем примере выражение if используется для включения разного текста в зависимости от размера массива myArray:
     *
     * var result = "myArray is ${if (myArray.size > 10) "large" else "small"}"
     */

    val phrase = "${wordArray1[rand1]} ${wordArray2[rand2]} ${wordArray3[rand3]}"

    println(phrase)
}