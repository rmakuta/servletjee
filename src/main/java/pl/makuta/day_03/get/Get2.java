package pl.makuta.day_03.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/get2")
public class Get2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> key = parameterMap.keySet();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String k = entry.getKey();
            String[] value = entry.getValue();
            resp.getWriter().print(k + ": ");
            for (String s: value){
                resp.getWriter().print(s + " ");
            }
            resp.getWriter().println();
        }
    }
}
