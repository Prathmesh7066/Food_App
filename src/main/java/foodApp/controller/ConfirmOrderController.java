package foodApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodApp.dao.ItemsDao;
import foodApp.dto.Items;

@WebServlet("/saveorder")
public class ConfirmOrderController extends HttpServlet {
	static List<Items> list = new ArrayList<Items>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String offer = req.getParameter("offer");
		String quantity = req.getParameter("quantity");

		long price2 = Long.parseLong(price);
		long quantity2 = Long.parseLong(quantity);

		Items items = new Items();
		items.setName(name);
		items.setDescription(description);
		items.setPrice(price2);
		items.setOffer(offer);
		items.setQuantity(quantity2);

		ItemsDao itemsDao = new ItemsDao();
		Items items2 = itemsDao.saveItems(items);
		list.add(items2);

		if (items2 != null) {
			req.setAttribute("list", list);
			req.setAttribute("user", SaveUserController.user);

			RequestDispatcher rd = req.getRequestDispatcher("foodorder.jsp");
			rd.forward(req, resp);
		}
	}

}
