package be.pxl.paj.servlets;

import be.pxl.paj.servlets.service.BeerExpert;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/SelectBeer.do")
public class SelectBeerServlet extends HttpServlet {
    private final BeerExpert beerExpert;

    @Autowired
    public SelectBeerServlet(BeerExpert beerExpert) {
        this.beerExpert = beerExpert;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");

        List<String> result = beerExpert.getBrands(color);
        PrintWriter writer = resp.getWriter();

        writer.println("<html>" +
                "<body>" +
                "<h1 style=\"text-align:center\">Try these beers:</h1><p>" +
                String.join(", ", result) +
                "</p></body>" +
                "</html>");
    }
}
