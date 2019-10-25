package pl.makuta.day_03.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/sess05")
public class Sess05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Random random = new Random();
        int x = random.nextInt(101);
        int y = random.nextInt(101);

        PrintWriter out = resp.getWriter();
        out.println("<form action=\"\" method=\"POST\">\n");
        out.println("<label> Imię: <input type=\"text\" name=\"name\"></label>");
        out.println("<label> Nazwisko: <input type=\"text\" name=\"surname\"></label>");
        out.println("<label> Email: <input type=\"text\" name=\"email\"></label></br>");
        out.println("<label> Wpisz poniżej sumę " + x + " + " + y + ": </br><input type=\"number\" name=\"captcha\"></label>");
        out.println("<input type=\"submit\">");
        out.println("</form>");

        HttpSession session = req.getSession();
        session.setAttribute("captcha", x+y);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int captchaFromSession = (int) session.getAttribute("captcha");
        int captchaFromForm = Integer.parseInt(req.getParameter("captcha"));
        if(captchaFromSession == captchaFromForm){
            resp.getWriter().println("Captcha is oK!");
        }else {
            resp.getWriter().println("Captcha is bad!");
        }
    }
}
