package server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (SignUpServlet.checkUser(login, password)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", login);
            httpSession.setMaxInactiveInterval(60 * 60);

            Cookie cookie = new Cookie("user", login);
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);

            resp.sendRedirect("main.jsp");
        } else {
            resp.sendRedirect("/login");
        }
    }
}