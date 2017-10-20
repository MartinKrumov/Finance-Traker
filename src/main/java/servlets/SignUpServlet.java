package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import dao.classes.UserDAO;
import model.User;

/**
 * Servlet implementation class SignUpServlet
 */
//@WebServlet("/signups")
// @javax.servlet.annotation.MultipartConfig
// @MultipartConfig
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pr = response.getWriter();
		String firstName = new String(StringEscapeUtils.escapeHtml(request.getParameter("fname")));
		String lastName = new String(StringEscapeUtils.escapeHtml(request.getParameter("lname")));
		String email = new String(StringEscapeUtils.escapeHtml(request.getParameter("email")));
		char[] pass = StringEscapeUtils.escapeHtml(request.getParameter("pass")).toCharArray();
		String username = new String(StringEscapeUtils.escapeHtml(request.getParameter("uname")));

		pr.println(request.getParameter("fname"));
		pr.println(lastName);
		pr.println(email);
		pr.println(pass);
		pr.println(username);

<<<<<<< HEAD
		if (!UserDAO.checkIfExists(email)) {
			User user = new User(fname, lname, email, pass);
=======
		if (!UserDAO.checkIfExists(email) && request.getSession(false) == null) {
			User user = new User(username, pass, email, firstName, lastName);
>>>>>>> fb39693ed21afe21898db49cd17357eefb46dd01
			PrintWriter out = response.getWriter();

			long userID = UserDAO.insertUser(user);
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("id", (long) userID);
			if (request.getSession(false) != null) {
				response.sendRedirect("./index.jsp");
			}
			out.close();
		} else {
			response.sendRedirect("./index.html?error=userEmailExists");
		}
		response.setContentType("text/html");

	}
}
