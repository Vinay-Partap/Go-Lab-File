package main

import "fmt"

type Student struct {
    Name  string
    Age   int
    ID    string
    Marks float64
}

var students = []Student{

    {"John", 20, "12345", 85.5},

    {"Alice", 22, "67890", 92.0},
}

func grade(marks float64) string {

    if marks >= 90 {
        return "A"
    }

    if marks >= 80 {
        return "B"
    }

    if marks >= 70 {
        return "C"
    }

    return "F"
}

func main() {

    for _, s := range students {

        fmt.Println("Student Name:", s.Name)
        fmt.Println("Student Age:", s.Age)
        fmt.Println("Student ID:", s.ID)
        fmt.Println("Student Marks:", s.Marks)
        fmt.Println("Student Grade:", grade(s.Marks))
        fmt.Println()
    }
}