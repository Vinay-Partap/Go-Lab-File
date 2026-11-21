
import java.util.Scanner

class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {

    // Accept or update student data
    fun acceptData(scanner: Scanner) {
        print("Enter Roll Number: ")
        rollNo = scanner.nextInt()
        scanner.nextLine()

        print("Enter Name: ")
        name = scanner.nextLine()

        print("Enter Course: ")
        course = scanner.nextLine()

        print("Enter Percentage: ")
        percentage = scanner.nextDouble()
    }

    // Display student details
    fun displayDetails() {
        println("\n----- STUDENT DETAILS -----")
        println("Roll Number : $rollNo")
        println("Name        : $name")
        println("Course      : $course")
        println("Percentage  : $percentage%")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Create two Student objects using primary constructor
    val student1 = Student(101, "Aman", "CSE", 85.5)
    val student2 = Student(102, "Rahul", "IT", 90.0)

    println("Enter details for Student 1:")
    student1.acceptData(scanner)
    student1.displayDetails()

    println("\nEnter details for Student 2:")
    student2.acceptData(scanner)
    student2.displayDetails()

    scanner.close()
}
