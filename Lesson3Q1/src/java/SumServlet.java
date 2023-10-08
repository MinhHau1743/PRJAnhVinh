
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;

/**
 *
 * @author minhh
 * 
 */import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        //lay ve du lieu cua number
        String numberRaw = request.getParameter("number");
        try {
            //chuyen tu kieu du lieu String sang kieu du lieu integer
            int number = Integer.parseInt(numberRaw);
            // kiem tra xem co > 1
            if (number <= 1) {
                request.setAttribute("error", "You input wrong");
            } else {
                // luu tru gia tri muon mang di vao trong request
                request.setAttribute("sum", calculatePrimeSum(number));
            }
            
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "You input wrong");
        }

        request.getRequestDispatcher("display.jsp").forward(request, response);

    }

    public static int calculatePrimeSum(int n) {
        int sum = 0;

        for (int num = 2; num < n; num++) {
            if (isPrime(num)) {
                sum += num;
                System.out.println(num);
            }
        }
        return sum;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return true; // sai o day ne, nay em viet la return false
            }
        }
        return false;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
