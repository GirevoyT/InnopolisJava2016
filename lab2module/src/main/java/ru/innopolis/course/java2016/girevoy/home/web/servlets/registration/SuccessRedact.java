package ru.innopolis.course.java2016.girevoy.home.web.servlets.registration;

import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.FindUserInDBExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.WriteUserToDBExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.models.UserAccount;
import ru.innopolis.course.java2016.girevoy.home.web.profile.services.UserAccountService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Arxan on 30.10.2016.
 */
public class SuccessRedact extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserAccount userAccount = UserAccountService.getUserFromDatabase(request.getParameter("oldEmail"));
			userAccount.setFirstname(request.getParameter("firstname"));
			userAccount.setLastname(request.getParameter("lastname"));
			userAccount.setMiddlename(request.getParameter("middlename"));
			userAccount.setEmail(request.getParameter("email"));
			userAccount.setOldEmail(request.getParameter("oldEmail"));
			UserAccountService.changeUserInDatabase(userAccount);
			Cookie cookie = new Cookie ("userEmail",request.getParameter("email"));
			cookie.setMaxAge(24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
			response.getWriter().write("OK");
		} catch (WriteUserToDBExeption writeUserToDBExeption) {
			writeUserToDBExeption.printStackTrace();
		} catch (FindUserInDBExeption findUserInDBExeption) {
			findUserInDBExeption.printStackTrace();
		}
	}
}
