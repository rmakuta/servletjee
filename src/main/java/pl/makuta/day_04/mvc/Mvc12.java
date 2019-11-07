package pl.makuta.day_04.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc12")
public class Mvc12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("start", Integer.parseInt(req.getParameter("start"))+10);
        req.setAttribute("end", Integer.parseInt(req.getParameter("end"))+10);
        getServletContext().getRequestDispatcher("/mvc/jsp2.jsp").forward(req, resp);
    }
}
