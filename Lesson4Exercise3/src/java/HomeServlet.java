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
        ArrayList<Role> listRole = manage.getListRole();
        // set listAccount vao request
        request.setAttribute("listAccount", list);
        request.setAttribute("listRole", listRole);
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

        String action = request.getParameter("action") == null ? "" : request.getParameter("action");;
        switch (action) {
            case "delete":
                delete(request);
                break;
            case "add":
                add(request);
                break;
            default:
                break;
        }

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

    private void delete(HttpServletRequest request) {
        //get ve username ma nguoi dung muon xoa
        String username = request.getParameter("username");
        //tim account dua tren username ma nguoi dung muon xoa
        Account account = manage.findByUsername(username);
        //xoa account
        manage.removeAccount(account);
    }

    private void add(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String genderStr = request.getParameter("gender");
        boolean gender = genderStr.equalsIgnoreCase("male") ? true : false;
        int roleId = Integer.parseInt(request.getParameter("role"));
        
        Role roleObject = manage.findRoleById(roleId);
        //Tao 1 doi tuong Account
        Account myAccount = new Account(username, password, gender, roleObject);
        
        //them doi tuong account vao ben trong collection
        manage.addAccount(myAccount);
        
        
    }

}
