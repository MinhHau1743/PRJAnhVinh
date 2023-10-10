/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author minhh
 */
public class HomeServlet extends HttpServlet {

    ManageAccount manage = new ManageAccount();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //lay ve keyword
        String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
        // lay ve danh sach listAccount dua tren keyword
        ArrayList<Account> list = manage.findByKeyword(keyword);
        // set listAccount vao request
        request.setAttribute("listAccount", list);
        // chuyen qua trang display.jsp
        request.getRequestDispatcher("display.jsp").forward(request, response);
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
        //get ve username ma nguoi dung muon xoa
        String username = request.getParameter("username");
        //tim account dua tren username ma nguoi dung muon xoa
        Account account = manage.findByUsername(username);
        //xoa account
        manage.removeAccount(account);
        //quay tro ve do Get cua home servlet
        response.sendRedirect("home");
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
