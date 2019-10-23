package pl.makuta.day_03.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/removeCookie")
public class Cookie4Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> cookiesAsParam =req.getParameterMap();
        for(String param: cookiesAsParam.keySet()){
            Cookie cookie = new Cookie(param, "");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().println("Done! Cookie \"" + param + "\" usuniete.");
        }
    }
}
