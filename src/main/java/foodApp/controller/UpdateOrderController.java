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

@WebServlet("/updateorder")
public class UpdateOrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int id2 = Integer.parseInt(id);

		ItemsDao dao = new ItemsDao();
		Items items = dao.getItemsById(id2);

		if (items != null) {
            req.setAttribute("items", items);
            
            RequestDispatcher rd = req.getRequestDispatcher("updateorder.jsp");
            rd.forward(req, resp);
		}
	}

}
