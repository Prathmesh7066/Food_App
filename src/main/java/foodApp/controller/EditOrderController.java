package foodApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodApp.dao.ItemsDao;
import foodApp.dto.Items;

@WebServlet("/editorder")
public class EditOrderController extends HttpServlet {
	static Items items3;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String offer = req.getParameter("offer");
		String quantity = req.getParameter("quantity");

		int id2 = Integer.parseInt(id);
		long price2 = Long.parseLong(price);
		long quantity2 = Long.parseLong(quantity);

		Items items = new Items();
		items.setId(id2);
		items.setName(name);
		items.setDescription(description);
		items.setPrice(price2);
		items.setOffer(offer);
		items.setQuantity(quantity2);

		ItemsDao dao = new ItemsDao();
		for (Items items2 : ConfirmOrderController.list) {
			if (id2 == items2.getId()) {
				items3 = items2;
			}
		}
		ConfirmOrderController.list.remove(items3);

		Items items2 = dao.updateItems(items);

		ConfirmOrderController.list.add(items2);
		if (items2 != null) {
			req.setAttribute("list", ConfirmOrderController.list);
			req.setAttribute("user", SaveUserController.user);
			RequestDispatcher rd = req.getRequestDispatcher("foodorder.jsp");
			rd.forward(req, resp);
		}

	}

}
