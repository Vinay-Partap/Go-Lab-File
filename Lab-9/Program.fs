
open System
open Microsoft.Data.Sqlite


type Student = {
    Id: int
    Name: string
    Age: int
}


let getCategory age =
    match age with
    | age when age < 18 -> "Minor"
    | age when age <= 22 -> "Young"
    | _ -> "Senior"


let displayStudents (con: SqliteConnection) =
    use cmd = con.CreateCommand()
    cmd.CommandText <- "SELECT Id, Name, Age FROM Students"

    use reader = cmd.ExecuteReader()

    while reader.Read() do
        printfn "ID: %d | Name: %s | Age: %d"
            (reader.GetInt32(0))
            (reader.GetString(1))
            (reader.GetInt32(2))


let workflow = async {

    do! Async.Sleep(500)

    let students = [
        { Id = 1; Name = "Vinay"; Age = 20 }
        { Id = 2; Name = "Abhishek"; Age = 17 }
        { Id = 3; Name = "Adeela"; Age = 22 }
    ]

   

    let names =
        students |> List.map (fun s -> s.Name.ToUpper())

    printfn "Student Names: %A" names


    let eligible =
        students |> List.filter (fun s -> s.Age >= 18)

    printfn "Eligible Students:"
    eligible |> List.iter (fun s -> printfn "%s" s.Name)

    
    students |> List.iter (fun s ->
        printfn "%s: %s" s.Name (getCategory s.Age)
    )

    
    use con = new SqliteConnection("Data Source=students.db")
    con.Open()

    
    use table = con.CreateCommand()
    table.CommandText <-
        "CREATE TABLE IF NOT EXISTS Students
         (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER)"
    table.ExecuteNonQuery() |> ignore

    
    for s in students do
        use cmd = con.CreateCommand()
        cmd.CommandText <-
            "INSERT OR REPLACE INTO Students (Id, Name, Age)
             VALUES (@id, @name, @age)"

        cmd.Parameters.AddWithValue("@id", s.Id) |> ignore
        cmd.Parameters.AddWithValue("@name", s.Name) |> ignore
        cmd.Parameters.AddWithValue("@age", s.Age) |> ignore
        cmd.ExecuteNonQuery() |> ignore

    printfn "\n1. CREATE - Students inserted"

   
    printfn "\n2. READ - Student Records"
    displayStudents con

    
    use update = con.CreateCommand()
    update.CommandText <-
        "UPDATE Students SET Age = 21 WHERE Id = 1"
    update.ExecuteNonQuery() |> ignore

    printfn "\n3. UPDATE - Rahul's age updated"
    displayStudents con

    
    use delete = con.CreateCommand()
    delete.CommandText <- "DELETE FROM Students WHERE Id = 2"
    delete.ExecuteNonQuery() |> ignore

    printfn "\n4. DELETE - Aman removed"
    displayStudents con

    printfn "\nAll operations completed successfully!"
}

[<EntryPoint>]
let main argv =
    Async.RunSynchronously workflow
    0
