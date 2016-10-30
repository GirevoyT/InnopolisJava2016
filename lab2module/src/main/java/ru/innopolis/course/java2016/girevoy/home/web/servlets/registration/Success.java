package ru.innopolis.course.java2016.girevoy.home.web.servlets.registration;

import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.CreateUserExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.WriteUserToDBExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.models.UserAccount;
import ru.innopolis.course.java2016.girevoy.home.web.profile.services.UserAccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Arxan on 30.10.2016.
 */
public class Success extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserAccount userAccount = UserAccountService.createUserAccount(request.getParameter("email"),
					request.getParameter("password"),
					request.getParameter("firstname"),
					request.getParameter("lastname"),
					request.getParameter("middlename"));
			response.getWriter().print("OK");
			UserAccountService.writeNewUserToDatabase(userAccount);
		} catch (CreateUserExeption createUserExeption) {
			createUserExeption.printStackTrace();
		} catch (WriteUserToDBExeption writeUserToDBExeption) {
			writeUserToDBExeption.printStackTrace();
		}

	}
}
