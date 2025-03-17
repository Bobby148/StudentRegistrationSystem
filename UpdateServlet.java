package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.DBConnection;
import com.model.Student;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");

	        if (action == null) {
	            action = "deleteAll"; 
	        }
	        List<Student> students = new ArrayList<>();

	        try (Connection conn = DBConnection.getConnection()) {
	            if (conn == null) {
	                return;
	            }

	            String sql;
	            PreparedStatement stmt;

	            if (action.equals("deleteAll")) {
	                sql = "DELETE FROM students;";
	                stmt = conn.prepareStatement(sql);
	            } else if (action.equals("CSE") || action.equals("ECE") || action.equals("EEE") || action.equals("MECH") || action.equals("CIVIL")) { 
	                sql = "DELETE s FROM students s INNER JOIN branches b ON s.branch_id = b.branch_id WHERE b.branch_name = ?";
	                stmt = conn.prepareStatement(sql);
	                stmt.setString(1, action);
	                System.out.println("Executing SQL: " + sql);
	            } else {
	                request.setAttribute("errorMessage", "Invalid action.");
	                request.getRequestDispatcher("error.jsp").forward(request, response);
	                return;
	            }


	            

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
	            request.getRequestDispatcher("login.jsp").forward(request, response);

	        } catch (SQLException e) {
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String password = request.getParameter("password");
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "Update students set password = (?) where first_name = (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, password);
            stmt.executeUpdate();

            response.sendRedirect("login.jsp?message=Updated successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
