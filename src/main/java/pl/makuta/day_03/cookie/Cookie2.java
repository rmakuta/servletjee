package pl.makuta.day_03.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCookie")
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie(req.getParameter("key"), req.getParameter("value"));
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
        resp.sendRedirect("/showCookie");
    }
}
