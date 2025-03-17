<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Welcome, Admin</h2>
        <div class="d-grid gap-2 mt-3">
            <a href="StudentServlet?action=viewAll" class="btn btn-success">View All Students</a>
            <a href="StudentServlet?action=CSE" class="btn btn-info">View CSE Students</a>
            <a href="StudentServlet?action=ECE" class="btn btn-warning">View ECE Students</a>
            <a href="StudentServlet?action=EEE" class="btn btn-success">View EEE Students</a>
            <a href="StudentServlet?action=MECH" class="btn btn-info">View MECH Students</a>
            <a href="StudentServlet?action=CIVIL" class="btn btn-warning">View CIVIL Students</a>
            <a href="register.jsp" class="btn btn-primary">Register New Student</a>
            <a href="update.jsp" class="btn btn-success">Update Student Details</a>
            <a href="delete.jsp" class="btn btn-info">Delete Student Details</a>
        </div>
    </div>
</body>
</html>