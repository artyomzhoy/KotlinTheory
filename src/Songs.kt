/** Класс представляет собой шаблон, определяющий свойства и функции, связанные с объектами этого типа.
 *
 * То, что объект знает о себе, — свойства. То, что объект может сделать, — его функции.
 * Они определяют поведение объекта и могут использовать свойства объекта.
 *
 * Функция, определенная внутри класса, называется функцией класса. Также иногда используется термин «метод».
 *
 *
 */

class Song (val title: String, val artist: String) {
    
    // Этот код (вместе с круглыми скобками) является конструктором класса.
    // Формально он называется первичным конструктором.
    // Конструктор Song определяет свойства,
    // а каждое свойство на самом деле — это всего лишь переменная, локальная для объекта. И этой переменной
    // присваивается значение.
    
    fun play() {
        println("Playing the song $title by $artist")
    }
    
    fun stop() {
        println("Stopped playing $title")
    }
}

fun main() {
    
    /** Кажется, будто мы вызываем функцию с именем Song. Но хотя внешне
     * и по поведению эта конструкция похожа на функцию, это не так. Вместо этого здесь вызывается конструктор Song.
     *
     * Конструктор выполняется при создании экземпляра объекта. Он используется для определения свойств и их инициализации.
     */
    
    val songOne = Song("The Mesopotamians", "They Might Be Giants")
    val songTwo = Song("Going Underground", "The Jam")
    val songThree = Song("Make Me Smile", "Steve Harley")
    
    songOne.play()
    songOne.stop()
    songTwo.play()
}

/** Гибкая инициализация свойств
 *
 * Определение свойств в теле класса обеспечивает намного большую гибкость,
 * чем простое добавление их в конструктор, так как в этом случае не приходится инициализировать каждое
 * свойство значением параметра конструктора.
 *
 */

class Dog(val name: String, weight_param: Int, breed_param: String) {
    var activities = arrayOf("Walks")
    
//    Каждый созданный объект Dog содержит свойство activities. Его исходным
//    значением является массив, содержащий значение «Walks».

//    name: “Fido”
//    weight: 70
//    breed: “Mixed”
//    activities: “Walks”
    
    /** А может оказаться, что вы хотите изменить значение параметра
     * конструктора перед тем, как присваивать его свойству.
     *
     *  Допустим, свойству breed вместо значения, переданного конструктору,
     *  должна присваиваться версия строки, преобразованная к верхнему регистру.
     */
    
    val breed = breed_param.toUpperCase()
    
//    Берет значение breed_param, преобразует
//    его к верхнему регистру и присваивает
//    свойству breed.

//    name: “Fido”
//    weight: 70
//    breed: “MIXED”
//    activities: “Walks”
    
    /** Как использовать блоки инициализации
     *
     * Если свойство должно инициализироваться чем-то более сложным, чем простое выражение,
     * или если при создании каждого объекта должен выполняться дополнительный
     * код, можно использовать один или несколько блоков инициализации.
     * Блоки инициализации выполняются при инициализации объекта сразу же после вызова конструктора
     * и снабжаются префиксом init.
     *
     * Ваш класс может содержать несколько блоков инициализации. Они выполняются
     * в том порядке, в котором определяются в теле класса, чередуясь с инициализаторами свойств.
     *
     */

    init {
        println("Dog $name has been created.")
    }
    
//    Это блок инициализации. Он содержит код, который
//    должен выполняться при инициализации объекта Dog.
    
    /** Свойства должны инициализироваться перед их использованием в коде.
     *
     * Если вы абсолютно уверены в том, что исходное значение свойства не может быть
     * задано при вызове конструктора класса, это свойство можно снабдить префиксом lateinit. Тем самым
     * вы сообщаете компилятору, что свойство намеренно еще не было инициализировано, и вы решите эту проблему позднее.
     */

//    var temperament: String
//    Свойство temperament не было инициализировано, поэтому код не компилируется.
//    Практически во всех случаях вы сможете назначать свойствам значения по умолчанию.
    
    var temperament = ""
    
//    Инициализирует свойство temperament пустой строкой.
    
//    lateinit var temperament: String

//    Префикс lateinit может использоваться только со свойствами, определенными с ключевым словом var; кроме того, он
//    не может использоваться со следующими типами: Byte, Short,
//    Int, Long, Double, Float, Char или Boolean, что связано с особенностями обработки этих типов при выполнении кода
//    в JVM.
    
    /** Пользовательские get-методы.
     *
     * Строка определяет get-метод. Он представляет собой функцию без параметров с именем get,
     * которая добавляется в свойство. Чтобы включить его в свойство,
     * следует записать его сразу же под объявлением свойства. Тип возвращаемого
     * значения должен совпадать с типом свойства, значение которого должен
     * возвращать get-метод, в противном случае код не будет компилироваться.
     * В приведенном примере свойство weightInKgs имеет тип Double, так что
     * get-метод свойства тоже должен возвращать тип Double.
     *
     */

    val weightInKgs: Double
        get() = weight / 2.2
    
    /** Пользовательские set-методы.
     *
     * Set-метод представляет собой функцию с именем set, которая записывается под объявлением свойства.
     * Set-метод имеет один параметр (обычно с именем value), который содержит новое значение свойства.
     *
     * В приведенном примере значение свойства weight обновляется только в том случае,
     * если значение параметра value больше 0. Если попытаться обновить свойство weight значением, меньшим либо
     * равным 0, set-метод запретит обновление свойства.
     *
     * Для обновления свойства weight set-метод использует идентификатор field,
     * обозначающий поле данных для свойства. Его можно рассматривать как ссылку на нижележащее значение свойства.
     * Очень важно использовать field в get- и set-методах вместо имени свойства,
     * потому что так вы предотвращаете зацикливание. 
     *
     */
    
    var weight = weight_param
        set(value) {
            if (value > 0) field = value
        }
}
