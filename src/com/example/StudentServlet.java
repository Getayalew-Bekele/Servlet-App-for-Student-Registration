package com.example;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/studentdb";
    private static final String JDBC_USER = "root";       // change as needed
    private static final String JDBC_PASS = "maria123";   // change as needed

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form parameters
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String yearStr = request.getParameter("year");

        try {
            int id = Integer.parseInt(idStr);
            int year = Integer.parseInt(yearStr);

            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

            String sql = "INSERT INTO students (id, name, email, year) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setInt(4, year);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                out.println("<h2>Student registered successfully!</h2>");
                out.println("<p>ID: " + id + "</p>");
                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<p>Year: " + year + "</p>");
            } else {
                out.println("<h2>Failed to register student.</h2>");
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace(out);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<h2>GET request received at /addStudent</h2>");
}

}
