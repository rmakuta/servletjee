package pl.makuta.day_04.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search-book")
public class MvcJdbc04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<form action='' method='post'>");
        out.print("ID: <input type='number' name='id'>");
        out.print("<input type='submit' value='Wyślij'>");
        out.print("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String search = req.getParameter("search");
        boolean contains = false;

        if(search.length() < 1){
            resp.sendRedirect("all-books");
        }else {
            List<Book> books = BookDao.findAll();
            List<Book> searchBooks = new ArrayList<>();
            for (Book b: books){
                if(b.getTitle().contains(search)){
                    searchBooks.add(b);
                    contains = true;
                }
            }
            if(contains){
                req.setAttribute("books", searchBooks);
                getServletContext().getRequestDispatcher("/jdbc/search-books.jsp").forward(req, resp);
            }else {
                resp.sendRedirect("all-books?isTitle=false");
            }
        }
    }
}
