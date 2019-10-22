package pl.makuta.day_03.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get1")
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            for(int i=Integer.parseInt(req.getParameter("start")); i<=Integer.parseInt(req.getParameter("end")); i++){
                resp.getWriter().print(i + " ");
            }
        }catch (NumberFormatException e){
            resp.getWriter().println("BRAK");
        }

    }
}
