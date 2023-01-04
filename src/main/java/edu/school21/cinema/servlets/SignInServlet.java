package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.AppExceptions;
import edu.school21.cinema.services.Impl.PasswordEncoderServiceImpl;
import edu.school21.cinema.services.Impl.UsersServiceImpl;
import edu.school21.cinema.services.PasswordEncoderService;
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
import java.sql.SQLException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private static final String URL = "/WEB-INF/jsp/SignIn.jsp";

    private UsersService usersService;
//    private PasswordEncoderService passwordEncodeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.usersService = springContext.getBean(UsersServiceImpl.class);
//        this.passwordEncodeService = springContext.getBean(PasswordEncoderServiceImpl.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(URL);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            usersService.signIn(email, password);
        } catch (AppExceptions e) {
            doGet(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}