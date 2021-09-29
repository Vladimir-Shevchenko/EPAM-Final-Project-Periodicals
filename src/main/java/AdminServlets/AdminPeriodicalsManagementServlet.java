package AdminServlets;

import database.AdminPeriodicalsDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminPeriodicalsManagementServlet", value = "/AdminPeriodicalsManagementServlet")
public class AdminPeriodicalsManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if( request.getParameter("deleteId")!=null) {
            AdminPeriodicalsDao.deletePeriodical(request.getParameter("deleteId"));
            response.sendRedirect("AdminPeriodicalsServlet");
        }else if(request.getParameter("editId")!=null){}
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  /////ADD
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String type = request.getParameter("type");
        String description = request.getParameter("description");

        if(name!=null||price!=null||type!=null||description!=null) {
            if (name.equals("") || price.equals("") || type.equals("") || description.equals("")) {
                response.getWriter().println("Please fill all fields!");
            } else {
                AdminPeriodicalsDao.addPeriodical(name, price, type, description);
                response.sendRedirect("AdminPeriodicalsServlet");
            }
        }
//////EDIT
        String id = request.getParameter("Id");
        String editedName = request.getParameter("editedName");
        String editedPrice = request.getParameter("editedPrice");
        String editedType = request.getParameter("editedType");
        String editedDescription = request.getParameter("editedDescription");
        System.out.println(id+editedName+editedPrice+editedType+editedDescription);

        if(editedName==null||editedName.equals("")||editedPrice.equals("")||editedType.equals("")||editedDescription.equals("")) {
            response.getWriter().println("Please fill all fields!");
        }else{ AdminPeriodicalsDao.editPeriodical(id, editedName, editedPrice, editedType, editedDescription);
            response.sendRedirect("AdminPeriodicalsServlet");}
    }
}
