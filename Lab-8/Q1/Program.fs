
open System

// Base Class
[<AbstractClass>]
type Shape() =
    abstract member Area : unit -> float

// Derived Class: Circle
type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        Math.PI * radius * radius

// Derived Class: Rectangle
type Rectangle(length: float, width: float) =
    inherit Shape()

    override this.Area() =
        length * width

[<EntryPoint>]
let main argv =

    let circle = Circle(5.0)
    let rectangle = Rectangle(10.0, 4.0)

    printfn "===== OOP IN F# ====="

    printfn "\nCircle:"
    printfn "Area = %.2f" (circle.Area())

    printfn "\nRectangle:"
    printfn "Area = %.2f" (rectangle.Area())

    // Demonstrating Polymorphism
    printfn "\n===== POLYMORPHISM ====="

    let shapes: Shape list = [ circle; rectangle ]

    shapes
    |> List.iter (fun shape ->
        printfn "Area = %.2f" (shape.Area())
    )

    0
