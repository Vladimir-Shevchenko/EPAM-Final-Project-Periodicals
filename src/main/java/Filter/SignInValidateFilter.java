package Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter( "/login")
public class SignInValidateFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;

       String username = request.getParameter("username");
       String password = request.getParameter("password");

    if (username.length() > 10 || username.length() < 1) {
        out.print("Invalid input! Username should contains 1 to 10 characters!");
    } else if (username.contains("\"") || username.contains("<") || username.contains(">")) {
        out.print("Invalid input! Username can't contains characters: \", <, >");
    } else if (password.contains("\"") || password.contains("<") || password.contains(">")) {
        out.print("Invalid input! Password can't contains characters: \", <, >");
    } else if (password.length() > 10 || password.length() < 1) {
        out.print("Invalid input! Password should contains 1 to 10 characters!");
    } else {
        chain.doFilter(request, response);
    }
}
//if(username.equals("admin")&&password.equals("admin")) {
//    RequestDispatcher rd=req.getRequestDispatcher("helloAdmin.jsp");
//    rd.include(req, response);
//}else{chain.doFilter(request, response);}

}
