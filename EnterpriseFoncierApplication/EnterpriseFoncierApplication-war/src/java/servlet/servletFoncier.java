/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.BanqueDTO;
import dto.CompteDTO;
import dto.TransactionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBean.BanqueRemote;

/**
 *
 * @author Antsa
 */
public class servletFoncier extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /*Properties p = new Properties();
            p.setProperty("org.com.CORBA.ORBInitialHost", "localhost");
            p.setProperty("org.com.CORBA.ORBInitialPort", "3700");
            InitialContext ps=new InitialContext(p);
            TanyRemote ta=(TanyRemote)ps.lookup("java:global/EnterpriseFoncierApplication/EjbFoncier/Tany!sessionBean.TanyRemote");
            ArrayList<String> list=(ArrayList<String>)ta.liste_tany("postgres");
            for(int i=0;i<list.size();i++)
            {
                out.println(list.get(i));
            }*/
            Properties p = new Properties();
            p.setProperty("org.com.CORBA.ORBInitialHost", "localhost");
            p.setProperty("org.com.CORBA.ORBInitialPort", "3700");
            InitialContext ps=new InitialContext(p);
            BanqueRemote ta=(BanqueRemote)ps.lookup("java:global/EntrepriseBanqueApplication/EjbBanque/Banque!sessionBean.BanqueRemote");
            ArrayList<BanqueDTO> list=ta.getSolde("1234567890");
            for(int i=0;i<list.size();i++)
            {
                
            }
        }
         catch(Exception e)
        {
            e.printStackTrace();
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
