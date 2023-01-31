package edu.school21.cinema.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/signIn", "/signUp"})
public class SignInSignUpFilter implements Filter {
    private static final String PROFILE = "/profile";

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session.getAttribute("user") != null) {
            ((HttpServletResponse) servletResponse).sendRedirect(PROFILE);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
