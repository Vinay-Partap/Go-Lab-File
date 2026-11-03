
open System
open System.Text.RegularExpressions

// (1) Reverse string
let reverseString (str: string) =
    str.ToCharArray()
    |> Array.rev
    |> fun chars -> String(chars)

// Check palindrome
let isPalindrome (str: string) =
    let reversed = reverseString str
    str.Equals(reversed, StringComparison.OrdinalIgnoreCase)

// (2) Transform string using pattern matching
let transformString (str: string) =
    match str with
    | s when Regex.IsMatch(s, @"^[a-zA-Z]+$") ->
        s.ToUpper()
    | s when Regex.IsMatch(s, @"^[0-9]+$") ->
        s + s
    | _ -> str

// (3) Email validation
let isValidEmail (email: string) =
    Regex.IsMatch(
        email,
        @"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
    )

[<EntryPoint>]
let main argv =

    // Task 1: Reverse and Palindrome
    printfn "===== REVERSE AND PALINDROME ====="

    let strings = ["madam"; "hello"; "level"]

    strings
    |> List.iter (fun s ->
        printfn "Original: %s" s
        printfn "Reversed: %s" (reverseString s)
        printfn "Palindrome: %b\n" (isPalindrome s)
    )

    // Task 2: String Transformation
    printfn "===== STRING TRANSFORMATION ====="

    let inputs = ["hello"; "12345"; "Hello123"]

    inputs
    |> List.iter (fun s ->
        printfn "Input: %s" s
        printfn "Output: %s\n" (transformString s)
    )

    // Task 3: Email Validation
    printfn "===== EMAIL VALIDATION ====="

    let emails = [
        "2301010231@krmu.edu.in"
        "bhardwajvinay400@gmail.com"
        "invalid-email"
    ]

    emails
    |> List.iter (fun email ->
        if isValidEmail email then
            printfn "%s -> Valid Email" email
        else
            printfn "%s -> Invalid Email" email
    )

    0
