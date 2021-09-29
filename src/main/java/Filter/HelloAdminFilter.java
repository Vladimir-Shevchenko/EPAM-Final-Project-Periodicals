package Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/helloAdmin.jsp")
public class HelloAdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println("I AM DO FILTER");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        System.out.println("sessssss    :  "+(String)session.getAttribute("username"));
       //String n = (String)session.getAttribute("username");
        if((String)session.getAttribute("username")!=null&&((String)session.getAttribute("username")).equals( "admin")) {
            chain.doFilter(request, response);
        }else {
            resp.sendRedirect("login.jsp");}
    }
}

