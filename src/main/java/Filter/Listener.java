package Filter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebListener
public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (sce.getServletContext().getRequestCharacterEncoding()==null) {
            sce.getServletContext().setRequestCharacterEncoding("UTF-8");
        }
    }
}