package server;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FreeMarkerUtil {
    private static Configuration cfg;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassForTemplateLoading(FreeMarkerUtil.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");
    }

    public static void render(HttpServletResponse resp, String template, Map<String, Object> data) throws IOException {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            cfg.getTemplate(template).process(data, resp.getWriter());
        } catch (TemplateException e) {
            throw new IOException(e);
        }
    }
}