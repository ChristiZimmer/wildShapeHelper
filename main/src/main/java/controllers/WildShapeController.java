package controllers;

import beans.Beast;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import services.BeastService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class WildShapeController {
    private BeastService beastService = new BeastService();
    private static final Logger log = Logger.getRootLogger();

    public void getAll(HttpServletRequest req, HttpServletResponse resp) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
        log.trace("getAll");
        Collection<Beast> beasts = beastService.getAllBeasts();
        new ObjectMapper().writeValue(resp.getWriter(), beasts);
    }
}
