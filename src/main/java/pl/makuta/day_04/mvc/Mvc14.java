package pl.makuta.day_04.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc14")
public class Mvc14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/mvc/form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        List<Book> books = new ArrayList<>();
        for(int i=1; i<=5; i++){
            Book book = new Book(req.getParameter("title"+i), req.getParameter("author"+i),
                    Integer.parseInt(req.getParameter("isbn"+i)));
            books.add(book);
        }

        req.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/mvc/result.jsp").forward(req, resp);
    }
}
