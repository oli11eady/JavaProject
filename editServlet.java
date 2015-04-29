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

public class editServlet extends HttpServlet {
    
    
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
        
        String english = request.getParameter("english");
        String german = request.getParameter("german");
        
        try {
            SimpleDataSource.init();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            if (addServlet.checkWord(request.getParameter("english"), request.getParameter("german")) == true){
                try (PrintWriter out = response.getWriter())
                {
                    /* TODO output your page here. You may use following sample code. */
                    dropServlet.dropWord(german, english);
                    addServlet.addWord(request.getParameter("newGerman"), request.getParameter("newEnglish"), request.getParameter("newCatagory"), request.getParameter("newSub"), request.getParameter("newGender"));
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
                            "                    <h3>The word: " + request.getParameter("german") + " / " + request.getParameter("english") + " has been edited.</h3>\n" +
                            "                    </div>\n" +
                            "                    <div id=\"back\"><a href=\"edit.html\">Click here to return</a></div>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "    </body>\n" +
                            "</html>");
                }
            }
            else if(addServlet.checkWord(request.getParameter("english"), request.getParameter("german")) == false || addServlet.checkWord(request.getParameter("newEnglish"), request.getParameter("newGerman"))== false){
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
                            "                    <div id=\"loginb\">\n" +
                            "                    <h3>Invalid request please try again.</h3>\n" +
                            "                    </div>\n" +
                            "                  <div id=\"back\"><a href=\"edit.html\">Click here to return</a></div>\n" +
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

    
}
