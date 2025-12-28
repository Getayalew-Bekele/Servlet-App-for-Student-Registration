<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h1>Register a Student</h1>
    <form action="addStudent" method="post">
        <label>ID:</label>
        <input type="number" name="id" required><br><br>

        <label>Name:</label>
        <input type="text" name="name" required><br><br>

        <label>Email:</label>
        <input type="email" name="email" required><br><br>

        <label>Year:</label>
        <input type="number" name="year" required><br><br>

        <input type="submit" value="Register Student">
    </form>
</body>
</html>
