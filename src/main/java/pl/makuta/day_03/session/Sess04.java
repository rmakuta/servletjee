package pl.makuta.day_03.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sess04")
public class Sess04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plank;charset=UTF-8");

        CartItem cartItem = new CartItem(req.getParameter("name"), Integer.parseInt(req.getParameter("quantity")),
                Double.parseDouble(req.getParameter("price")));
        List<CartItem> cartItems = new ArrayList<>();

        HttpSession session = req.getSession();
        if(session.getAttribute("cartItems") == null){
            cartItems.add(cartItem);
            double sum = 0.0;
            for (CartItem c: cartItems){
                resp.getWriter().println(c.getName() + " - " + c.getQuantity() + " x " + c.getPrice() + " zł = " + c.getQuantity()*c.getPrice() + " zł");
                sum += c.getQuantity()*c.getPrice();
            }
            resp.getWriter().println("                    SUMA: " + sum + " zł");
            session.setAttribute("cartItems", cartItems);
        }else {
            cartItems = (List<CartItem>) session.getAttribute("cartItems");
            cartItems.add(cartItem);
            double sum = 0.0;
            for (CartItem c: cartItems){
                resp.getWriter().println(c.getName() + " - " + c.getQuantity() + " x " + c.getPrice() + " zł = " + c.getQuantity()*c.getPrice() +" zł");
                sum += c.getQuantity()*c.getPrice();
            }
            resp.getWriter().println("                    SUMA: " + sum + " zł");
            session.setAttribute("cartItems", cartItems);
        }
    }
}
