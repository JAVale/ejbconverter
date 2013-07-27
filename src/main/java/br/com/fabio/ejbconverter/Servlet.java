package br.com.fabio.ejbconverter;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebServlet(name = "Servlet", urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    @EJB
    private BeanConverter converter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        if (amount != null && amount.length() > 0) {
            response.setContentType(MediaType.TEXT_PLAIN);
            PrintWriter out = response.getWriter();

            BigDecimal d = new BigDecimal(amount);

            BigDecimal yenAmount = converter.dollarToYen(d);
            out.println("yenAmount: "+yenAmount);

            BigDecimal euroAmount = converter.yenToEuro(yenAmount);
            out.println("euroAmount: "+euroAmount);
        }
    }
}