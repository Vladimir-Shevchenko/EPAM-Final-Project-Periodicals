package Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/RegisterServlet")
public class RegisterValidateFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
     //   HttpServletRequest req = (HttpServletRequest) request;

        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if(uname.length()>10||uname.length()<1){out.print("Invalid input! Username should contains 1 to 10 characters!");}
        else  if(uname.contains("\"")||uname.contains("<")||uname.contains(">")){out.print("Invalid input! Username can't contains characters: \", <, >");}
        else  if(password.contains("\"")||password.contains("<")||password.contains(">")){out.print("Invalid input! Password can't contains characters: \", <, >");}
        else if(password.length()>10||password.length()<1){out.print("Invalid input! Password should contains 1 to 10 characters!");}

        else if(!email.contains("@")||email.length()<4){out.print("Invalid input! You put incorrect email!");}
        else  if(email.contains("\"")||email.contains("<")||email.contains(">")){out.print("Invalid input! Email can't contains characters: \", <, >");}
        else  if(phone.contains("\"")||phone.contains("<")||phone.contains(">")){out.print("Invalid input! Phone can't contains characters: \", <, >");}
        else if(phone.length()>15||phone.length()<1){out.print("Invalid input! Phone should contains 1 to 15 characters!");}


        else {chain.doFilter(request, response);}


    }
}
