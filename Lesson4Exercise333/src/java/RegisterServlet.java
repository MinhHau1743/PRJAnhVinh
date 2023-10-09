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


/**
 *
 * @author minhh
 */
public class RegisterServlet extends HttpServlet {
    // tao 1 doi tuong trung gian la manage de truy cap vao listAccount
    ManageAccount manage = new ManageAccount();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // manage truy cap vao listRole de hien thi ra User va Admin o Role khi chay
        request.setAttribute("listRole", manage.getListRole());
        request.getRequestDispatcher("register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lay du lieu tu form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String genderStr = request.getParameter("gender");
        boolean gender = genderStr.equalsIgnoreCase("male") ? true : false;    
        int role = Integer.parseInt(request.getParameter("role")); 
        
        Role roleObject = new Role();// set Role thong qua id
        roleObject.setId(role);

        //   Tao 1 doi tuong Account
        Account myAccount = new Account(username, password, gender, roleObject);
        
        //   Them doi tuong Account vao ben trong Collection
        ArrayList<Account> list = manage.getListAccount();
        list.add(myAccount);
        
        //   Luu Collection vao request
        request.setAttribute("listRole", manage.getListRole());
        request.setAttribute("listAccount", manage.getListAccount());
        
        // chuyen den trang display.jsp de hien thi thong tin
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
