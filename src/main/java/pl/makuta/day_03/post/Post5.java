package pl.makuta.day_03.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post5")
public class Post5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int temp = Integer.parseInt(req.getParameter("degrees"));
        String units = req.getParameter("convertionType");

        if(units.equals("celcToFahr")){//<html>x<sup>2</sup></html>
            resp.getWriter().print("<html>" + temp + " <sup>o</sup>C to " + (32+((9*temp)/5)) + " <sup>o</sup>F</html>");
        }else{
            resp.getWriter().print("<html>" + temp + " <sup>o</sup>F to " + ((5*(temp-32))/9) + " <sup>o</sup>C</html>");
        }
    }
}
