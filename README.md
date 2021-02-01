# employee-pacewisdom

This project is based on Spring Boot Framework.
I did all the requirement of Second Assessment.
I have used H2 database to store the data.

Note : Kindly use PostMan tool to test this project.

  Task 1: Create a new Empolyee.
   http://localhost:8081/addEmployee?id=1&firstName=Seenu&lastName=Chandran&emailId=seenu.chandar@gmail.com&age=23&gender=Male&address=Komarapalayam

  Task 2: Update a existing Empolyee(all attributes).
  http://localhost:8081/updateExistingEmployeeById?id=1&firstName=Seenivasan

  Task 3: Get all empolyees (and) get one employee.
  http://localhost:8081/getAllEmployees
  http://localhost:8081/getEmployeeById?&id=2

  Task 4: Delete an employee.(prefered soft delete)
  http://localhost:8081/deleteEmployeeById?&id=2
