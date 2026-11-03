
open System

// Recursive function to check prime number
let isPrime n =
    let rec check divisor =
        if divisor * divisor > n then
            true
        elif n % divisor = 0 then
            false
        else
            check (divisor + 1)

    if n <= 1 then
        false
    else
        check 2

[<EntryPoint>]
let main argv =

    printf "Enter an integer: "
    let num = int (Console.ReadLine())

    if isPrime num then
        printfn "%d is a Prime Number" num
    else
        printfn "%d is not a Prime Number" num

    0
