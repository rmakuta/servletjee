package pl.makuta.day_03.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get3")
public class Get3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int height, width;

        try{
            height = Integer.parseInt(req.getParameter("height"));
            width = Integer.parseInt(req.getParameter("width"));
        }catch (NumberFormatException e){
            width = 5;
            height = 10;
        }

        for (int i = 0; i<=width; i++){
            if(i < 10){
                resp.getWriter().print(" ");
            }
            resp.getWriter().print(i + " ");
        }
        resp.getWriter().println();
        int x = 1;
        for(int i = 1; i <= height; i++){
            if(x<10){
                resp.getWriter().print(" " + x++ + " ");
            }else{
                resp.getWriter().print(x++ + " ");
            }
            for(int j = 1; j <= width; j++){
                if(i*j < 10){
                    resp.getWriter().print(" ");
                }
                resp.getWriter().print(i*j + " ");
            }
            resp.getWriter().println();
        }
    }
}
