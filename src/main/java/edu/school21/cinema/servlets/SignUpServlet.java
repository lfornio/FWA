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

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private static final String url = "/WEB-INF/html/SignUp.html";

    private UsersService usersService;
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
    String email = req.getParameter("email");
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    String phoneNumber = req.getParameter("phoneNumber");
    String password = req.getParameter("password");
    usersService.signUp(email, firstName, lastName, phoneNumber, password);


    }
}