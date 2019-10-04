fun main() {
    // copy object in object
    class Person (var name: String = "Orig", var type: String = "piece",
                       var age: Int = 18, var high: Double = 25.7, var code: Int = 1522)
    {
        override fun toString() = "Name: $name Age: $age Type: $type High: $high Code: $code"
        val somebody
        get () = listOf(Person("due","shit",35,14.5,1468))
    }

    var default: Person = Person()
    var ann: Person = Person("Ann", "man", 10, 0.5, 1408) // 1st object with some properties
    var bob: Person = Person("Bob", "girl", 20, 15.0, 1239) // 2nd object with prop
    val copyAnn: Person

    // изначальные параметры объектов
    println("""Properties of Ann: 
        |$ann
        |""".trimMargin()) // props 1st object
    println("""Properties of Bob: 
        |$bob
        |""".trimMargin()) // props 2nd object
    println("""Default: 
        |$default
        |""".trimMargin()) // props default
    println("""Default.somebody list: 
        |${default.somebody}
        |""".trimMargin()) // параметр, содержащий объект класса

    //копирование в объект bob и copyAnn
    bob = ann.deepCopy() // copy 1st in 2nd
    copyAnn = ann.deepCopy()

    //результат копирования
    println("""New Ann: 
        |$copyAnn
        |""".trimMargin())
    println("""Bob has Anns' props: 
        |$bob
        |""".trimMargin()) // new props 2nd object

    //изменение параметра и результат
    ann.name = "changed"
    println("""New name Ann: 
        |${ann.name}
        |""".trimMargin())

    //копирование Ann в объект, содержащий список
    default = ann.deepCopy()
    println("""Default copy Ann: 
        |$default
        |Параметр somebody:
        |${default.somebody}
        |""".trimMargin())

    //copy default in Ann
    ann = default.deepCopy()
    println("""Ann has default props:
        $ann
Prop somebody: ${ann.somebody}
        
    """.trimIndent())

    //changed Anns' props
    ann.age = 34
    ann.high = 7.23
    ann.code = 5344
    println("""Changed Ann: 
        |$ann
        |""".trimMargin())
}