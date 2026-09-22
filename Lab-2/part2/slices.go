package main

import ("fmt"
	"slices")

func main() {

	s:= []string{"Vinay", "Kirti", "Abhishek", "Archi", "Adeela"}

	fmt.Println("Slice of strings:", s)

	var name string
	fmt.Println("Enter a name to add in the slice:")
	fmt.Scanln(&name)

	// Insert
	s = append(s, name)
	fmt.Println("Updated slice of strings:", s)

	// Delete
	index := 1
    s = append(s[:index], s[index+1:]...)
    fmt.Println("After removing index", index, ":", s)
	
	// delete for the range of index
	startIndex := 1
	endIndex := 3
	s = append(s[:startIndex], s[endIndex:]...)
	fmt.Println("After removing range of index", startIndex, "to", endIndex-1, ":", s)

	// Update
	s[1] = "Shivam"
    fmt.Println("After updating:", s)

	// Map
	marks := map[string]int{
        "Math":    85,
        "Science": 90,
        "English": 78,
    }

    fmt.Println("Initial map:", marks)

    // Insert
    marks["Computer"] = 95
    fmt.Println("After inserting:", marks)

    // Delete
    delete(marks, "English")
    fmt.Println("After deleting English:", marks)

    // Lookup
    value, exists := marks["Math"]

    if exists {
        fmt.Println("Math marks:", value)
    } else {
        fmt.Println("Math not found")
    }

	
}


