<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Register New Student</h2>
        <form action="RegisterServlet" method="post" onsubmit="return validatePasswords()">
            <div class="mb-3">
                <label>Roll Number:</label>
                <input type="number" name="rollNumber" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>First Name:</label>
                <input type="text" name="firstName" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Last Name:</label>
                <input type="text" name="lastName" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Phone Number:</label>
                <input type="text" name="phoneNumber" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Email:</label>
                <input type="email" name="email" class="form-control" required>
            </div>
              <div class="mb-3">
                <label>Branch ID:</label>
                <input type="number" name="brachid" class="form-control"  min="1" max="5" required>
            </div>
            <div class="mb-3">
                <label>Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Confirm Password:</label>
                <input type="password" id="confirmPassword" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Register</button>
        </form>
    </div>
    <script src="js/script.js"></script>
</body>
</html>

