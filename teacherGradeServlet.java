package com.mycompany.javamainproject;

import static com.mycompany.javamainproject.loginServlet.check;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class teacherGradeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/german?zeroDateTimeBehavior=convertToNull";

        //  Database credentials
        final String USER = "root";
        final String PASS = "";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //String title = "Database Result";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT user_name, home_and_abroad_grade, education_and_employment_grade, "
                    + "home_daily_grade, modern_world_grade, social_fitness_health_grade, "
                    + "non_specific_grade, random_grade FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name 
                String user_name = rs.getString("user_name");
                int homeAndAbroad = rs.getInt("home_and_abroad_grade");
                int educationAndEmployment = rs.getInt("education_and_employment_grade");
                int homeDaily = rs.getInt("home_daily_grade");
                int modernWorld = rs.getInt("modern_world_grade");
                int socialFitnessHealthGrade = rs.getInt("social_fitness_health_grade");
                int nonSpecific = rs.getInt("non_specific_grade");
                int random = rs.getInt("random_grade");

                //Display values
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<link rel=\"stylesheet\" href=\"style.css\">\n"
                        + "    <title>\n"
                        + "        Improve your German\n"
                        + "    </title>\n"
                        + "    <body>   \n"
                        + "        <div id=\"header\">\n"
                        + "            <div id=\"menu\">\n"
                        + "                    <ul>\n"
                        + "                        <li><a href=\"#welcome\">Home</a></li>\n"
                        + "                        <li><a href=\"#test\">Test</a></li>\n"
                        + "                        <li><a href=\"#grades\">Grades</a></li>\n"
                        + "                        <li><a href=\"#adddrop\">Admin</a></li>\n"
                        + "                    </ul>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        <div id=\"container\">\n"
                        + "            <div id=\"inner\"> \n"
                        + "                <div id=\"content\">\n"
                        + "                <div id=\"grades\">\n"
                        + "                    <h3> Teachers Class Grades </h3><br/>\n"
                        + "                    </div>\n"
                        + "                    <br/>\n"
                        + "                        <div class=\"gradesTable\" >\n"
                        + "                          <table >\n"
                        + "                              <tr>\n"
                        + "                                  <td>"
                        + "                                      Student ID\n"
                        + "                                  </td>\n"
                        + "                                  <td >\n"
                        + "                                      Grades\n"
                        + "                                  </td>\n"
                        + "                              </tr>\n"
                        + "                              <tr>\n"
                        + "                                  <td >\n"
                        + "                                      student001\n"
                        + "                                  </td>\n"
                        + "                                  <td>\n"

                        + "                                      <form action=\"GradesPage.html\">\n" 
                        + "                                 <input type=\"submit\" value=\"View Grades\">\n" +"</form>"
                        + "                                  </td>\n"
                        + "                              </tr>\n"
                        + "                              <tr>\n"
                        + "                                  <td >\n"
                        + "                                      student002\n"
                        + "                                  </td>\n"
                        + "                                  <td>\n"
                        + "                                      <form action=\"GradesPage.html\">\n" 
                        + "                                 <input type=\"submit\" value=\"View Grades\">\n" +"</form>"
                        + "                                  </td>\n"
                        + "                              </tr>\n"
                        + "                              <tr>\n"
                        + "                                  <td >\n"
                        + "                                     student003\n"
                        + "                                  </td>\n"
                        + "                                  <td>\n"
                        + "                                      <form action=\"GradesPage.html\">\n" 
                        + "                                 <input type=\"submit\" value=\"View Grades\">\n" +"</form>"
                        + "                                  </td> \n"
                        + "                          </table>\n"
                        + "                      </div>\n"
                        + "                      <br/><br/>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        </div>\n"
                        + "    </body>\n"
                        + "</html>");

                // Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }
        }
        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally {
         //finally block used to close resources
            //end try
        }
        } 
    
}
