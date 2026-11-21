
// Q2: Function Declarations in Kotlin

// 1. Function with default parameters
fun displayStudent(name: String = "Vinay", age: Int = 23) {
    println("Name: $name, Age: $age")
}

// 3. Function with vararg
fun printNumbers(vararg numbers: Int) {
    println("Numbers:")
    for (num in numbers) {
        print("$num ")
    }
    println()
}

// 4. Higher-order function
fun applyOperation(numbers: List<Int>, operation: (Int) -> Int) {
    val result = numbers.map(operation)
    println("Result: $result")
}

fun main() {

    println("----- DEFAULT PARAMETERS -----")
    displayStudent()
    displayStudent("Rahul", 21)

    println("\n----- NAMED ARGUMENTS -----")
    displayStudent(age = 22, name = "Aman")

    println("\n----- VARARG FUNCTION -----")
    printNumbers(10, 20, 30, 40, 50)

    println("\n----- HIGHER-ORDER FUNCTION -----")
    val numbers = listOf(1, 2, 3, 4, 5)

    // Lambda to calculate square
    applyOperation(numbers) { it * it }
}
