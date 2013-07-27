package br.com.fabio.ejbconverter;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
@Stateless
public class Service implements Serializable {

    @EJB
    private BeanConverter converter;

    private Integer cont = 0;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String doGet(@QueryParam("amount") String amount) {
        StringBuilder out = new StringBuilder();

        BigDecimal d = new BigDecimal(amount);

        BigDecimal yenAmount = converter.dollarToYen(d);
        out.append("yenAmount: ");
        out.append(yenAmount);
        out.append("\n");

        BigDecimal euroAmount = converter.yenToEuro(yenAmount);
        out.append("euroAmount: ");
        out.append(euroAmount);
        out.append("\n");

        System.out.println(cont++);

        return out.toString();
    }
}