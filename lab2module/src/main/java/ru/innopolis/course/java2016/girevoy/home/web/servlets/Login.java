package ru.innopolis.course.java2016.girevoy.home.web.servlets;

import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.FindUserInDBExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.models.UserAccount;
import ru.innopolis.course.java2016.girevoy.home.web.profile.services.UserAccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Arxan on 30.10.2016.
 */
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter("todo")) {
			case "login" :
				if (request.getParameter("email") != null && request.getParameter("password") != null) {
					try {
						UserAccount userAccount = UserAccountService.getUserFromDatabase(request.getParameter("email"));
						if (request.getParameter("password").toString().equals(userAccount.getPassword())) {
							request.setAttribute("userName",userAccount.getFirstname() + " " + userAccount.getLastname());
							Cookie cookie = new Cookie ("userEmail",request.getParameter("email"));
							cookie.setMaxAge(24 * 60 * 60);
							response.addCookie(cookie);
							request.setAttribute("isCorrectLogin",new Boolean(true));
							request.setAttribute("userName",userAccount.getFirstname() + " " + userAccount.getLastname());
						} else {
							request.setAttribute("isCorrectLogin",new Boolean(false));
						}

					} catch (FindUserInDBExeption findUserInDBExeption) {
						request.setAttribute("isCorrectLogin",new Boolean(false));
						findUserInDBExeption.printStackTrace(); //WARNING!!! Обработать
					}
				} else {
					request.setAttribute("isCorrectLogin",new Boolean(false));
				}
				break;
			case "simple":
				String cookieEmail = "userEmail";
				Cookie[] cookies = request.getCookies();
				Cookie myCookie = null;
				for (Cookie cookie : cookies){
					if (cookieEmail.equals(cookie.getName())) {
						myCookie = cookie;
						break;
					}
				}
				if (myCookie != null) {
					try {
						UserAccount userAccount = UserAccountService.getUserFromDatabase(myCookie.getValue());
						request.setAttribute("userName",userAccount.getFirstname() + " " + userAccount.getLastname());
					} catch (FindUserInDBExeption findUserInDBExeption) {
						findUserInDBExeption.printStackTrace(); //WARNING!!! Обработать
					}
				}
				break;
			case "logout":
				Cookie cookie = new Cookie ("userEmail",null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/web/login.jsp");
		requestDispatcher.forward(request,response);
	}
}
