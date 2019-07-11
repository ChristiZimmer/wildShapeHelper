package controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet{
	private WildShapeController wildShapeController;
	private static final Logger log = Logger.getRootLogger();

	@Override
	public void init() throws ServletException {
		wildShapeController = new WildShapeController();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.doDispatch(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.doDispatch(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.doDispatch(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		String requestURI = req.getRequestURI();
		log.debug("FrontController: " + requestURI);
		switch(requestURI){
			case "/wildShapeHelper/getAll.do":{
				wildShapeController.getAll(req, resp);
				break;
			}
			default:{
				throw new IllegalArgumentException("Invalid URI {" + requestURI + "}");
			}
		}
	}
}
