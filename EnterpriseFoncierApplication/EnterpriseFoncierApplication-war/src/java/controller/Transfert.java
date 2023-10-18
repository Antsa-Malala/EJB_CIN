/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBean.TransfertRemote;

/**
 *
 * @author Antsa
 */
public class Transfert extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           String numCompte1=(String)request.getParameter("numCompte1");
           String numCompte2=(String)request.getParameter("numCompte2");
           double somme=Double.valueOf(request.getParameter("somme"));
           int iddevise=Integer.valueOf(request.getParameter("iddevise"));
           
           String date=request.getParameter("dateEnvoie");
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
           LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
           Timestamp envoie=Timestamp.valueOf(localDateTime);
           
           Properties p = new Properties();
           p.setProperty("org.com.CORBA.ORBInitialHost", "localhost");
           p.setProperty("org.com.CORBA.ORBInitialPort", "3700");
           InitialContext ps=new InitialContext(p);
           TransfertRemote ta=(TransfertRemote)ps.lookup("java:global/EntrepriseBanqueApplication/EjbBanque/Transfert!sessionBean.TransfertRemote");
           ta.insertTransfert(numCompte1,numCompte2,somme,iddevise,envoie);
           request.setAttribute("error","Transfert effectue");
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);
        }
        catch(Exception e)
        {
            request.setAttribute("error",e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);
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
