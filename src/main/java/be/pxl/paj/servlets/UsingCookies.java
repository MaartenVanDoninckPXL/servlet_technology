package be.pxl.paj.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookies", value = "/Cookies")
public class UsingCookies extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("A Web Page");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY");

        Cookie[] cookies = request.getCookies();

        for (int loopIndex = 0; loopIndex < cookies.length; loopIndex++) {
            Cookie cookie1 = cookies[loopIndex];
            if (cookie1.getName().equals("color")) {
                out.println("bgcolor = " + cookie1.getValue());
            }
        }

        Cookie cookie1 = new Cookie("color", Integer.toHexString((int) (Math.random() * 0x1000000)));
        cookie1.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie1);

        out.println(">");
        out.println("<H1>Setting and Reading Cookies</H1>");
        out.println("This page will set its background color using a cookie when reloaded.");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}

