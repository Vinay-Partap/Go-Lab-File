
package main

import (
	"fmt"
)

type Fruit struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

var fruits []Fruit


func addFruit(fruit Fruit) error {

	for _, i := range fruits {
		if i.ID == fruit.ID {
			return fmt.Errorf("fruit already exists")
		}
	}

	fruits = append(fruits, fruit)
	return nil
}


func updateFruits(id int, quantity int) error {
	fruits[id].Quantity = quantity
	return fmt.Errorf("item not found")
}


func removeFruits(id int) error {
	for i, item := range fruits {
		if item.ID == id {
			fruits = append(fruits[:i], fruits[i+1:]...)
			return nil
		}
	}
	return fmt.Errorf("item not found")
}


func summary(ch chan float64) {
	total := 0.0

	for _, item := range fruits {
		total += float64(item.Quantity) * item.Price
	}

	ch <- total
}

func main() {
	addFruit(Fruit{1, "Mango", 5, 50})
	addFruit(Fruit{2, "Apple", 10, 20})
	addFruit(Fruit{3, "grapes", 14, 100})
	addFruit(Fruit{4, "Oranges", 18, 120})
	

	updateFruits(2, 15)
	removeFruits(1)

	fmt.Println("Inventory:", fruits)

	ch := make(chan float64)
	go summary(ch)

	fmt.Println("Total Inventory Value:", <-ch)
}
