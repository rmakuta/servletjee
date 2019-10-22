package pl.makuta.day_03.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get4")
public class Get4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number = Integer.parseInt(req.getParameter("page"));
        resp.getWriter().print("Dzielniki liczby " + number + ": ");
        for (int i=1; i<=number; i++){
            if(number % i == 0){
                resp.getWriter().print(i + " ");
            }
        }
    }
}
