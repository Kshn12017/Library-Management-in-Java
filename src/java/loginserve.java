import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet(urlPatterns = {"/loginserve"})
public class loginserve extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            String name = request.getParameter("t1");
            String pass = request.getParameter("t2");
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Demonbase","app","app");
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("select * from Admins where Admin_Name='" +name+ "' AND Admin_Password='" +pass+ "'");
            
            if(rs.next()==true)
            {
                HttpSession ses = request.getSession();
            
                ses.setAttribute("name", name);
                ses.setAttribute("Pass", pass);
                
                response.sendRedirect("homeserve");
            }
            else
            {
                out.println("<script>\n"
                        + "  alert(\"Not an admin!\");\n"
                        + "</script>\n");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }
        }
        catch(Exception e)
        {
            out.print("Error in loginserve.aspx " + e);
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
