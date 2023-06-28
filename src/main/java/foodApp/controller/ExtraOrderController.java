package foodApp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodApp.dao.MenuDao;
import foodApp.dto.Menu;

@WebServlet("/foodorder")
public class ExtraOrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDao dao = new MenuDao();
		List<Menu> menus = dao.getAllMenus();
		
		req.setAttribute("menus", menus);
		RequestDispatcher rd = req.getRequestDispatcher("staff.jsp");
		rd.forward(req, resp);
	}

}
