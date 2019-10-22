package pl.makuta.day_03.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get5")
public class Get5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company = req.getParameter("company");
        resp.getWriter().println("company: ");
        resp.getWriter().println(" -" + company);

        String[] learn = req.getParameterValues("learn");
        resp.getWriter().println("learn: ");
        for (String s: learn){
            resp.getWriter().println(" -" + s);
        }
    }
}
