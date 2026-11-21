
fun main() {

    // 1. Hello Kotlin
    println("Hello Kotlin!!!")

    // 2. Employee Bonus Calculation
    println("\n----- EMPLOYEE BONUS -----")

    print("Enter Department Code (IT/HR/FINANCE): ")
    val deptCode = readLine()!!.uppercase()

    print("Enter Years of Experience: ")
    val experience = readLine()!!.toInt()

    print("Enter Employee Salary: ")
    val salary = readLine()!!.toDouble()

    val bonusPercentage = when (deptCode) {
        "IT" -> if (experience > 5) 20 else 10
        "HR" -> if (experience > 3) 15 else 10
        "FINANCE" -> 12
        else -> 10
    }

    val bonusAmount = salary * bonusPercentage / 100

    println("Department: $deptCode")
    println("Bonus Percentage: $bonusPercentage%")
    println("Bonus Amount: Rs. $bonusAmount")
    println("Total Salary: Rs. ${salary + bonusAmount}")


    // 3. Average of Individual Digits
    println("\n----- DIGIT AVERAGE -----")

    print("Enter an integer: ")
    val number = readLine()!!.toLong()

    var n = kotlin.math.abs(number)
    var sum = 0L
    var count = 0

    if (n == 0L) {
        sum = 0
        count = 1
    } else {
        while (n > 0) {
            val digit = n % 10
            sum += digit
            count++
            n /= 10
        }
    }

    val average = sum.toDouble() / count

    println("Sum of Digits: $sum")
    println("Number of Digits: $count")
    println("Average of Digits: $average")
}
