package PeriodicalsServlets;

import database.AddOrderDao;
import database.MoneyDao;
import database.ReplenishDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ThankyouServlet", value = "/ThankyouServlet")
public class ThankyouServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

       String periodical_id =  (String) session.getAttribute("idConfirm");
       String username =  (String) session.getAttribute("username");

     String price_ =  (String)session.getAttribute("priceConfirm");
     price_ = price_.substring(0,price_.length()-1);
        System.out.println("price_   "+price_);
        int price=Integer.parseInt(price_);

     int myMoney = MoneyDao.getMoney(username);

       if(myMoney>=price) {
           MoneyDao.updateMoney((myMoney-price)+"",username);
           AddOrderDao.insertOrder(periodical_id, username);
//        session.getAttribute("nameConfirm");
//
//        session.getAttribute("typeConfirm");
//        session.getAttribute("descriptionConfirm");

           response.sendRedirect("thankyou.jsp");
       }else {response.getWriter().println("Its not enough money! Please replenish your bill!");}

    }





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
