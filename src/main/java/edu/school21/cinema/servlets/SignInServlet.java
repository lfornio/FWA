package edu.school21.cinema.servlets;

import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private static final String url = "/WEB-INF/html/SignIn.html";

//    private UsersService usersService;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        ServletContext context = config.getServletContext();
//        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
//        this.usersService = springContext.getBean(UsersService.class);
//    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String s = req.getParameter("firstName");
//        System.out.println(s);
    }
}