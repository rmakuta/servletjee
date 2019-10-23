package pl.makuta.day_03.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        boolean isCookie = true;
        for(Cookie c: cookies){
            if("cookie51".equals(c.getName())){
                c.setMaxAge(0);
                resp.addCookie(c);
                resp.getWriter().println("Witamy na stronie Cookie52.");
                isCookie = false;
            }
        }
        if(isCookie){
            String msg = "FirstVisitCookie51";
            resp.sendRedirect("cookie51?msg=" + URLEncoder.encode(msg, "UTF-8"));
        }
    }
}
