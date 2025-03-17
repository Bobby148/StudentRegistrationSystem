package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.DBConnection;
import com.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "viewAll"; 
        }

        List<Student> students = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                return;
            }

            String sql;
            PreparedStatement stmt;

            if (action.equals("viewAll")) {
                sql = "SELECT s.roll_number, s.first_name, s.last_name, s.phone_number, s.email, b.branch_name FROM students s INNER JOIN branches b ON s.branch_id = b.branch_id";
                stmt = conn.prepareStatement(sql);
            } else if (action.equals("CSE") || action.equals("ECE") || action.equals("EEE") || action.equals("MECH") || action.equals("CIVIL")) { 
                sql = "SELECT s.roll_number, s.first_name, s.last_name, s.phone_number, s.email, b.branch_name FROM students s INNER JOIN branches b ON s.branch_id = b.branch_id WHERE b.branch_name = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, action);
            } else {
                request.setAttribute("errorMessage", "Invalid action.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }


            System.out.println("Executing SQL: " + sql);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs != null) {
                    while (rs.next()) {
                        students.add(new Student(
                                rs.getString("roll_number"), rs.getString("first_name"), rs.getString("last_name"),
                                rs.getString("phone_number"), rs.getString("email"), rs.getString("branch_name")
                        ));
                    }
                } else {
                    return;
                }
            } catch (SQLException e) {
                return;
            }

            System.out.println("Number of students found: " + students.size());
            request.setAttribute("students", students);
            request.getRequestDispatcher("student-list.jsp").forward(request, response);

        } catch (SQLException e) {
        }
    }
}