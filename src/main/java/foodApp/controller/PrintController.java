package foodApp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodApp.dao.FoodOrderDao;
import foodApp.dao.UserDao;
import foodApp.dto.FoodOrder;
import foodApp.dto.Items;
import foodApp.dto.User;

@WebServlet("/print")
public class PrintController extends HttpServlet {
	static FoodOrder foodOrder = new FoodOrder();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");

		long phone2 = Long.parseLong(phone);
		List<Items> items = ConfirmOrderController.list;

		foodOrder.setName(name);
		foodOrder.setEmail(email);
		foodOrder.setAddress(address);
		foodOrder.setPhone(phone2);
		foodOrder.setItems(items);

		HttpSession hs = req.getSession();
		int id = (Integer) hs.getAttribute("id");

		UserDao dao = new UserDao();
		User user = dao.getUserById(id);
		foodOrder.setUser(user);
		
		FoodOrderDao foodOrderDao = new FoodOrderDao();
		FoodOrder foodOrder2 = foodOrderDao.saveFoodOrder(foodOrder);
		
		if(foodOrder2!=null) {
			HttpSession session = req.getSession();
			int id2 = (Integer) session.getAttribute("id");
			if(id2!=0) {
				req.setAttribute("foodorder", foodOrder2);
				req.setAttribute("message", "Thank You!!! Visit Again!!");
				
				RequestDispatcher rd = req.getRequestDispatcher("end.jsp");
				rd.forward(req, resp);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
		}

	}

}
