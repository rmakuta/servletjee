package pl.makuta.day_04.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-book")
public class MvcJdbc01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<form action='' method='post'>");
        out.print("Tytuł: <input type='text' name='title'>");
        out.print("Autor: <input type='text' name='author'>");
        out.print("ISBN: <input type='number' name='isbn'>");
        out.print("<input type='submit' value='Wyślij'>");
        out.print("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Book book = new Book(req.getParameter("title"), req.getParameter("author"),
                Integer.parseInt(req.getParameter("isbn")));
        BookDao.create(book);
    }
}
