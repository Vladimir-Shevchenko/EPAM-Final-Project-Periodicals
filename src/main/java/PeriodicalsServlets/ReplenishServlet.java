package PeriodicalsServlets;

import database.ReplenishDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReplenishServlet", value = "/ReplenishServlet")
public class ReplenishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.sendRedirect("replenish.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String amount = (String)request.getParameter("amount");
       String username = (String)request.getSession().getAttribute("username");
        ReplenishDao.replenish(amount, username);

        response.sendRedirect("successPayment.jsp");
    }
}
