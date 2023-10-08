/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author minhh
 */
public class RegisterServlet extends HttpServlet {
    // tao 1 doi tung manage de cho phep truy cap vao listRole ben ManageAccount
    ManageAccount manage = new ManageAccount();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // manage truy cap vao listRole de hien thi ra User va Admin o Role khi chay
        request.setAttribute("listRole", manage.getListRole());
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        // lay du lieu tu form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String genderStr = request.getParameter("gender");
        boolean gender = genderStr.equalsIgnoreCase("male") ? true : false;
        int role = Integer.parseInt(request.getParameter("role"));
        
        Role roleObject = new Role();
        roleObject.setId(role);
        //Tao 1 doi tuong Account
        Account myAccount = new Account(username, password, gender, roleObject);

        //them doi tuong account vao ben trong collection
        ArrayList<Account> list = manage.getListAccount();
        list.add(myAccount);

        //lay ve  collection va set vao request
        request.setAttribute("listRole", manage.getListRole());
        request.setAttribute("listAccount", manage.getListAccount());   //??????????????? getList
 
        // Chuyen den trang display.jsp de hien thi thong tin
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
