package main

import "fmt"

type Person struct {
	Name string
	Age  int
	Job string
	Salary float64
}

func (p *Person) read(){
	fmt.Println("Enter name:")
	fmt.Scanln(&p.Name)

	fmt.Println("Enter age:")
	fmt.Scanln(&p.Age)

	fmt.Println("Enter job:")
	fmt.Scanln(&p.Job)
	
	fmt.Println("Enter salary:")
	fmt.Scanln(&p.Salary)
}

func (p *Person) display(){
	fmt.Println("Name:", p.Name)
	fmt.Println("Age:", p.Age)
	fmt.Println("Job:", p.Job)
	fmt.Println("Salary:", p.Salary)
}

func main() {
	var p1 Person
	fmt.Println("Enter details for person 1:")
	p1.read()
	fmt.Println("Details of person 1:")
	p1.display()

	var p2 Person
	fmt.Println("Enter details for person 2:")
	p2.read()
	fmt.Println("Details of person 2:")
	p2.display()
}

