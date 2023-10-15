/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minhh
 */
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //khia bao ỦL chuyen den
        String url = "";
        // khai bao lop DAO
        AccountDAO accountDAO = new AccountDAO();
        // khai bao Array List
        List<Account> list = new ArrayList<>();
        // Get ve Action
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        System.out.println("ehllo------------------------:"+  action);
        // Dua tren gia tri Action
        switch (action) {
            case "login":
                url = login(request, url);
                System.err.println("Account la : ");
                break;
            default:
                list = accountDAO.findAll();
                url = "display.jsp";
                System.err.println("Account la : ");
                break;
        }
        System.out.println(url);
        // Set Array List vao trong Request
        request.setAttribute("listAccount", list);
        // Chuyen qua trang display.jsp
        request.getRequestDispatcher(url).forward(request, response);

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

    private String login(HttpServletRequest request, String url) {
        // khai bao DAO
        AccountDAO accountDAO = new AccountDAO();

        // lay Username, password 
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // kiem tra Username va password co trong Database
        Account account = accountDAO.findByUsernameOrPassword(username, password);
        System.err.println("Account la : " + account);
        // Dang nhap thanh cong, chuyen den trang thanhcong.jsp
        if (account != null) {
            url = "thanhcong.jsp";
        } else {
            request.setAttribute("error", "Username or Password is INCORRECT");
            url = "login.jsp";
            System.out.println("hellolo");
        }
        return url;
    }

}
