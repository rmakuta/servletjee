package pl.makuta.day_03.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/post4")
public class Post4 extends HttpServlet {

    Random r = new Random();
    int max = r.nextInt(6)+5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("<form action='' method='post'>");

        for (int i = 0; i < max; i++) {
            resp.getWriter().println("<p>numbers: <input name='numbers'/><br/></p>");
        }
        resp.getWriter().println("<input type='submit'/>");
        resp.getWriter().println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        try {
        String[] num = req.getParameterValues("numbers");
        List<Integer> n = new ArrayList<>();

            for(int i = 0; i < num.length; i++){
                n.add(Integer.parseInt(num[i]));
            }
            n.sort(null);
            for (Integer elem: n) {
                resp.getWriter().print(elem + " ");
            }
        }catch (NumberFormatException e){
            resp.getWriter().println(e.getMessage());
            resp.getWriter().print("Czyli czegoś tutaj brakuje.");
        }
    }
}
