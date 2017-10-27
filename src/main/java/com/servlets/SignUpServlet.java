package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import com.dao.classes.UserDAO;
import com.model.User;
//https://www.youtube.com/watch?v=72iphdxQxrk
//https://www.youtube.com/watch?v=T4NTdRvIrdk


/**
 * Servlet implementation class SignUpServlet
 */
//@WebServlet("/signups")
// @javax.servlet.annotation.MultipartConfig
// @MultipartConfig
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(saaasa, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pr = response.getWriter();
        String firstName = new String(StringEscapeUtils.escapeHtml(request.getParameter("fname")));
        String lastName = new String(StringEscapeUtils.escapeHtml(request.getParameter("lname")));
        String email = new String(StringEscapeUtils.escapeHtml(request.getParameter("email")));
        String pass = new String(StringEscapeUtils.escapeHtml(request.getParameter("pass")));
        String username = new String(StringEscapeUtils.escapeHtml(request.getParameter("uname")));

        pr.println(firstName);
        pr.println(lastName);
        pr.println(email);
        pr.println(pass);
        pr.println(username);

        if ( !UserDAO.checkIfExists(email) && request.getSession(false) == null ) {
            User user = new User(username, pass, email, firstName, lastName);
            PrintWriter out = response.getWriter();

            long userID = UserDAO.insertUser(user);
            System.out.println(" userID " + userID);
            if ( userID > 0 ) {
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("user_id", ( long ) userID);
                request.getSession(false).setAttribute("rights", ( long ) 3);
                response.sendRedirect("./index.jsp");
                out.close();
            } else {
                response.sendRedirect("./index.html?error=userEmailExists");
                out.close();
                return;
            }

        } else {
            response.sendRedirect("./index.html?error=userEmailExists");
        }
        response.setContentType("text/html");
    }
}
