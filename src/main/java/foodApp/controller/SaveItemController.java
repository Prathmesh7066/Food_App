package foodApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import foodApp.dto.Menu;
import foodApp.dao.MenuDao;

@WebServlet("/item")
public class SaveItemController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		int id2 = Integer.parseInt(id);

		MenuDao dao = new MenuDao();
		Menu menu = dao.getMenuById(id2);

		if (menu != null) {
			req.setAttribute("menu", menu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("item.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
