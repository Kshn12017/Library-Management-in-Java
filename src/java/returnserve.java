/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kshit
 */
@WebServlet(urlPatterns = {"/returnserve"})
public class returnserve extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
         HttpSession ses = request.getSession(true);
            
            if(ses.getAttribute("name")!=null)
            {
                out.println("<html>\n "
                    + "<head>\n"
                    + "<title> Home Page</title>\n"
                        
                        
                    + "    <style type=\"text/css\">\n"
                    + "        .auto-style1 {\n"
                    + "            width: 100%;\n"
                    + "            color: white;\n"
                    + "            background-color: black;\n"
                    + "        }\n"
                    + "        #footer{\n"
                    + "            background-color: #9b2b2b;\n"
                    + "            bottom:0px;\n"
                    + "            position: fixed;\n"
                    + "        }\n"
                    + "        .auto-style3 {\n"
                    + "            width: 1000px;\n"
                    + "        }\n"
                    + "        .auto-style4 {\n"
                    + "            left: -4px;\n"
                    + "            bottom: 38px;\n"
                    + "            width: 1832px;\n"
                    + "        }\n"
                    + "        a:link {\n"
                    + "            color: white;\n"
                    + "            background-color: transparent;\n"
                    + "            text-decoration: none;\n"
                    + "        }\n"
                    + "        a:hover {\n"
                    + "            text-decoration: underline;\n"
                    + "        }\n"
                    + "       p{\n"
                    + "       color:white;\n"
                    + "  }\n"
                    + "   .auto-style5 {\n"
                    + "        width: 50px;\n"
                    + "      }\n"
                    + "  .auto-style6 {\n"
                    + " width: 100%;\n"
                    + "     height: 500px;\n"
                    + "   }\n"
                    + "   .form{\n"
                    + "     text-align: center;\n"
                    + "       width: 300px;\n"
                    + "   }\n"
                    + "   .center {\n"
                    + "    display: block;\n"
                    + "      margin-left: auto;\n"
                    + "      margin-right: auto;\n"
                    + "       width: 50%;\n"
                    + "   }\n"
                    + "   .background{\n"
                    + "      background-image: url(\"booksbg.jpg\");\n"
                    + "     background-size: 520px 520px;\n"
                    + "      height: 520px;\n"
                    + "      width: 100%;\n"
                    + "   }\n"
                    + "   .right{\n"
                    + "      text-align: right;\n"
                    + "   }\n"
                    + "   </style>\n"                        
                    + "</head>\n"
                    + "<body>\n"
                    + " <table class=\"auto-style1\">\n"
                    + "   <tr>\n"
                    + "  <td class=\"auto-style5\">\n"
                    + "      <img src=\"Logo.jpg\" width=\"40\" height=\"40\" alt=\"Logo\"/>\n"
                    + "  </td>\n"
                    + "    <td>\n"
                    + "  <p style=\"color: white; font-size: 35px\">&nbsp; Demonic Library</p>\n"
                    + "    </td>\n"
                    + "     <td class=\"right\">\n"
                    + ses.getAttribute("name")
                    + "  </td>\n"
                    + "  <td class=\"auto-style5\">\n"
                    + "       <img src=\"chibikei.png\" alt=\"chibikei\" height=\"50px\" Width=\"50px\"/>\n"
                    + "     </td>\n"
                    + "    </tr>\n"
                    + " </table>\n"
                        + ""
                        + "<form action=\"returnserve\" method=\"post\">"
                        + "<table class=\"auto-style6\">\n"
                        + "<tr>\n"
                        + "<td>\n"
                        + "  <table style=\"height: 258px; width: 700px; text-align: center\">\n"
                        + "     <tr style=\"height: 55px\">\n"
                        + "     <td><h3>Return Book:</h3></td>\n"
                        + "      </tr>\n"
                        + " <tr style=\"height: 55px\">\n"
                        + "     <td style=\"height: 55px\">Book ID:</td>\n"
                        + "   <td>\n"
                        + "                     <input type=\"text\" name=\"t1\" value=\"\" required/>\n"
                        + "     </td>\n"
                        + "  </tr>\n"
                        + "  <tr style=\"height: 55px\">\n"
                        + "    <td style=\"width: 250px\">Student Name:</td>\n"
                        + "  <td>\n"
                        + "  <input type=\"text\" name=\"t2\" value=\"  \" />\n"
                        + "</td>\n"
                        + " </tr>\n"
                        + "   <tr style=\"height: 55px\">\n"
                        + "   <td style=\"width: 250px\">Roll No.:</td>\n"
                        + "   <td>\n"
                        + "                <input type=\"text\" name=\"t3\" value=\"\" />\n"
                        + "   </td>\n"
                        + "   </tr>\n"
                        + " <tr style=\"height: 55px\">\n"
                        + "     <td>Class: </td>\n"
                        + "  <td>\n"
                        + "               <input type=\"text\" name=\"t4\" value=\"\" />\n"
                        + "     </td>\n"
                        + "   </tr>\n"
                        + " <tr style=\"height: 55px\">\n"
                        + " <td style=\"width: 250px\">Returned By:</td>\n"
                        + " <td>\n"
                        + "            <input type=\"text\" name=\"t5\" value=\"\" />\n"
                        + "  </td>\n"
                        + "  </tr>\n"

                        + "   <td></td>\n"
                        + "  <td style=\"text-align: center\">\n"
                        + "                 <input type=\"submit\" name=\"b1\" value=\"Return\" />\n"
                        + "    </td>\n"
                        + "   </tr>\n"
                        + "   </table>\n"
                        + "</form>"
                        + "   </td>  \n"
                        + "    <td>  \n"
                        + "    <ul>  \n"
                        + "  <li>  \n"
                        + "   <a href=\"homeserve\" >Home</a>  \n"
                        + "  <ul>  \n"
                        + "  <li>  \n"
                        + "  <a href=\"manage\" >Manage</a>  \n"
                        + "    </li>  \n"
                        + " <li>  \n"
                        + "     <a href=\"issueserve\" >Issue Book</a>  \n"
                        + "   </li>  \n"
                        + "    <li>  \n"
                        + "       <a href=\"returnserve\" >Return Book</a>  \n"
                        + "    </li>  \n"
                        + "    <li>  \n"
                        + "      Lists  \n"
                        + "        <ul>  \n"
                        + "          <li>  \n"
                        + "          <a href=\"booklist\" >Book List</a>  \n"
                        + "          </li>  \n"
                        + "         <li>  \n"
                        + "     <a href=\"issuedbooks\" >Issued Books</a>  \n"
                        + " </li>  \n"
                        + "  <li>  \n"
                        + "   <a href=\"returnbooks\" >Returned Books</a>  \n"
                        + " </li>  \n"
                        + " </li>  \n"
                        + "  </ul>  \n"
                        + "   </li>  \n"
                        + "   </ul>  \n"
                        + "     </td>  \n"
                        + "</tr>\n"
                        + " </table>"


                    + "  <div id=\"footer\" class=\"auto-style4\">\n"
                    + "<table class=\"auto-style1\">\n"
                    + "  <tr>\n"
                    + "     <td class=\"auto-style3\">\n"
                    + "   <p>&nbsp;&nbsp; Copyrights Reserved</p>\n"
                    + "  </td>\n"
                    + "  <td>\n"
                    + "    <p>Contact: <a href=\"mailto:tiwarikshvait20@student.mes.ac.in\">Kshitiz Tiwari</a></p>\n"
                    + " </td>\n"
                    + "   </tr>\n"
                    + " </table>\n"
                    + "   </div>\n"
                    + "</body>\n"
                    + "</html>\n");
                
                String bid = request.getParameter("t1");
                String name = request.getParameter("t2");
                String roll = request.getParameter("t3");
                String clas = request.getParameter("t4");
                String returner = request.getParameter("t5");
                
                if(request.getParameter("b1")!=null)
                {
                    try
                    {
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                         Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Demonbase","app","app");
                         Statement stat = conn.createStatement();
                          
                         stat.executeUpdate("insert into ReturnBook values("+bid+",'"+name+"', "+roll+",'"+clas+"','"+returner+"')");
                         stat.executeUpdate("delete from IssueBook where Book_ID="+bid+" AND Roll_No="+roll);
                         
                         out.println("<script>\n"
                        + "  alert(\"Book Returned!\");\n"
                        + "</script>\n");
                         
                    }
                    catch(Exception e)
                    {
                        out.println("Error in click.");
                    }
                }
        }
            else
            {
                out.println("<script> alert(\"Please log in first!\"); </script>");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }
        }
        catch(Exception e)
        {
            out.println("Error in 1st try  ");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
