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

@WebServlet("/deleteorder")
public class DeleteOrderController extends HttpServlet {
	static Items items3;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		int id2 = Integer.parseInt(id);
		ItemsDao itemsDao = new ItemsDao();
		for (Items items2 : ConfirmOrderController.list) {
			if (id2 == items2.getId()) {
				items3 = items2;
			}
		}
		ConfirmOrderController.list.remove(items3);
		boolean result = itemsDao.deleteItems(id2);
		if (result) {
			req.setAttribute("list", ConfirmOrderController.list);
			req.setAttribute("user", SaveUserController.user);

			RequestDispatcher rd = req.getRequestDispatcher("foodorder.jsp");
			rd.forward(req, resp);
		}

	}

}
