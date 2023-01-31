package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.AppExceptions;
import edu.school21.cinema.models.Fields;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.Impl.UsersServiceImpl;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private static final String SIGN_IN_PAGE = "/WEB-INF/jsp/SignIn.jsp";
    private static final String PROFILE = "/profile";

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.usersService = springContext.getBean(UsersServiceImpl.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(SIGN_IN_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(Fields.EMAIL.getValue());
        String password = req.getParameter(Fields.PASSWORD.getValue());
        try {
            User user = usersService.signIn(email, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        } catch (AppExceptions e) {
            doGet(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(PROFILE);
    }
}