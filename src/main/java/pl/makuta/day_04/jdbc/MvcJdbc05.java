package pl.makuta.day_04.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-book")
public class MvcJdbc05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Book book = BookDao.read(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book", book);
        getServletContext().getRequestDispatcher("/jdbc/edit-book.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Book book = new Book(req.getParameter("title"),
                req.getParameter("author"),
                Integer.parseInt(req.getParameter("isbn")),
                        Integer.parseInt(req.getParameter("id")));

        BookDao.update(book);
        resp.sendRedirect("/all-books");
    }
}
