package ru.innopolis.course.java2016.girevoy.home.web.servlets.registration;

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
public class Redact extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieEmail = "userEmail";
		Cookie[] cookies = request.getCookies();
		Cookie myCookie = null;
		for (Cookie cookie : cookies){
			if (cookieEmail.equals(cookie.getName())) {
				myCookie = cookie;
				break;
			}
		}
		try {
			UserAccount userAccount = UserAccountService.getUserFromDatabase(myCookie.getValue());
			request.setAttribute("email",userAccount.getEmail());
			request.setAttribute("firstname",userAccount.getFirstname());
			request.setAttribute("lastname",userAccount.getLastname());
			request.setAttribute("middlename",userAccount.getMiddlename());

		} catch (FindUserInDBExeption findUserInDBExeption) {
			findUserInDBExeption.printStackTrace();
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/web/content/registration/redact.jsp");
		requestDispatcher.forward(request,response);
	}
}
