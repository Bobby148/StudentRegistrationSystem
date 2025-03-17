package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentDAO {

    public boolean addStudent(Student student, int branchId) throws SQLException {
        String sql = "INSERT INTO students (roll_number, first_name, last_name, phone_number, email, password, branch_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getRollNumber());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getLastName());
            stmt.setString(4, student.getPhoneNumber());
            stmt.setString(5, student.getEmail());
            stmt.setString(6, student.getPassword()); 
            stmt.setInt(7, branchId);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.roll_number, s.first_name, s.last_name, s.phone_number, s.email, b.branch_name " +
                     "FROM students s INNER JOIN branches b ON s.branch_id = b.branch_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getString("roll_number"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getString("branch_name")
                ));
            }
        }
        return students;
    }

    public List<Student> getStudentsByBranch(String branchName) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.roll_number, s.first_name, s.last_name, s.phone_number, s.email, b.branch_name " +
                     "FROM students s INNER JOIN branches b ON s.branch_id = b.branch_id WHERE b.branch_name = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, branchName);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    students.add(new Student(
                            rs.getString("roll_number"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getString("branch_name")
                    ));
                }
            }
        }
        return students;
    }

    public boolean validateStudentLogin(String email, String password) throws SQLException {
        String sql = "SELECT password FROM students WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");

                    return password.equals(storedPassword); 
                }
            }
        }
        return false;
    }
}

