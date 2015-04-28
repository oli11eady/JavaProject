package com.mycompany.programmingproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class regiServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            SimpleDataSource.init();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            if (loginServlet.checkUser(request.getParameter("user1"), request.getParameter("pass1")) == true){
                try (PrintWriter out = response.getWriter())
                {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<link rel=\"stylesheet\" href=\"style.css\">");
                    out.println("<title>Improve your German</title>");
                    out.println("<body>   \n" +
                            "        <div id=\"header\">\n" +
                            "            <div id=\"menu\">\n" +
                            "                    <ul>\n" +
                            "                        <li><a href=\"#welcome\">Home</a></li>\n" +
                            "                        <li><a href=\"#test\">Test</a></li>\n" +
                            "                        <li><a href=\"#grades\">Grades</a></li>\n" +
                            "                        <li><a href=\"#adddrop\">Admin</a></li>\n" +
                            "                    </ul>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div id=\"container\">\n" +
                            "            <div id=\"inner\"> \n" +
                            "                <div id=\"content\">\n" +
                            "                    <div id=\"login\">\n" +
                            "                    <h3>The user: " + request.getParameter("user1") + " already exists</h3>\n" +
                            "                    </div>\n" +
                            "                    <div id=\"back\"><a href=\"register.html\">Click here to return</a></div>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "    </body>\n" +
                            "</html>");
                }
            }
            else if(loginServlet.checkUser(request.getParameter("user1"), request.getParameter("pass1"))== false){
                try (PrintWriter out = response.getWriter())
                {
                    /* TODO output your page here. You may use following sample code. */
                    createUser(request.getParameter("user1"), request.getParameter("pass1"));
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<link rel=\"stylesheet\" href=\"style.css\">");
                    out.println("<title>Improve your German</title>");
                    out.println("<body>   \n" +
                            "        <div id=\"header\">\n" +
                            "            <div id=\"menu\">\n" +
                            "                    <ul>\n" +
                            "                        <li><a href=\"#welcome\">Home</a></li>\n" +
                            "                        <li><a href=\"#test\">Test</a></li>\n" +
                            "                        <li><a href=\"#grades\">Grades</a></li>\n" +
                            "                        <li><a href=\"#adddrop\">Admin</a></li>\n" +
                            "                    </ul>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div id=\"container\">\n" +
                            "            <div id=\"inner\"> \n" +
                            "                <div id=\"content\">\n" +
                            "                    <div id=\"login\">\n" +
                            "                    <h3>The user: " + request.getParameter("user1") + " has been created</h3>\n" +
                            "                    </div>\n" +
                            "                    <div id=\"back\"><a href=\"register.html\">Click here to return</a></div>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "    </body>\n" +
                            "</html>");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public static void createUser(String userName, String userPass) throws SQLException{
               
        String QUERY = "INSERT INTO user (user_id, user_name, user_pass, `status`) VALUES('" + userName + "','" + userPass + "', 'student');";

        try{
            Connection conn = SimpleDataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY); 
        
            while(rs.next()){
                String user = rs.getString("user_name");
                System.out.println("Name: "+user);
                
            }
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
            
        }
    }

    
}
