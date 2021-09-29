package PeriodicalsServlets;

import Bean.Periodical;
import database.PeriodicalsDao;
import database.RegisterDao;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/PeriodicalServlet")
public class PeriodicalServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(PeriodicalServlet.class);
    static List<Periodical> list=new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//       response.setContentType("text/html; charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
////
//       request.setCharacterEncoding("UTF-8");

        List<Periodical> periodicalsList= PeriodicalsDao.getPeriodicals();
    list = periodicalsList;


if(request.getParameter("letter")!=null){
    String lett = request.getParameter("letter");
    list = periodicalsList.stream().filter(n->n.getName().startsWith(lett)).collect(Collectors.toList());
}


    HttpSession session = request.getSession();
        session.setAttribute("list", list);

     //   response.sendRedirect("/Periodicals/periodicals.jsp");
        request.getRequestDispatcher("periodicals.jsp").forward(request,response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        request.setCharacterEncoding("UTF-8");


        log.info("Это информационное сообщение!");

        List<Periodical> sortByNameList = new ArrayList<>();

                String search = request.getParameter("search_String");
        String option = request.getParameter("search_option");

        if(search!=null&&option!=null&&option.equals("Theme")) {
         sortByNameList = list.stream()
                    .filter(n -> n.getName().contains(search))
                    .sorted(Comparator.comparing(Periodical::getType))
                    .collect(Collectors.toList());
        }//if


      else  if(search!=null&&option!=null&&option.equals("Title")) {
            sortByNameList = list.stream()
                    .filter(n -> n.getName().contains(search))
                    .sorted(Comparator.comparing(Periodical::getName))
                    .collect(Collectors.toList());
        }//if


        else  if(search!=null&&option!=null&&option.equals("Price")) {
            sortByNameList = list.stream()
                    .filter(n -> n.getName().contains(search))
                    .sorted(Comparator.comparing(Periodical::getPrice))
                    .collect(Collectors.toList());
        }//if


      else  if(search!=null) {
            sortByNameList = list.stream()
                    .filter(n -> n.getName().contains(search))
                    .sorted(Comparator.comparing(Periodical::getType))
                    .collect(Collectors.toList());
        }//if



        HttpSession session = request.getSession();
        session.setAttribute("list", sortByNameList);

        request.getRequestDispatcher("periodicals.jsp").forward(request, response);
    }
}
