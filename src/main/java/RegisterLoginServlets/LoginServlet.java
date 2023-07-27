package RegisterLoginServlets;
import Bean.LoginBean;
import database.LoginDao;
import database.RegisterDao;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(LoginServlet.class);
String cat = "meow";
String dog = "woof";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username = request.getParameter("username");
      if(username!=null) { request.setAttribute("un", username);}

String sss = "\u041a\u0430\u0442\u0430\u043b\u043e\u0433";
        String lang = request.getParameter("lan");
        request.getSession().setAttribute("lang",lang );
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username!=null){
        request.setAttribute("un", username);

        if(username.equals("admin")&&password.equals("admin")){
            HttpSession session =   request.getSession();
            session.setAttribute("username", username);
            request.setAttribute("un", username);
            session.setMaxInactiveInterval(145);

                response.sendRedirect("helloAdmin.jsp"); return;}


        String sha = sha256(password);
        password = sha;

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();
        if(loginDao.validate(loginBean)){
         HttpSession session =   request.getSession();
         session.setAttribute("username", username);
            request.setAttribute("un", username);
            session.setMaxInactiveInterval(145);


            response.sendRedirect("loginSuccess.jsp");
        }else {response.sendRedirect("tryagain.jsp");}
    }
    }




    public static String sha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex); } return hexString.toString();
        } catch(Exception ex){
            log.error("Ошибка", ex);
            throw new RuntimeException(ex);
        }
    }



}
