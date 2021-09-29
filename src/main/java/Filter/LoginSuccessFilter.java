package Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/loginSuccess.jsp")
public class LoginSuccessFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
     //   response.setContentType("text/html; charset=UTF-8");

        // response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        System.out.println("I AM DO FILTER");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if(session.getAttribute("username")!=null) {
            chain.doFilter(request, response);
        }else {
            resp.sendRedirect("login.jsp");}
    }
    }

