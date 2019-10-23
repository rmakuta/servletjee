package pl.makuta.day_03.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post2")
public class Post2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        String text = req.getParameter("text");
        String aware = req.getParameter("aware");

        if(aware != null && aware.equals("yes")){
            resp.getWriter().println(text);
        }else {
            resp.getWriter().println(text.replaceAll("cholera", "*******"));
        }
    }
}
