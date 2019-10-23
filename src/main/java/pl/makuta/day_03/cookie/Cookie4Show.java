package pl.makuta.day_03.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Cookie[] cookies = req.getCookies();
        if(cookies !=null){
            for(Cookie cookie: cookies){
                resp.getWriter().println("<a href=/removeCookie?" + cookie.getName() + "> usun: " + cookie.getName() + "</a>");
                resp.getWriter().println();
            }
        }
    }
}
