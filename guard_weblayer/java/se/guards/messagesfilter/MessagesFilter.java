package se.guards.messagesfilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <code>MessagesFilter</code> is a simple <code>Filter</code> implementation
 * used to insure that any messages are not lost during redirects. Borrowed
 * from Matt Raible and Appfuse Lite (http://appfuse-light.dev.java.net).
 */
public class MessagesFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        // grab messages from the session and put them into request
        // this is so they're not lost in a redirect
        Object message = request.getSession().getAttribute("message");
        if (message != null) {
            request.setAttribute("message", message);
            request.getSession().removeAttribute("message");
        }
        // set the requestURL as a request attribute for templates
        // particularly freemarker, which doesn't allow request.getRequestURL()
        request.setAttribute("requestURL", request.getRequestURL());
        request.setAttribute("requestURI", request.getRequestURI());
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
} 