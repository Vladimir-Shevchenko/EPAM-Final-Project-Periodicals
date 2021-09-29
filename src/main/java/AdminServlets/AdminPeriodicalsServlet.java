package AdminServlets;

import Bean.Periodical;
import database.AdminPeriodicalsDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminPeriodicalsServlet", value = "/AdminPeriodicalsServlet")
public class AdminPeriodicalsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" i am AdminPeriodicalsServlet");
      List<Periodical> periodicalsAdminList = AdminPeriodicalsDao.getPeriodicals();

      request.getSession().setAttribute("periodicalsAdminList", periodicalsAdminList);

        response.sendRedirect("adminPeriodicals.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
