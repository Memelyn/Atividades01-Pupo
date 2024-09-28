/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorginho
 */
@WebServlet(urlPatterns = {"/random.html"})
public class RandomServlet extends HttpServlet {

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
        
         int n = 10;
        String errorMessage = null;
        
        try{
         n = Integer.parseInt(request.getParameter("n"));
        } catch(Exception ex){
            errorMessage = "Invalid Parameter";    
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Hello Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3> Randomized numbers </h3>");
            out.println("<form>");
            out.println("<input type='text' name='n' value='6' /> ");
            out.println("<input type='submit' name='random' value='Generate' /> ");
            out.println("</form>");
            out.println("<hr/>");
          
           
            if(errorMessage!=null){
            out.println("<h4 style='color:red'>"+errorMessage+"</h4>");
            }else{
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Index</th><th>Number</th>");
            out.println("</tr>");
                
            
            
            for (int i=1; i<=n; i++){
                out.println("<tr>");
                out.println("<th>" + i + "</th>");
                int r = ((int)(60*Math.random()));
                out.println("<td>"+r+"</td>");
                out.println("<tr>");
            }
            out.println("</table>");
           
            }  
            
            
            out.println("</body>");
            out.println("</html>");
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
