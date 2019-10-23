package pl.makuta.day_03.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sess01get")
public class Sess01Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("counter") != null){
        Integer counter = (Integer) session.getAttribute("counter");
        resp.getWriter().println("Licznik: " + counter);
        session.setAttribute("counter", ++counter);
        }else {
            resp.getWriter().println("EMPTY");
        }
    }
}
