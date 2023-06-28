package foodApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodApp.dao.UserDao;
import foodApp.dto.User;

@WebServlet("/signup")
public class SaveUserController extends HttpServlet {
	static User user;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String role = req.getParameter("role");

		long phone1 = Long.parseLong(phone);
		user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone1);
		user.setAddress(address);
		user.setRole(role);

		UserDao dao = new UserDao();
		User user2 = dao.saveUser(user);

		if (user2 != null) {
			req.setAttribute("message", "Successfully Signed Up");
			RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
			rd.forward(req, resp);

		}
	}

}
