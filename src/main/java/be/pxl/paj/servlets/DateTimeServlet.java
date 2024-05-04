package be.pxl.paj.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@WebServlet(value = "/DateTimeServlet")
public class DateTimeServlet extends HttpServlet {
    private static final DateTimeFormatter FORMATTER_EN = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
    private static final DateTimeFormatter FORMATTER_NL = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy HH:mm:ss", new Locale("nl"));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        String language = req.getParameter("lang");
        LocalDateTime dateTime = LocalDateTime.now();
        String dateAsText = "nl".equals(language) ? FORMATTER_NL.format(dateTime) : FORMATTER_EN.format(dateTime);
        writer.println("<html>" +
                "<body>" +
                "<h1 style=\"text-align:center\">" + dateAsText + "</h1></body>" +
                "</html>");
    }
}
