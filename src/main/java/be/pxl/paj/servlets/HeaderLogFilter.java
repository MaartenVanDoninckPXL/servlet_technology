package be.pxl.paj.servlets;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;

@WebFilter(urlPatterns = {"/SelectBeer.do"})
public class HeaderLogFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(HeaderLogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        LOGGER.info("--------- Request ---------");
        Collections.list(req.getHeaderNames()).forEach(n -> LOGGER.info(n + ": " + req.getHeader(n)));

        chain.doFilter(request, response);

        LOGGER.info("--------- response ---------");

        rep.getHeaderNames().forEach(n -> LOGGER.info(n + ": " + rep.getHeader(n)));

        LOGGER.info("response status: " + rep.getStatus());
    }
}
