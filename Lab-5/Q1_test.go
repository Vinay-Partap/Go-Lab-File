
package main

import "testing"

func TestAddItem(t *testing.T) {
	fruits = nil

	err := addFruit(Fruit{1, "Mango", 5, 50})

	if err != nil {
		t.Error("Add failed")
	}
}

func TestUpdateItem(t *testing.T) {
	fruits = nil
	addFruit(Fruit{1, "Mango", 5, 50})

	err := updateFruits(1, 10)

	if err != nil || fruits[0].Quantity != 10 {
		t.Error("Update failed")
	}
}

func TestRemoveItem(t *testing.T) {
	fruits = nil
	addFruit(Fruit{1, "Mango", 5, 50})

	err := removeFruits(1)

	if err != nil || len(fruits) != 0 {
		t.Error("Remove failed")
	}
}
