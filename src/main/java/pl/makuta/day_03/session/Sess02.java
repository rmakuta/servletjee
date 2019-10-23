package pl.makuta.day_03.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sess02")
public class Sess02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        if(session.getAttribute("scores") == null){
            session.setAttribute("scores", new ArrayList<Double>());
        }

        PrintWriter out = resp.getWriter();
        out.println(("<form action='' method='post'>"));
        out.println(("Twoja ocena: <input type='text' name='score'>"));
        out.println(("<input type='submit' value='dodaj'>"));
        out.println(("</form>"));

        out.println(("<h2>Twoje oceny</h2>"));
        out.println(("<ul>"));
        List<Double> scores = (List<Double>) session.getAttribute("scores");
        for(Double score: scores){
            out.println("<li>" + score + "</li>");
        }
        out.println(("</ul>"));
        double average = scores.stream().mapToDouble(value->value).average().orElseGet(() -> 0.0);
        out.println("<h2>Twoja średnia: " + average + "</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String scoreParam = req.getParameter("score");

        try{
            Double score = Double.parseDouble(scoreParam);
            HttpSession session = req.getSession();
            List<Double> scores = (List<Double>) session.getAttribute("scores");
            scores.add(score);;
            resp.sendRedirect("/sess02");
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
    }
}
