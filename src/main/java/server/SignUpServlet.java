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
        FreeMarkerUtil.render(resp, "signup.ftl", new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        users.put(login, password);

        HttpSession session = req.getSession();
        session.setAttribute("user", login);
        resp.sendRedirect("main");
    }

    public static boolean checkUser(String login, String password) {
        return users.containsKey(login) && users.get(login).equals(password);
    }
}