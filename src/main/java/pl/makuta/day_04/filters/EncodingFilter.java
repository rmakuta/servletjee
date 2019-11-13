package pl.makuta.day_04.filters;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.Filter;

public class EncodingFilter implements Filter {
    private String charsetEncoding = "utf-8";
    private String contentType = "text/html";
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(charsetEncoding);
        response.setContentType(contentType);
        response.setCharacterEncoding(charsetEncoding);
        filterChain.doFilter(request, response);
    }
    public void destroy() {}
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("charsetEncoding");
        String charsetParam = filterConfig.getInitParameter("contentType");
        if (encodingParam != null && charsetParam!= null){
            contentType = encodingParam;
            charsetEncoding = charsetParam;
        }
    }
}
