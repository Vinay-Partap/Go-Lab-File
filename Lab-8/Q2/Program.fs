
open System
open Microsoft.Data.Sqlite
open MongoDB.Bson
open MongoDB.Driver

// ==========================================
// PART 1: SQLITE - RELATIONAL DATABASE
// ==========================================

let printSqliteStudents (connection: SqliteConnection) =
    use command = connection.CreateCommand()
    command.CommandText <- "SELECT Id, Name, Age FROM Students"

    use reader = command.ExecuteReader()

    printfn "Current SQLite Students:"

    if not (reader.Read()) then
        printfn "No students found."
    else
        // Print first row and all remaining rows
        let printRow () =
            printfn "ID: %d | Name: %s | Age: %d"
                (reader.GetInt32(0))
                (reader.GetString(1))
                (reader.GetInt32(2))

        printRow ()

        while reader.Read() do
            printRow ()


let sqliteCRUD () =
    printfn "\n========== SQLITE CRUD =========="

    use connection =
        new SqliteConnection("Data Source=students.db")

    connection.Open()

    // Create table
    use createTable = connection.CreateCommand()
    createTable.CommandText <-
        "CREATE TABLE IF NOT EXISTS Students
         (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER)"
    createTable.ExecuteNonQuery() |> ignore

    // Remove old sample record for repeatable execution
    use cleanup = connection.CreateCommand()
    cleanup.CommandText <- "DELETE FROM Students WHERE Id = 1"
    cleanup.ExecuteNonQuery() |> ignore

    // CREATE
    use insert = connection.CreateCommand()
    insert.CommandText <-
        "INSERT INTO Students (Id, Name, Age)
         VALUES (1, 'Rahul', 21)"
    insert.ExecuteNonQuery() |> ignore

    printfn "\n1. CREATE - Student inserted"
    printSqliteStudents connection

    // READ
    printfn "\n2. READ - Reading student records"
    printSqliteStudents connection

    // UPDATE
    use update = connection.CreateCommand()
    update.CommandText <-
        "UPDATE Students SET Name = 'Aman', Age = 22 WHERE Id = 1"
    update.ExecuteNonQuery() |> ignore

    printfn "\n3. UPDATE - Student updated"
    printSqliteStudents connection

    // DELETE
    use delete = connection.CreateCommand()
    delete.CommandText <- "DELETE FROM Students WHERE Id = 1"
    delete.ExecuteNonQuery() |> ignore

    printfn "\n4. DELETE - Student deleted"
    printSqliteStudents connection


// ==========================================
// PART 2: MONGODB - NOSQL DATABASE
// ==========================================

let printMongoStudents (collection: IMongoCollection<BsonDocument>) =
    let students =
        collection.Find(FilterDefinition<BsonDocument>.Empty).ToList()

    printfn "Current MongoDB Students:"

    if students.Count = 0 then
        printfn "No students found."
    else
        for student in students do
            printfn "%s" (student.ToJson())


let mongoCRUD () =
    printfn "\n========== MONGODB CRUD =========="

    // Connect to MongoDB
    let client = MongoClient("mongodb://localhost:27017")

    let database = client.GetDatabase("Lab8DB")

    let collection =
        database.GetCollection<BsonDocument>("Students")

    // Filter student by ID
    let filter =
        Builders<BsonDocument>.Filter.Eq("_id", BsonInt32(1))

    // Remove old sample record for repeatable execution
    collection.DeleteOne(filter) |> ignore

    // CREATE
    let student = BsonDocument()
    student.Add("_id", BsonInt32(1))
    student.Add("name", BsonString("Rahul"))
    student.Add("age", BsonInt32(21))

    collection.InsertOne(student)

    printfn "\n1. CREATE - Student inserted"
    printMongoStudents collection

    // READ
    printfn "\n2. READ - Reading student records"
    let foundStudent = collection.Find(filter).FirstOrDefault()

    if isNull foundStudent then
        printfn "Student not found."
    else
        printfn "%s" (foundStudent.ToJson())

    printMongoStudents collection

    // UPDATE
    let update =
        Builders<BsonDocument>.Update
            .Set("name", BsonString("Aman"))
            .Set("age", BsonInt32(22))

    collection.UpdateOne(filter, update) |> ignore

    printfn "\n3. UPDATE - Student updated"
    printMongoStudents collection

    // DELETE
    collection.DeleteOne(filter) |> ignore

    printfn "\n4. DELETE - Student deleted"
    printMongoStudents collection


// ==========================================
// MAIN FUNCTION
// ==========================================

[<EntryPoint>]
let main argv =

    sqliteCRUD ()

    mongoCRUD ()

    printfn "\nAll CRUD operations completed successfully!"

    0
