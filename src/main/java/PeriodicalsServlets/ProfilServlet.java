package PeriodicalsServlets;

import Bean.Periodical;
import database.MoneyDao;
import database.ProfilDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProfilServlet", value = "/ProfilServlet")
public class ProfilServlet extends HttpServlet {

    static List<Periodical> myOrderslist=new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
       String username = (String)session.getAttribute("username");

        myOrderslist = ProfilDao.getMyPeriodicals(username);
int money = MoneyDao.getMoney(username);


        session.setAttribute("myOrderslist", myOrderslist);
        session.setAttribute("money", money);

        response.sendRedirect("profil.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
