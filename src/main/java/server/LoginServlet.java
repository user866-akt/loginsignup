package server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FreeMarkerUtil.render(resp, "login.ftl", new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (SignUpServlet.checkUser(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            resp.sendRedirect("main");
        } else {
            resp.sendRedirect("/login");
        }
    }
}