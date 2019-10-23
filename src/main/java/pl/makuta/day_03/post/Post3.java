package pl.makuta.day_03.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post3")
public class Post3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        Integer a = Integer.parseInt(req.getParameter("a"));
        Integer b = Integer.parseInt(req.getParameter("b"));
        Integer c = Integer.parseInt(req.getParameter("c"));

        resp.getWriter().println("a = " + a + ", b = " + b + ", = " + c);
    }
}
