// package main
// import "fmt"

// type Student struct {
// 	Name string
// 	Age  int
// 	ID   string
// 	marks float64
// }
// func (s Student) grade() string {
// 	if(s.marks >= 90){
// 		return "A"
// 	}
// 	if(s.marks >= 80){
// 		return "B"
// 	}
// 	if(s.marks >= 70){
// 		return "C"
// 	}
// 	if(s.marks >= 60){
// 		return "D"
// 	}
// 	return "F"
// }
// func birthday(s *Student) {
// 	s.Age++
// 	fmt.Println("Happy Birthday,", s.Name, "!")
// }


// func main() {
// 	s1 := Student{
// 		Name: "Alice",
// 		Age:  20,
// 		ID:   "123456",
// 		marks : 85.5,
// 	}
// 	s2 := Student{
// 		Name: "Bob",
// 		Age:  22,
// 		ID:   "789012",
// 		marks : 92.0,
// 	}
// 	fmt.Println("Student Name:", s1.Name)
// 	fmt.Println("Student Age:", s1.Age)
// 	fmt.Println("Student ID:", s1.ID)
// 	fmt.Println("Student Marks:", s1.marks)

// 	fmt.Println("Student Grade:", s1.grade())
// 	fmt.Println("Student Grade:", s2.grade())


// 	birthday(&s1)
// 	fmt.Println("Updated Student Age:", s1.Age)

// 	}