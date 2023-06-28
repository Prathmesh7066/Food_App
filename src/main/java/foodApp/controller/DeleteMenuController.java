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

@WebServlet("/delete")
public class DeleteMenuController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		int id2 = Integer.parseInt(id);

		MenuDao dao = new MenuDao();
		boolean result = dao.deleteMenu(id2);
		if (result) {
			List<Menu> menus = dao.getAllMenus();
			req.setAttribute("menus", menus);
			RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
			rd.forward(req, resp);
		}

	}

}
