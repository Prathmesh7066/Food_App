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

@WebServlet("/savemenu")
public class SaveMenuController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String offer = req.getParameter("offer");

		long price1 = Long.parseLong(price);

		Menu menu = new Menu();
		menu.setName(name);
		menu.setDescription(description);
		menu.setPrice(price1);
		menu.setOffer(offer);

		MenuDao menuDao = new MenuDao();
		Menu menu2 = menuDao.saveMenu(menu);

		if (menu2 != null) {
			List<Menu> menus = menuDao.getAllMenus();
			req.setAttribute("menus", menus);
			RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
			rd.forward(req, resp);
		}

	}

}
