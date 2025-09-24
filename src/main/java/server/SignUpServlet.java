package server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
public class SignUpServlet extends HttpServlet {
    private static final Map<String, String> users = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("signup.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        users.put(login, password);
        HttpSession session = req.getSession();
        session.setAttribute("user", login);
        session.setMaxInactiveInterval(60 * 60);

        Cookie cookie = new Cookie("user", login);
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);

        resp.sendRedirect("main.jsp");
    }
    public static boolean checkUser(String login, String password) {
        String storedPassword = users.get(login);
        return storedPassword != null && storedPassword.equals(password);
    }
}