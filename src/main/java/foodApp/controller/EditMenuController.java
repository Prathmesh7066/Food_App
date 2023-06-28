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

@WebServlet("/editmenu")
public class EditMenuController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String offer = req.getParameter("offer");

		long price2 = Long.parseLong(price);
		int id1 = Integer.parseInt(id);

		Menu menu = new Menu();
		menu.setId(id1);
		menu.setName(name);
		menu.setDescription(description);
		menu.setPrice(price2);
		menu.setOffer(offer);

		MenuDao dao = new MenuDao();
		Menu menu2 = dao.updateMenu(menu);

		if (menu2 != null) {
			List<Menu> menus = dao.getAllMenus();
			req.setAttribute("menus", menus);
			RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
			rd.forward(req, resp);
		}
	}

}
