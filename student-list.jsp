<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Student" %>
<% List<Student> students = (List<Student>) request.getAttribute("students"); %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Student List</h2>

        <% if (students == null || students.isEmpty()) { %>
            <p>No students found.</p>
        <% } else { %>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Roll Number</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Branch</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Student student : students) { %>
                        <tr>
                            <td><%= student.getRollNumber() %></td>
                            <td><%= student.getFirstName() %> <%= student.getLastName() %></td>
                            <td><%= student.getPhoneNumber() %></td>
                            <td><%= student.getEmail() %></td>
                            <td><%= student.getBranchName() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</body>
</html>