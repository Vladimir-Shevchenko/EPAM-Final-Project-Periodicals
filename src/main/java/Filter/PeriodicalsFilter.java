package Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/PeriodicalServlet")
public class PeriodicalsFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
     //   if(session.getAttribute("username")!=null) {
//            response.setContentType("text/html; charset=UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            request.setCharacterEncoding("UTF-8");

            chain.doFilter(request, response);
       // }else {

           // resp.sendRedirect("login.jsp");
           // }

    }
}
