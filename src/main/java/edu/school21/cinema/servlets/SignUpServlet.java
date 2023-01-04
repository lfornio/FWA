package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.AppExceptions;
import edu.school21.cinema.models.Fields;
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
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private static final String SIGN_UP_PAGE = "/WEB-INF/jsp/SignUp.jsp";

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.usersService = springContext.getBean(UsersServiceImpl.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(SIGN_UP_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter(Fields.EMAIL.getValue());
        String firstName = req.getParameter(Fields.FIRST_NAME.getValue());
        String lastName = req.getParameter(Fields.LAST_NAME.getValue());
        String phoneNumber = req.getParameter(Fields.PHONE_NUMBER.getValue());
        String password = req.getParameter(Fields.PASSWORD.getValue());
        try {
            usersService.signUp(email, firstName, lastName, phoneNumber, password);
        } catch (AppExceptions ex) {
            doGet(req, resp);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}