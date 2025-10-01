package server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }

        Map<String, Object> data = new HashMap<>();
        data.put("user", session.getAttribute("user"));
        data.put("sessionId", session.getId());

        FreeMarkerUtil.render(resp, "main.ftl", data);
    }
}